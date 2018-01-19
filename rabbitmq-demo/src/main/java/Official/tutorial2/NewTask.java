package Official.tutorial2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;

/**
 * Created by xp-zhao on 2017/12/13.
 */
public class NewTask
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
		boolean durable = true; // 消息持久化
//		channel.queueDeclare(QUEUE_NAME,false,false,false,null);
		channel.queueDeclare(QUEUE_NAME,durable,false,false,null);
		String message = getMessage(args);
//		channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
		channel.basicPublish("" , QUEUE_NAME , MessageProperties.PERSISTENT_TEXT_PLAIN , message.getBytes());
		System.out.println("sent:"+message);
		channel.close();
		connection.close();
	}

	private static String getMessage(String[] args)
	{
		if(args.length < 1)
		{
//			return "Second  message..";
//			return "Third message...";
//			return "Fourth message....";
			return "Fifth message.....";
		}
		else
		{
			return joinStrings(args," ");
		}
	}

	private static String joinStrings(String[] strings,String delimiter)
	{
		int length = strings.length;
		if(length == 0)
		{
			return "";
		}
		StringBuilder sb = new StringBuilder(strings[0]);
		for(int i = 0; i < length; i++)
		{
			sb.append(delimiter).append(strings[i]);
		}
		return sb.toString();
	}
}
