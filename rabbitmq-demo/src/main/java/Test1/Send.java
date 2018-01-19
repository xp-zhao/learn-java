package Test1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * Created by xp-zhao on 2017/11/28.
 */
public class Send
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
			String message = "hello world";
			channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
			System.out.println("Sent: "+message+"");
			channel.close();
			connection.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
