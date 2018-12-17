package com.avajLauncher;
import java.util.ArrayList;

public class Tower {

	private ArrayList<Flyable> observers = new ArrayList<Flyable>();
	
	public void register(Flyable flyable) {
		this.observers.add(flyable);
	}
	
	public void	unregister(Flyable flyable) {
		this.observers.remove(flyable);
	}
	
	protected void conditionsChange() {
		int i = -1;
		
		while (++i < observers.size())
			observers.get(i).updateConditions();
	}
}
