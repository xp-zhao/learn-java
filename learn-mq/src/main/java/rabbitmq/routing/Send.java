package rabbitmq.routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitmq.utils.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by xp-zhao on 2018/5/12.
 */
public class Send
{
	private static final String EXCHANGE_NAME = "test_exchange_direct";

	public static void main(String[] args) throws IOException, TimeoutException
	{
		Connection connection = ConnectionUtil.getConnetion();
		Channel channel = connection.createChannel();

		channel.exchangeDeclare(EXCHANGE_NAME,"direct");

		String msg = "hello direct";

		String routingKey = "info";
		channel.basicPublish(EXCHANGE_NAME,routingKey,null,msg.getBytes());
		System.out.println("send msg:"+msg);

		channel.close();
		connection.close();
	}
}
