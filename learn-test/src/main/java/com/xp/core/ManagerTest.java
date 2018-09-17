package com.xp.core;

/**
 * Created by xp-zhao on 2018/8/14.
 */
public class ManagerTest
{
	public static void main(String[] args)
	{
		Manager boss = new Manager("xp" , 80000 , 1994 , 10 , 25);
		boss.setBonus(5000);
		Employee[] staff = new Employee[3];
		staff[0] = boss;
		staff[1] = new Employee("test1" , 50000 , 1989 , 10 , 1);
		staff[2] = new Employee("test2" , 40000 , 1989 , 10 , 1);
		for(Employee e : staff)
		{
			System.out.println("name= "+e.getName()+" ,salary= "+e.getSalary());
		}
	}
}
