package com.xp.basics.clone;

/**
 * Created by xp-zhao on 2018/9/4.
 */
public class DeepCloneExample implements Cloneable
{
	private int[] arr;

	public DeepCloneExample()
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
	protected DeepCloneExample clone() throws CloneNotSupportedException
	{
		DeepCloneExample example = (DeepCloneExample) super.clone();
		example.arr = new int[arr.length];
		for(int i = 0; i < arr.length; i++)
		{
			example.arr[i] = arr[i];
		}
		return example;
	}
}
