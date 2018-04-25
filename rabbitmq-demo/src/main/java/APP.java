import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * Created by xp-zhao on 2018/4/24.
 */
public class APP
{
	public static void main(String[] args) throws InterruptedException
	{
		String[] config = new String[]{"applicationContext.xml","base.xml"};

		ApplicationContext act = new ClassPathXmlApplicationContext(config);
		TimeUnit.SECONDS.sleep(60);
	}
}
