package rabbitmq.ps;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitmq.utils.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by xp-zhao on 2018/5/11.
 */
public class Send
{
	private static final String EXCHANGE_NAME = "test_exchange_fanout";

	public static void main(String[] args) throws IOException, TimeoutException
	{
		Connection connection = ConnectionUtil.getConnetion();
		Channel channel = connection.createChannel();
		// 声明交换机
		channel.exchangeDeclare(EXCHANGE_NAME,"fanout"); // 分发
		String msg = "hell ps";
		channel.basicPublish(EXCHANGE_NAME,"",null,msg.getBytes());
		System.out.println("send： "+msg);
		channel.close();
		connection.close();
	}
}
