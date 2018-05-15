import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xp-zhao on 2018/2/12.
 */
public class Test
{
	public static void main(String[] args)
	{
//		Date date = new Date();
//		String[] str = "/home/ftpadmin".split("/");
//		System.out.println(str.length);
		Map<String, String> map = new HashMap<>();
		ArrayList<String> list = new ArrayList<>();
		System.out.println(list.contains("test"));
		System.out.println(map.containsKey("test"));
		String names = "a|b|c";
		String[] str = names.split("|");
		System.out.println(str.length);

	}
}
