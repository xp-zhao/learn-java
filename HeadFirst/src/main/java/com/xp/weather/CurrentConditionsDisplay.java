package com.xp.weather;

/**
 * Created by xp-zhao on 2018/4/18.
 */
public class CurrentConditionsDisplay implements Observer,DisplayElement
{
	private float temperature;
	private float humidity;
	private Subject weatherData;

	public CurrentConditionsDisplay(Subject weatherData)
	{
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void display()
	{
		System.out.println("Current conditions: "+temperature+" F degrees and "+humidity+"% humidity");
	}

	public void update(float temp , float humidity , float pressure)
	{
		this.temperature = temp;
		this.humidity = humidity;
		display();
	}
}
