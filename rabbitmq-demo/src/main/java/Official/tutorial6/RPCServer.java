package Official.tutorial6;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by xp-zhao on 2017/12/15.
 */
public class RPCServer
{
	private static final String RPC_QUEUE_NAME = "rpc_queue";

	public static void main(String[] args)
	{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = null;
		try
		{
			connection = factory.newConnection();
			final Channel channel = connection.createChannel();

			channel.queueDeclare(RPC_QUEUE_NAME,false,false,false,null);

			channel.basicQos(1);
			System.out.println("waiting rpc request");

			Consumer consumer = new DefaultConsumer(channel)
			{
				@Override
				public void handleDelivery(String consumerTag , Envelope envelope ,
					AMQP.BasicProperties properties , byte[] body) throws IOException
				{
					AMQP.BasicProperties replyProps = new AMQP.BasicProperties
						.Builder()
						.correlationId(properties.getCorrelationId())
						.build();
					String response = "";
					try
					{
						String message = new String(body,"UTF-8");
						int n = Integer.parseInt(message);
						System.out.println("fib("+message+")");
						response += fib(n);
					}
					catch (RuntimeException e)
					{
						e.printStackTrace();
					}
					finally
					{
						channel.basicPublish("",properties.getReplyTo(),replyProps,response.getBytes("UTF-8"));
						channel.basicAck(envelope.getDeliveryTag(),false);
						synchronized (this)
						{
							this.notify();
						}
					}
				}
			};
			channel.basicConsume(RPC_QUEUE_NAME,false,consumer);
			while(true)
			{
				synchronized (consumer)
				{
					try
					{
						consumer.wait();
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
			{
				try
				{
					connection.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	private static int fib(int n)
	{
		if(n == 0 || n == 1)
		{
			return n;
		}
		return fib(n - 1) + fib(n - 2);
	}
}
