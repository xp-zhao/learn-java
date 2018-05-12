package rabbitmq.confirm;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitmq.utils.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by xp-zhao on 2018/5/12.
 */
public class Send1
{
	private static final String QUEUE_NAME = "test_queue_confirm1";

	public static void main(String[] args) throws IOException, TimeoutException, InterruptedException
	{
		Connection connection = ConnectionUtil.getConnetion();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME,false,false,false,null);

		// 生产者调用 confirmSelect 将 channel 设置为 confirm 模式
		channel.confirmSelect();

		String msg = "hello confirm message";
		channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());

		if(!channel.waitForConfirms())
		{
			System.out.println("message send faild");
		}
		else
		{
			System.out.println("message send success");
		}

		channel.close();
		connection.close();

	}
}
