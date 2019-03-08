package com.xp.test;

/**
 * Created by xp-zhao on 2018/2/12.
 */
public class Test
{
	private String str = "";

	public static void main(String[] args)
	{
//		List<Integer> list = new ArrayList<>(Collections.nCopies(3,0));
//		System.out.println(list);
//		list.add(1,2);
		System.out.println(method(0));

	}

	public static int method(int n){
		int m = n == 0 ? 0 : 1;
		while(n == (n & (n - 1))){
			m++;
		}
		return m;
	}

	public static String reverse(String str)
	{
		if(str.length() == 0)
		{
			return str;
		}
		else
		{
			return reverse(str.substring(1,str.length()) + str.substring(0,1));
		}
	}

	public void test()
	{
		String string = this.str;
	}

	/**
	 * 鸡兔同笼，数头15个，数腿40只，问鸡兔几何
	 */
	public static void JT()
	{
		int a = 15;
		int b = 40;
		System.out.println(b/2 -a);
		System.out.println(a - (b/2-a));

		for(int i = 0; i < 50; i++)
		{
			for(int j = 0; j < 50; j++)
			{
				if(i + j == 15 && 4*i+2*j == 40)
				{
					System.out.println("tu:"+i+",ji:"+j);
				}
			}
		}
		int x = 1;
		int y;
		for(;x <= 15; x++)
		{
			y = 15-x;
			if(2*x+4*y==40)
			{
				//输出x.y
				System.out.println(x+":"+y);
			}
		}
	}

	public static int num(int i)
	{
		if(i <= 0)
		{
			return 0;
		}
		int numLength = 0;
		int length = String.valueOf(i).length();
		for(i = 0; i < length; i--)
		{
			Math.pow(10,i);
		}
		return numLength;
	}

	public static int reverse(int num)
	{
		String str = String.valueOf(num);
		StringBuilder sb = new StringBuilder(str);
		return Integer.parseInt(sb.reverse().toString());
	}
}
