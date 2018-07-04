package rabbitmq.spring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import rabbitmq.model.User;

/**
 * Created by xp-zhao on 2018/5/12.
 */
public class NoticeApp
{
	public static void main(String[] args) throws InterruptedException
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-rabbitmq.xml");
		RabbitTemplate template = context.getBean(RabbitTemplate.class);
		template.convertAndSend("task.report.groupCode.taskCode",new User("xp","145668","test.execute.groupCode.taskCode"));
		System.out.println("send : task.execute.groupCode.taskCode");
	}
}
