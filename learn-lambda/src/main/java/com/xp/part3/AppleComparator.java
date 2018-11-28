package com.xp.part3;

import java.util.Comparator;

/**
 * Created by xp-zhao on 2018/11/28.
 */
public class AppleComparator implements Comparator<Apple>
{
	@Override
	public int compare(Apple o1 , Apple o2)
	{
		return o1.getWeight().compareTo(o2.getWeight());
	}
}
