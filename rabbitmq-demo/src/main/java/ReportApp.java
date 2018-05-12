import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * Created by xp-zhao on 2018/4/24.
 */
public class ReportApp
{
	public static void main(String[] args) throws InterruptedException
	{
		ApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring/spring-rabbitmq.xml");
	}
}
