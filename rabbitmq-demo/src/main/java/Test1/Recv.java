package Test1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

/**
 * Created by xp-zhao on 2017/11/28.
 */
public class Recv
{
	private final static String QUEUE_NAME = "queue";

	public static void main(String[] args)
	{
		try
		{
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("127.0.0.1");
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			channel.queueDeclare(QUEUE_NAME,false,false,false,null);
			System.out.println("waiting for message");
			QueueingConsumer consumer = new QueueingConsumer(channel);
			channel.basicConsume(QUEUE_NAME,true,consumer);
			while(true)
			{
				QueueingConsumer.Delivery delivery = consumer.nextDelivery();
				String message = new String(delivery.getBody());
				System.out.println("Received: "+message);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
