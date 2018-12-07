package com.xp.part5_stream.example;

/**
 * Created by xp-zhao on 2018/12/7.
 */
public class Trader
{
	private final String name;
	private final String city;
	public Trader(String n, String c){
		this.name = n;
		this.city = c;
	}
	public String getName(){
		return this.name;
	}
	public String getCity(){
		return this.city;
	}
	public String toString(){
		return "Trader:"+this.name + " in " + this.city;
	}
}
