package Official.tutorial6;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by xp-zhao on 2017/12/15.
 */
public class RPCClient
{
	private Connection connection;
	private Channel channel;
	private String requestQueueName = "rpc_queue";
	private String replyQueueName;

	public RPCClient() throws IOException
	{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");

		connection = factory.newConnection();
		channel = connection.createChannel();

		replyQueueName = channel.queueDeclare().getQueue();
	}

	public String call(String message) throws IOException, InterruptedException
	{
		final String corrId = UUID.randomUUID().toString();
		AMQP.BasicProperties props = new AMQP.BasicProperties
			.Builder()
			.correlationId(corrId)
			.replyTo(replyQueueName)
			.build();
		channel.basicPublish("",requestQueueName,props,message.getBytes("UTF-8"));

		final BlockingQueue<String> response = new ArrayBlockingQueue<>(1);

		channel.basicConsume(replyQueueName,true,new DefaultConsumer(channel){
			@Override
			public void handleDelivery(String consumerTag , Envelope envelope ,
				AMQP.BasicProperties properties , byte[] body) throws IOException
			{
				if(properties.getCorrelationId().equals(corrId))
				{
					response.offer(new String(body,"UTF-8"));
				}
			}
		});

		return response.take();
	}

	public void close() throws IOException
	{
		connection.close();
	}

	public static void main(String[] args)
	{
		RPCClient fibRpc = null;
		String response;
		try
		{
			fibRpc = new RPCClient();
			System.out.println("requsting fib(30)");
			response = fibRpc.call("30");
			System.out.println("Got "+response);
		}
		catch (IOException | InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(fibRpc != null)
			{
				try
				{
					fibRpc.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
