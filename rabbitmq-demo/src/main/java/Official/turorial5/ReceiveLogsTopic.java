package Official.turorial5;

import com.rabbitmq.client.*;
import com.rabbitmq.client.impl.ChannelN;

import java.io.IOException;

/**
 * Created by xp-zhao on 2017/12/15.
 */
public class ReceiveLogsTopic
{
	private static final String EXCHANGE_NAME = "topic_logs";

	public static void main(String[] args) throws IOException
	{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.exchangeDeclare(EXCHANGE_NAME,"topic");
		String queueName = channel.queueDeclare().getQueue();

		if(args.length < 1)
		{
			System.err.println("Usage: ReceiveLogsTopic [binding_key]...");
			System.exit(1);
		}

		for(String bindingKey : args)
		{
			channel.queueBind(queueName,EXCHANGE_NAME,bindingKey);
		}
		System.out.println("waiting for message");
		Consumer consumer = new DefaultConsumer(channel)
		{
			@Override
			public void handleDelivery(String consumerTag , Envelope envelope ,
				AMQP.BasicProperties properties , byte[] body) throws IOException
			{
				String message = new String(body,"UTF-8");
				System.out.println(" [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
			}
		};
		channel.basicConsume(queueName,true,consumer);
	}
}
