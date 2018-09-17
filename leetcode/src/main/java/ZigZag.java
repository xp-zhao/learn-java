import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字变换
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：

	 P   A   H   N
	 A P L S I I G
	 Y   I   R
 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
 * Created by xp-zhao on 2018/9/9.
 */
public class ZigZag
{
	public static void main(String[] args)
	{
		System.out.println(convert("ABCDE",4));
	}
	public static String convert(String s, int numRows) {
		int len = s.length();
		int size = 2 * numRows - 3;
		List<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		if(s.length() <= numRows || numRows < 2){
			return s;
		}
		for(int i = 0, j = 0; i < numRows; i++){
			if(i == 0 || i == (numRows - 1)){
				j = i;
				while(j < len){
					sb.append(s.charAt(j));
					list.add(j);
					j = j + size + 1;
				}
				list.add(j);
			}else{
				for(int k = 0; k < list.size(); k++){
					if(k == 0){
						sb.append(s.charAt(list.get(k) + i));
					}else{
						if(list.get(k) - i < 0 || list.get(k) - i >= len){
							break;
						}
						sb.append(s.charAt(list.get(k) - i));
						if(list.get(k) + i >= len){
							break;
						}
						sb.append(s.charAt(list.get(k) + i));
					}
				}
			}

		}
		return sb.toString();
	}
}
