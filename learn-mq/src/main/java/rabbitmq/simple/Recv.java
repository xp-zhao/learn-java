package rabbitmq.simple;

import com.rabbitmq.client.*;
import rabbitmq.utils.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by xp-zhao on 2018/5/11.
 */
public class Recv
{
	private static final String QUEUE_NAME = "test_simple_queue";
	public static void main(String[] args) throws IOException, TimeoutException
	{
		// 获取连接
		Connection connection = ConnectionUtil.getConnetion();
		// 创建频道
		Channel channel = connection.createChannel();
		// 队列声明
		channel.queueDeclare(QUEUE_NAME,false,false,false,null);
		// 定义消费者
		DefaultConsumer consumer = new DefaultConsumer(channel)
		{
			// 获取到达的消息
			@Override public void handleDelivery(String consumerTag , Envelope envelope ,
				AMQP.BasicProperties properties , byte[] body) throws IOException
			{
				String msg = new String(body,"utf-8");
				System.out.println("new api recv:"+msg);
			}
		};
		// 监听队列
		channel.basicConsume(QUEUE_NAME,true,consumer);
	}

	private static void oldmethod() throws IOException, TimeoutException, InterruptedException
	{
		// 获取连接
		Connection connection = ConnectionUtil.getConnetion();
		// 创建频道
		Channel channel = connection.createChannel();

		// 定义队列的消费者
		QueueingConsumer consumer = new QueueingConsumer(channel);
		// 监听队列
		channel.basicConsume(QUEUE_NAME,true,consumer);
		while(true)
		{
			QueueingConsumer.Delivery deliver = consumer.nextDelivery();
			String str = new String(deliver.getBody());
			System.out.println("[recv] msg:"+str);
		}
	}
}
