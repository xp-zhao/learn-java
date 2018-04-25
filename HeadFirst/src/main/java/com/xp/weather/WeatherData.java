package com.xp.weather;

import java.util.ArrayList;

/**
 * Created by xp-zhao on 2018/4/18.
 */
public class WeatherData implements Subject
{
	// 记录观察者
	private ArrayList observers;
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData(){
		observers = new ArrayList();
	}

	public void registerObserver(Observer o)
	{
		observers.add(o);
	}

	public void removeObserver(Observer o)
	{
		int i = observers.indexOf(o);
		if(i >= 0)
		{
			observers.remove(i);
		}
	}

	public void notifyObservers()
	{
		for(int i = 0; i < observers.size(); i++)
		{
			Observer observer = (Observer) observers.get(i);
			observer.update(temperature,humidity,pressure);
		}
	}

	public void setMeasurements(float temp,float humid,float pressure)
	{
		this.temperature = temp;
		this.humidity = humid;
		this.pressure = pressure;
		notifyObservers();
	}
}
