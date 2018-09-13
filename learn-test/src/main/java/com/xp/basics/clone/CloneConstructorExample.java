package com.xp.basics.clone;

/**
 * Created by xp-zhao on 2018/9/4.
 */
public class CloneConstructorExample
{
	private int[] arr;

	public CloneConstructorExample()
	{
		arr = new int[10];
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = i;
		}
	}

	public CloneConstructorExample(CloneConstructorExample original)
	{
		arr = new int[original.arr.length];
		for(int i = 0; i < original.arr.length; i++)
		{
			arr[i] = original.arr[i];
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
}
