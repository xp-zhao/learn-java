package utils;

import listener.QueueListenter;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;

/**
 * Created by xp-zhao on 2018/4/24.
 */
public class MQUtils
{
	/**
	 * 根据定时任务组代码和定时任务代码创建消息队列绑定默认交换机
	 */
	public static void createQueue(String queueName)
	{
		SimpleMessageListenerContainer container = SpringUtils.getBean("listenerContainer");
		try
		{
			Queue queue = new Queue(queueName, true, false, false);
			Exchange exchange = SpringUtils.getBean("defExchange");
			BindingBuilder.bind(queue).to(exchange).with(queueName);
			container.addQueues(queue);
			container.setMessageListener(new QueueListenter());
		}
		catch (Exception e)
		{
			System.out.println("创建消息队列失败");
		}
	}
}
