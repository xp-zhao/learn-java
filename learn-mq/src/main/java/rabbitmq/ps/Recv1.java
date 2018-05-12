package rabbitmq.ps;

import com.rabbitmq.client.*;
import rabbitmq.utils.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by xp-zhao on 2018/5/11.
 */
public class Recv1
{
	private static final String QUEUE_NAME = "test_queue_fanout_email";
	private static final String EXCHANGE_NAME = "test_exchange_fanout";

	public static void main(String[] args) throws IOException, TimeoutException
	{
		Connection connection = ConnectionUtil.getConnetion();
		final Channel channel = connection.createChannel();
		// 声明队列
		channel.queueDeclare(QUEUE_NAME,false,false,false,null);
		// 绑定队列到交换机
		channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"");

		channel.basicQos(1); // 保证一次只分发一个
		// 定义一个消费者
		DefaultConsumer consumer = new DefaultConsumer(channel)
		{
			// 消息到达触发此方法
			@Override public void handleDelivery(String consumerTag , Envelope envelope ,
				AMQP.BasicProperties properties , byte[] body) throws IOException
			{
				String msg = new String(body,"utf-8");
				System.out.println("[1] recv msg:"+msg);
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
					System.out.println("[1] done");
					channel.basicAck(envelope.getDeliveryTag(),false);
				}
			}
		};
		boolean autoAck = false;
		channel.basicConsume(QUEUE_NAME,autoAck,consumer);
	}
}
