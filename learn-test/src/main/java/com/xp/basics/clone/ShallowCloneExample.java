package com.xp.basics.clone;

/**
 * Created by xp-zhao on 2018/9/4.
 */
public class ShallowCloneExample implements Cloneable
{
	private int[] arr;

	public ShallowCloneExample()
	{
		arr = new int[10];
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = i;
		}
	}

	public void set(int index,int value)
	{
		arr[index] = value;
	}

	public int get(int index)
	{
		return arr[index];
	}

	@Override
	protected ShallowCloneExample clone() throws CloneNotSupportedException
	{
		return (ShallowCloneExample) super.clone();
	}
}
