package com.xp.Singleton.method6;

/**
 * Created by xp-zhao on 2018/9/30.
 */
public enum Singleton
{
	INSTANCE;
	private String objName;

	public String getObjName()
	{
		return objName;
	}

	public void setObjName(String objName)
	{
		this.objName = objName;
	}

	public static void main(String[] args)
	{
		Singleton singleton = Singleton.INSTANCE;
		singleton.setObjName("firstName");
		System.out.println(singleton.getObjName());
		Singleton secondSingleton = Singleton.INSTANCE;
		secondSingleton.setObjName("secondName");
		System.out.println(singleton.getObjName());
		System.out.println(secondSingleton.getObjName());
		Singleton[] singletons = Singleton.class.getEnumConstants();
		for(Singleton singleton1 : singletons){
			System.out.println(singleton1.getObjName());
		}
	}
}
