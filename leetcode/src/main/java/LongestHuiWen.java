import org.apache.commons.lang3.StringUtils;

/**
 * 5. 最长回文子串
 * Created by xp-zhao on 2018/8/18.
 */
public class LongestHuiWen
{
	public static void main(String[] args)
	{
		String str = "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd";
		String temp;
		String result = "";
		System.out.println(result.length());
		int size,k,max = 0;
		for(int i = 0; i < str.length(); i++){
			for(int j = i; j <= str.length(); j++){
				temp = str.substring(i , j);
				if(temp.length() >= 1){
					size = temp.length();
					for(k = 0; k < size; k++){
						if(temp.charAt(k) != temp.charAt(size - k - 1)){
							break;
						}
					}
					if(k == size && size > max){
						max = size;
						result = temp;
					}
				}
			}
		}
		System.out.println(result);
	}
}
