package rabbitmq.work;

import com.rabbitmq.client.*;
import rabbitmq.utils.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by xp-zhao on 2018/5/11.
 */
public class Recv2
{
	public static final String QUEUE_NAME = "test_work_queue";
	public static void main(String[] args) throws IOException, TimeoutException
	{
		// 获取连接
		Connection connection = ConnectionUtil.getConnetion();
		// 获取通道
		Channel channel = connection.createChannel();
		// 声明队列
		channel.queueDeclare(QUEUE_NAME,false,false,false,null);
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
					Thread.sleep(1000);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				finally
				{
					System.out.println("[2] done");
				}
			}
		};
		boolean autoAck = true;
		channel.basicConsume(QUEUE_NAME,autoAck,consumer);
	}
}
