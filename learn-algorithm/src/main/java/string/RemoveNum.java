package string;

/**
 * 移除字符串中的数字
 * Created by xp-zhao on 2019/3/13.
 */
public class RemoveNum
{
	public static void main(String[] args) {
		String string = "ab2c2d4e565f";
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < string.length(); i++){
			char ch = string.charAt(i);
			if(ch > '9' || ch < '0'){
				sb.append(ch);
			}
		}
		System.out.println(sb.toString());
	}
}
