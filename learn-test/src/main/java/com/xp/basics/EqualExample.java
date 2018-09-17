package com.xp.basics;

/**
 * Created by xp-zhao on 2018/9/4.
 */
public class EqualExample
{
	private int x;
	private int y;
	private int z;

	public EqualExample(int x,int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public boolean equals(Object object)
	{
		if(this == object)
		{
			return true;
		}
		if(object == null || getClass() != object.getClass())
		{
			return false;
		}
		EqualExample example = (EqualExample) object;
		if(x != example.x || y != example.y || z != example.z)
		{
			return false;
		}
		return true;
	}

	@Override
	public int hashCode()
	{
		int result = 17;
		result = 31 * result + x;
		result = 31 * result + y;
		result = 31 * result + z;
		return result;
	}
}
