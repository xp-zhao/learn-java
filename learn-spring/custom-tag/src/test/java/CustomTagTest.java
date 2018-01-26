import com.xp.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xp-zhao on 2018/1/25.
 */
public class CustomTagTest
{
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		User user = (User) context.getBean("testbean");
		System.out.println(user.getUserName() + "," + user.getEmail());
	}
}
