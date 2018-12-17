package com.avajLauncher;

public class WeatherProvider {
	private static WeatherProvider weatherProvider;
	private String[] WEATHER = {
			"SUN", "SNOW", "RAIN", "FOG"
	};
	
	private WeatherProvider() {}
	
	public static WeatherProvider getWeatherProvider()
	{
		if (weatherProvider == null)
			weatherProvider = new WeatherProvider();
		return (weatherProvider);
	}
	
	public String getCurrentWeather(Coordinates coordinates) {
		int res = 0;
		
		res = (coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude()) 
				% 4;
	return WEATHER[res];
	}
}