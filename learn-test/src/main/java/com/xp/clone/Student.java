package com.xp.clone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by xp-zhao on 2019/2/22.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Cloneable
{
	private int age;
	private String name;

	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}
