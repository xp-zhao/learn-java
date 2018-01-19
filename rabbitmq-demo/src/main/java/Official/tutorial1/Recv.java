package Official.tutorial1;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by xp-zhao on 2017/12/13.
 */
public class Recv
{
	private final static String QUEUE_NAME = "hello";

	public static void main(String[] args) throws IOException
	{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		// abstracts the socket connection,connect to local
		Connection connection = factory.newConnection();
		// create a channel
		Channel channel = connection.createChannel();

		// declaring a queue
		channel.queueDeclare(QUEUE_NAME,false,false,false,null);
		System.out.println("waiting for message");
		Consumer consumer = new DefaultConsumer(channel)
		{
			// 回调函数，consumer 接收到消息时 自动调用
			public void handleDelivery(String consumerTag , Envelope envelope ,
				AMQP.BasicProperties properties , byte[] body) throws IOException
			{
				String message = new String(body,"UTF-8");
				System.out.println(" Received "+message);
			}
		};
		channel.basicConsume(QUEUE_NAME,true,consumer);
	}
}
