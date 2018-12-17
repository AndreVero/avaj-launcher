package com.avajLauncher;

public class Baloon extends Aircraft implements Flyable{

	private WeatherTower weatherTower;
	
	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		if (WeatherProvider.getWeatherProvider().getCurrentWeather(coordinates) == "SUN")
		{
			this.coordinates.setHeight(this.coordinates.getHeight() + 4);
			this.coordinates.setLatitude(this.coordinates.getLatitude() + 2);
			System.out.println("Let's enjoy the good weather and take some pics.");
		}
		else if (WeatherProvider.getWeatherProvider().getCurrentWeather(coordinates) == "RAIN")
		{
			this.coordinates.setHeight(this.coordinates.getHeight() - 5);
			System.out.println("Damn you rain! You messed up my baloon.");
		}
		else if (WeatherProvider.getWeatherProvider().getCurrentWeather(coordinates) == "SNOW")
		{
			this.coordinates.setHeight(this.coordinates.getHeight() - 15);
			System.out.println("It's snowing. We're  gonna crash.");
		}
		else
		{
			this.coordinates.setHeight(this.coordinates.getHeight() - 3);
			System.out.println("Cant see anything! F@ck!");
		}
		if (this.coordinates.getHeight() <= 0)
		{
			System.out.printf("Baloon#%s(%d) unregister from weather tower.\n", name, id);
			weatherTower.unregister(this);
		}
		if (this.coordinates.getHeight() >= 100)
			this.coordinates.setHeight(100);
	}

	@Override
	public void registerTower(WeatherTower WeatherTower) {
		System.out.printf("Tower says: Baloon#%s(%d) register to weather tower.\n", name, id);
		weatherTower = WeatherTower;
		weatherTower.register(this);
	}
}
