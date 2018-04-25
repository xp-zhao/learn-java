package listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 *监听 mq,获取上行数据(客户端任务执行完成后上报执行结果)
 * Created by xp-zhao on 2018/3/23.
 */
public class ReportQueueListenter implements MessageListener
{
	@Override
	public void onMessage(Message message)
	{
		System.out.println("接收数据");
	}
}
