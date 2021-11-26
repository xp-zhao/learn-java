package com.xp.weather.jdk;

import java.util.Observable;

/**
 * Created by xp-zhao on 2018/4/18.
 */
public class WeatherData extends Observable
{
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData(){

	}

	public void setMeasurements(float temp,float humid,float pressure)
	{
		this.temperature = temp;
		this.humidity = humid;
		this.pressure = pressure;
		setChanged();
		notifyObservers();
	}

	public float getTemperature()
	{
		return temperature;
	}

	public float getHumidity()
	{
		return humidity;
	}

	public float getPressure()
	{
		return pressure;
	}
}
