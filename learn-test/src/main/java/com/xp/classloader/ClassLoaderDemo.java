package com.xp.classloader;

/**
 * Created by xp-zhao on 2018/10/14.
 */
public class ClassLoaderDemo
{
	public static void main(String[] args)
	{
		System.out.println(ClassLoaderDemo.class.getClassLoader());
		System.out.println(String.class.getClassLoader());
		System.out.println(ClassLoaderDemo.class.getClassLoader()
			+ "->" + ClassLoaderDemo.class.getClassLoader().getParent()
			+ "->" + ClassLoaderDemo.class.getClassLoader().getParent().getParent());
	}
}
