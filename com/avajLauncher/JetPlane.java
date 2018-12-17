package com.avajLauncher;

public class JetPlane extends Aircraft implements Flyable {

	private WeatherTower weatherTower;
	
	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		if (WeatherProvider.getWeatherProvider().getCurrentWeather(coordinates) == "SUN")
		{
			this.coordinates.setHeight(this.coordinates.getHeight() + 2);
			this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
			System.out.println("It's too hot for me!");
		}
		else if (WeatherProvider.getWeatherProvider().getCurrentWeather(coordinates) == "RAIN")
		{
			this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
			System.out.println("It's raining. Better watch out for lightings.");
		}
		else if (WeatherProvider.getWeatherProvider().getCurrentWeather(coordinates) == "SNOW")
		{
			this.coordinates.setHeight(this.coordinates.getHeight() - 7);
			System.out.println("OMG! Winter is coming!");
		}
		else
		{
			this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
			System.out.println("In the fog you can be caught insulting the feelings of believers");
		}
		if (this.coordinates.getHeight() <= 0)
		{
			System.out.printf("JetPlane#%s(%d) unregister from weather tower.\n", name, id);
			weatherTower.unregister(this);
		}
		if (this.coordinates.getHeight() >= 100)
			this.coordinates.setHeight(100);
	}

	@Override
	public void registerTower(WeatherTower WeatherTower) {
		System.out.printf("Tower says: JetPlane#%s(%d) register to weather tower.\n", name, id);
		weatherTower = WeatherTower;
		weatherTower.register(this);
	}

}
