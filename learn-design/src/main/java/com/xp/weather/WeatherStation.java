package com.xp.weather;

/**
 * Created by xp-zhao on 2018/4/18.
 */
public class WeatherStation
{
	public static void main(String[] args)
	{
		WeatherData weatherData = new WeatherData();

		CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
		weatherData.setMeasurements(1,2,3);
		weatherData.setMeasurements(10,20,30);
		weatherData.setMeasurements(100,200,300);
	}
}
