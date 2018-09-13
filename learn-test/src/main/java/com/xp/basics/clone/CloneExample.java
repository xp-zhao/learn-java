package com.xp.basics.clone;

/**
 * Created by xp-zhao on 2018/9/4.
 */
public class CloneExample implements Cloneable
{
	private int a;
	private int b;

	@Override
	protected CloneExample clone() throws CloneNotSupportedException
	{
		return (CloneExample) super.clone();
	}
}
