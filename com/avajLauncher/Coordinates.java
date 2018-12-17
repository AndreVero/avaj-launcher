package com.avajLauncher;

public class Coordinates {
	
	private int longitude;
	private int latitude;
	private int height;
	
	Coordinates(int longitude, int latitude, int height) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}
	
	public int getLatitude() {
		return this.latitude;
	}
	
	public int getLongitude() {
		return this.longitude;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	
	public int getHeight() {
		return this.height;
	}
}
