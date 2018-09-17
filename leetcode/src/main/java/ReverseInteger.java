/**
 * Created by xp-zhao on 2018/9/9.
 */
public class ReverseInteger
{
	public static void main(String[] args)
	{
		System.out.println(reverse(-321));
	}

	public static int reverse(int x) {
		if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE){
			return 0;
		}
		int result = 0;
		try
		{
			int abs = Math.abs(x);
			String str = String.valueOf(abs);
			StringBuilder sb = new StringBuilder(str);
			StringBuilder sb1 = sb.reverse();
			result = Integer.valueOf(sb1.toString());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		if(x < 0){
			result = -result;
		}
		return result;
	}
}
