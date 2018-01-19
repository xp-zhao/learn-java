package Official.tutorial4;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by xp-zhao on 2017/12/15.
 */
public class ReceiveLogsDirect
{
	private static final String EXCHANGE_NAME = "direct_logs";

	public static void main(String[] args) throws IOException
	{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.exchangeDeclare(EXCHANGE_NAME,"direct");
		String queueName = channel.queueDeclare().getQueue();

		if(args.length < 1)
		{
			System.err.println("Usage: ReceiveLogsDirect [info] [warning] [error]");
			System.exit(1);
		}
		for(String severity : args)
		{
			channel.queueBind(queueName,EXCHANGE_NAME,severity);
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
