package com.xp.core;

/**
 * Created by xp-zhao on 2018/8/14.
 */
public class Manager extends Employee
{
	private double bonus;

	public Manager(String name , double salary , int year , int month , int day)
	{
		super(name , salary , year , month , day);
		bonus = 0;
	}

	public double getSalary()
	{
		return bonus + super.getSalary();
	}

	public void setBonus(double bonus)
	{
		this.bonus = bonus;
	}
}
