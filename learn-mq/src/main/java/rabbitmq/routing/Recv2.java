package rabbitmq.routing;

import com.rabbitmq.client.*;
import rabbitmq.utils.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by xp-zhao on 2018/5/12.
 */
public class Recv2
{
	private static final String EXCHANGE_NAME = "test_exchange_direct";
	private static final String QUEUE_NAME = "test_queue_direct_2";

	public static void main(String[] args) throws IOException, TimeoutException
	{
		Connection connection = ConnectionUtil.getConnetion();
		final Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME,false,false,false,null);
		channel.basicQos(1);

		channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"error");
		channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"info");
		channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"warning");

		// 定义一个消费者
		DefaultConsumer consumer = new DefaultConsumer(channel)
		{
			// 消息到达触发此方法
			@Override public void handleDelivery(String consumerTag , Envelope envelope ,
				AMQP.BasicProperties properties , byte[] body) throws IOException
			{
				String msg = new String(body,"utf-8");
				System.out.println("[2] recv msg:"+msg);
				try
				{
					Thread.sleep(2000);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				finally
				{
					System.out.println("[2] done");
					channel.basicAck(envelope.getDeliveryTag(),false);
				}
			}
		};
		boolean autoAck = false;
		channel.basicConsume(QUEUE_NAME,autoAck,consumer);
	}
}
