package Test1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by xp-zhao on 2017/11/28.
 */
public class Send
{
	private final static String QUEUE_NAME = "queue_test1";

	public static void main(String[] args)
	{
		try
		{
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("47.98.49.140");
			factory.setVirtualHost("dev");
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			String message = "hello world";
			String str = "asdfasdfasdfasdfasdfasdf";
			while(true)
			{
				channel.basicPublish("exchange.test1","test1",null,str.getBytes());
				System.out.println("send: "+str);
				str = str+str;
				try
				{
					TimeUnit.SECONDS.sleep(1);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
