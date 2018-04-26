/**
 * Created by xp-zhao on 2018/4/26.
 */
public class HelloMaven
{
	public String sayHello()
	{
		return "hello maven";
	}

	public static void main(String[] args)
	{
		System.out.println(new HelloMaven().sayHello());
	}
}
