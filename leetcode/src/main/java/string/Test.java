package string;

/**
 * Created by xp-zhao on 2018/12/20.
 */
public class Test
{
	public static void main(String[] args) {
		String str = "/task/group";
		System.out.println(str.substring(str.lastIndexOf("/")+1));
	}
}
