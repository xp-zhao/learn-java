package TaskMQ;

import com.rabbitmq.client.*;
import listener.QueueListenter;

import java.io.IOException;

/**
 * Created by xp-zhao on 2018/5/7.
 */
public class NoticeMQ
{
	private static final String EXCHANGE_NAME = "manager.task";
	private static final String QUEUE_NAME = "task.execute.*";
	private static final String REPORT_QUEUE_NAME = "task.report.test.task002";

	public static void main(String[] args) throws IOException
	{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("10.25.245.121");
		factory.setPort(8088);
		factory.setVirtualHost("/stable");
//		factory.setHost("10.25.245.165");
//		factory.setPort(5672);
//		factory.setVirtualHost("/");
		Connection connection = factory.newConnection();
		final Channel channel = connection.createChannel();

		// declare exchange
		channel.exchangeDeclare(EXCHANGE_NAME,"topic", true,false,null);
		// 声明创建队列
		channel.queueDeclare(QUEUE_NAME,false,false,false,null);
//		channel.queueDeclare(REPORT_QUEUE_NAME,false,false,false,null);
		channel.queueBind(QUEUE_NAME,EXCHANGE_NAME, QUEUE_NAME);
//		channel.queueBind(REPORT_QUEUE_NAME,EXCHANGE_NAME, REPORT_QUEUE_NAME);
		Consumer noticeConsumer = new DefaultConsumer(channel)
		{
			@Override
			public void handleDelivery(String consumerTag , Envelope envelope ,
				AMQP.BasicProperties properties , byte[] body) throws IOException
			{
				String message = new String(body,"UTF-8");
				System.out.println(" [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
			}
		};
		channel.basicConsume(QUEUE_NAME,true,noticeConsumer);
	}
}
