package com.xp.basics.clone;

import java.util.Date;

/**
 * Created by xp-zhao on 2018/9/4.
 */
public class Example
{
	public static void main(String[] args)
	{
//		CloneConstructorExample example1 = new CloneConstructorExample();
//		CloneConstructorExample example2 = new CloneConstructorExample(example1);
//		example1.set(6,66);
//		System.out.println(example2.get(6));
//		Date date = new Date(0);
//		System.out.println(date.compareTo(new Date(0)));
		System.out.println(convert("PAYPALISHIRING",3));
	}

	public static String convert(String s, int numRows) {
		if (numRows == 1){
			return s;
		}
		int size = 2*numRows - 3;
		StringBuilder sb = new StringBuilder();
		for(int i = 0,j; i < numRows; i++){
			j = i;
			while(j < s.length()){
				sb.append(s.charAt(j));
				j = j + size + 1;
			}
			size = size - 2;
		}
		return sb.toString();
	}
}
