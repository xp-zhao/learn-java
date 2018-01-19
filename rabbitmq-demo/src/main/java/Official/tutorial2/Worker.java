package Official.tutorial2;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by xp-zhao on 2017/12/13.
 */
public class Worker
{
	private final static String QUEUE_NAME = "hello";

	public static void main(String[] args) throws IOException
	{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		// abstracts the socket connection,connect to local
		Connection connection = factory.newConnection();
		// create a channel
		final Channel channel = connection.createChannel();

		// declaring a queue
		boolean durable = true;
		channel.queueDeclare(QUEUE_NAME,durable,false,false,null);
		System.out.println("waiting for message");
		// accept only one unack-ed message at a time(一次只能接受一条未处理的信息)
		channel.basicQos(1);
		final Consumer consumer = new DefaultConsumer(channel)
		{
			// 回调函数，consumer 接收到消息时 自动调用
			public void handleDelivery(String consumerTag , Envelope envelope ,
				AMQP.BasicProperties properties , byte[] body) throws IOException
			{
				String message = new String(body,"UTF-8");
				System.out.println(" Received "+message);
				try
				{
					doWork(message);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				finally
				{
					System.out.println("done");
					// 手动消息确认
					channel.basicAck(envelope.getDeliveryTag(),false);
				}
			}
		};
		// 关闭消息自动确认
		boolean autoAck = false;
		channel.basicConsume(QUEUE_NAME,autoAck,consumer);
	}

	private static void doWork(String task) throws InterruptedException
	{
		for(char ch : task.toCharArray())
		{
			System.out.print(ch);
			if(ch == '.')
			{
				TimeUnit.SECONDS.sleep(1);
			}
		}
	}
}
