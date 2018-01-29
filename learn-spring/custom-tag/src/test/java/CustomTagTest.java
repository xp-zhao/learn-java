import com.xp.entity.RpcService;
import com.xp.entity.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xp-zhao on 2018/1/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring.xml"})
public class CustomTagTest
{
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		User user = (User) context.getBean("testbean");
		System.out.println(user.getUserName() + "," + user.getEmail());

		RpcService rpc = (RpcService) context.getBean("testService");
		System.out.println(rpc.getContact()+", "+rpc.getServiceName()+","+rpc.getServiceImplName());
	}
}
