package com.xp.weather.jdk;

import com.xp.weather.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by xp-zhao on 2018/4/18.
 */
public class CurrentConditionsDisplay implements Observer,DisplayElement
{
	private Observable observable;
	private float temperature;
	private float humidity;

	public CurrentConditionsDisplay(Observable observable)
	{
		this.observable = observable;
		observable.addObserver(this);
	}

	public void display()
	{
		System.out.println("Current conditions: "+temperature+" F degrees and "+humidity+"% humidity");
	}

	public void update(Observable o , Object arg)
	{
		if(o instanceof WeatherData)
		{
			WeatherData weatherData = (WeatherData) o;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}
	}
}
