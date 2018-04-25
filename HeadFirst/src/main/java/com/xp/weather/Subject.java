package com.xp.weather;

/**
 * 观察者模式示例代码
 * Created by xp-zhao on 2018/4/18.
 */
public interface Subject
{
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}
