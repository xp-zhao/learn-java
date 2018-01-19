package Official.tutorial1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;

/**
 * Created by xp-zhao on 2017/12/13.
 */
public class Send
{
	private final static String QUEUE_NAME = "hello";

	public static void main(String[] args) throws IOException
	{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		// 抽象的 socket 连接，连接到本地 rabbitmq server
		Connection connection = factory.newConnection();
		// 在连接上创建通道
		Channel channel = connection.createChannel();
		// 声明消息队列，消息发布到这个队列中
		channel.queueDeclare(QUEUE_NAME,false,false,false,null);
		String message = "hello,world1";
		channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
		System.out.println("sent:"+message);
		channel.close();
		connection.close();
	}
}
