package rabbitmq.workfair;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitmq.utils.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by xp-zhao on 2018/5/11.
 */
public class Send
{
	public static final String QUEUE_NAME = "test_work_queue";

	public static void main(String[] args) throws IOException, TimeoutException, InterruptedException
	{
		// 获取连接
		Connection connection = ConnectionUtil.getConnetion();
		// 获取 channel
		Channel channel = connection.createChannel();
		// 声明队列
		channel.queueDeclare(QUEUE_NAME,false,false,false,null);
		/**
		 * 每个消费者发送确认消息之前，消息队列不发送下一个消息到消费者，一次只处理一个消息
		 * 限制发送给同一个消费者不超过一条数据
		 */
		int prefetchCount = 1;
		channel.basicQos(prefetchCount);

		for(int i = 0; i < 50; i++)
		{
			String msg = "hello "+i;
			System.out.println("send: "+msg);
			channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
			TimeUnit.MILLISECONDS.sleep(i*5);
		}
		channel.close();
		connection.close();
	}
}
