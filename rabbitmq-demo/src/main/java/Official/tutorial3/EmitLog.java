package Official.tutorial3;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * Created by xp-zhao on 2017/12/13.
 */
public class EmitLog
{
	private static final String EXCHANGE_NAME = "logs";

	public static void main(String[] args) throws IOException
	{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		// declare exchange
		channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
		String message = "loginfo";
		channel.basicPublish(EXCHANGE_NAME,"",null,message.getBytes());
		System.out.println("send: "+message);
		channel.close();
		connection.close();
	}
}
