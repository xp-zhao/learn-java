package com.xp.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xp.model.ContentItem;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xp-zhao on 2018/5/24.
 */
public class StringDemo
{
	public static void main(String[] args)
	{
		String tos = "  1368839 ,  2342342 ";
		System.out.println(tos);
		System.out.println(StringUtils.deleteWhitespace(tos));

//		demo("asdf\nasdfasdf\n");
////		String str = null;
////		JSONObject object = JSON.parseObject(str);
////		ContentItem item = JSONObject.toJavaObject(object , ContentItem.class);
////		System.out.println(item);
//		StringBuffer failIds = new StringBuffer();
//		System.out.println(failIds.toString());
//		String str = "APT";
//		if(str.matches("(A||\\s)*PA+T(A||\\s)*")){
//			int p = str.indexOf("P");
//			int t = str.indexOf("T");
//			int num = t - p - 1;
//			if(p * num == str.length()-t - 1)
//			{
//				System.out.println("YES");
//			}
//			else
//			{
//				System.out.println("NO");
//			}
//		}
//		else
//		{
//			System.out.println("NO");
//		}
	}

	public static void demo(String str)
	{
		System.out.println(str);
		str = str.replaceAll("\r\n" , "\n");
		System.out.println(str);
		System.out.println(str.replaceAll("\n","\\\\r\\\\n"));
//		System.out.println(StringEscapeUtils.unescapeJava(str));
	}

	public static String md5(String str)
	{
		try
		{
			//确定计算方法
			MessageDigest md5=MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();
			//加密后的字符串
			String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
			return newstr;
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return "";
	}
}
