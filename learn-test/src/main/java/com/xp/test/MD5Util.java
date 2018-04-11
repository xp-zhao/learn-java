package com.xp.test;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	public MD5Util() {
	}

	public static final String getMd5Str(String s) {
		char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		byte[] strTemp = s.getBytes();

		try {
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char[] str = new char[j * 2];
			int k = 0;

			for(int i = 0; i < j; ++i) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 15];
				str[k++] = hexDigits[byte0 & 15];
			}

			return new String(str);
		} catch (NoSuchAlgorithmException var10) {
			var10.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args)
	{
		System.out.println(getMd5Str("liujf"));
	}
}
