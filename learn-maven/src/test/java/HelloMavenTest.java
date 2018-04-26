import org.junit.Test;

/**
 * Created by xp-zhao on 2018/4/26.
 */
public class HelloMavenTest
{
	@Test
	public void testSayHello()
	{
		HelloMaven helloMaven = new HelloMaven();
		String result = helloMaven.sayHello();
		assert result.equals("hello maven");
	}
}
