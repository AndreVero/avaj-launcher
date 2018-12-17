package com.avajLauncher;

public class Helicopter extends Aircraft implements Flyable{

	private WeatherTower weatherTower;
	
	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}
	
	@Override
	public void updateConditions() {
		if (WeatherProvider.getWeatherProvider().getCurrentWeather(coordinates) == "SUN")
		{
			this.coordinates.setHeight(this.coordinates.getHeight() + 2);
			this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
			System.out.println("This is hot.");
		}
		else if (WeatherProvider.getWeatherProvider().getCurrentWeather(coordinates) == "RAIN")
		{
			this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
			System.out.println("Rain! Now I can spy on the lady!");
		}
		else if (WeatherProvider.getWeatherProvider().getCurrentWeather(coordinates) == "SNOW")
		{
			this.coordinates.setHeight(this.coordinates.getHeight() - 12);
			System.out.println("My rotor is going to freeze!");
		}
		else
		{
			this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
			System.out.println("Fog! The lady is not visible through the window!");
		}
		if (this.coordinates.getHeight() <= 0)
		{
			System.out.printf("Helicopter#%s(%d) unregister from weather tower.\n", name, id);
			weatherTower.unregister(this);
		}
		if (this.coordinates.getHeight() >= 100)
			this.coordinates.setHeight(100);
	}

	@Override
	public void registerTower(WeatherTower WeatherTower) {
		System.out.printf("Tower says: Helicopter#%s(%d) register to weather tower.\n", name, id);
		weatherTower = WeatherTower;
		weatherTower.register(this);
	}
}
