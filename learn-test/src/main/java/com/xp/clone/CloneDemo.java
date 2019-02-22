package com.xp.clone;

/**
 * Created by xp-zhao on 2019/2/22.
 */
public class CloneDemo
{
	public static void main(String[] args) throws CloneNotSupportedException
	{
		Student student = new Student(23 , "xp");
		Student student1 = student; // 复制引用，student、student1 均指向同一个对象
		Student student2 = (Student) student.clone(); // 复制对象（克隆），student、student2 指向不同的对象
		String result = student.getName() == student2.getName() ? "clone 是浅拷贝的" : "clone 是深拷贝的";
		System.out.println(result);
	}
}
