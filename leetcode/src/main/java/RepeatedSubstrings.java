import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by xp-zhao on 2018/8/8.
 */
public class RepeatedSubstrings
{
	public static void main(String[] args)
	{
		Map<Character,Integer> map = new HashMap<>();
		String str = "abcbde";
		char[] ch = str.toCharArray();
		int max = 0;
		for(int i = 0; i < ch.length; i++){
			if(map.containsKey(ch[i])){
				int size = map.size();
				if(size > max){
					max = size;
				}
				i = map.get(ch[i]);
				map.clear();
			}else{
				map.put(ch[i] , i);
			}
		}
		System.out.println(max);
	}

	public static int lengthOfLongestSubstring(String str){

		return 0;
	}
}
