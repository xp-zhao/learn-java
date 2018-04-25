package listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * Created by xp-zhao on 2018/3/23.
 */
public class QueueListenter implements MessageListener
{
	@Override
	public void onMessage(Message message)
	{
		System.out.println("接收数据");
	}
}
