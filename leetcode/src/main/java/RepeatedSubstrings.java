import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *  无重复字符的最长子串
 * Created by xp-zhao on 2018/8/8.
 */
public class RepeatedSubstrings
{
	public static void main(String[] args)
	{
		String str = "bbb";
		System.out.println(method1(str));
		System.out.println(method2(str));
		System.out.println(method3(str));
	}

	/**
	 * 自己的解法
	 * @param str
	 * @return
	 */
	public static int method1(String str){
		Map<Character,Integer> map = new HashMap<>();
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
		int size = map.size();
		if(size > max){
			max = size;
		}
		return max;
	}

	public static int method2(String str){
		int size = str.length();
		Set<Character> set = new HashSet<>();
		int max = 0,i = 0, j = 0;
		while(i < size && j < size){
			if(!set.contains(str.charAt(j))){
				set.add(str.charAt(j));
				j++;
				max = Math.max(max , j - i);
			}else{
				set.remove(str.charAt(i));
				i++;
			}
		}
		return max;
	}

	public static int method3(String str){
		int size = str.length();
		int max = 0;
		Map<Character, Integer> map = new HashMap<>();
		for(int j = 0,i = 0; j < size; j++){
			if(map.containsKey(str.charAt(j))){
				i = Math.max(map.get(str.charAt(j)) , i);
			}
			max = Math.max(max,j - i + 1);
			map.put(str.charAt(j),j + 1);
		}
		return max;
	}
}
