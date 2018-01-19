package Official.tutorial3;

import com.rabbitmq.client.*;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.IOException;

/**
 * Created by xp-zhao on 2017/12/13.
 */
public class ReceiveLogs
{
	private static final String EXCHANGE_NAME = "logs";

	public static void main(String[] args) throws IOException
	{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
		String queueName = channel.queueDeclare().getQueue();
		channel.queueBind(queueName,EXCHANGE_NAME,"");

		System.out.println("waiting for message");
		Consumer consumer = new DefaultConsumer(channel)
		{
			@Override public void handleDelivery(String consumerTag , Envelope envelope ,
				AMQP.BasicProperties properties , byte[] body) throws IOException
			{
				String message = new String(body,"UTF-8");
				System.out.println("Received "+message);
			}
		};
		channel.basicConsume(queueName,true,consumer);
	}
}
