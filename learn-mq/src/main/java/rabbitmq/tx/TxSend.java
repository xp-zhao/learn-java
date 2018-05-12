package rabbitmq.tx;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitmq.utils.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by xp-zhao on 2018/5/12.
 */
public class TxSend
{
	private static final String QUEUE_NAME = "test_queue_tx";

	public static void main(String[] args) throws IOException, TimeoutException
	{
		Connection connection = ConnectionUtil.getConnetion();
		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME,false,false,false,null);

		String msg = "hello tx message";

		channel.txSelect();
		try
		{
			channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
			int i = 1 / 0;
			System.out.println("send : "+msg);
			channel.txCommit();
		}
		catch (Exception e)
		{
			channel.txRollback();
			e.printStackTrace();
			System.out.println("send message rollback");
		}
		channel.close();
		connection.close();
	}
}
