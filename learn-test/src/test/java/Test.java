import com.alibaba.fastjson.JSONObject;

import java.util.*;

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
//		Map<String, String> map = new HashMap<>();
//		ArrayList<String> list = new ArrayList<>();
//		System.out.println(list.contains("test"));
//		System.out.println(map.containsKey("test"));
//		String names = "a|b|c";
//		String[] str = names.split("|");
//		System.out.println(str.length);

		Calendar currentTime = Calendar.getInstance();
		currentTime.setTime(new Date());
		System.out.println(currentTime.getTime());
		currentTime.add(Calendar.SECOND,-20);
		System.out.println(currentTime.getTime());

	}
}
