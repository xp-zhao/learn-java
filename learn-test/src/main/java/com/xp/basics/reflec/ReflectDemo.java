package com.xp.basics.reflec;

import java.lang.reflect.Field;

/**
 * 反射示例
 * Created by xp-zhao on 2019/3/26.
 */
public class ReflectDemo
{
	public static void main(String[] args) {
		Integer a = 10;
		System.out.println(a);
		modifyValue(a);
		System.out.println(a);
	}

	/**
	 * 修改 a 的值
	 * @param a
	 */
	public static void modifyValue(Integer a)
	{
		try {
			// 获取 Integer 对象的 value 属性
			Field field = Integer.class.getDeclaredField("value");
			// 禁止访问权限的检查
			field.setAccessible(true);
			// 设置新值
			field.set(a,20);

		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
