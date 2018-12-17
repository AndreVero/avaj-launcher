package com.avajLauncher;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class Simulation {

	public static void main(String[] args) throws Exception {
		if (args.length <= 0)
		{
			System.out.println("You miss filename");
			return ;
		}
		ArrayList<Flyable> fl = new ArrayList<Flyable>();
		WeatherTower wt = new WeatherTower();
		File f = new File("./" + args[0]);
		AircraftFactory af = new AircraftFactory();
		int cicle = 0;
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line;
			line = br.readLine();
			if (line == null || !line.matches("[0-9]+"))
			{
				br.close();
				System.out.println("Check you count of cicles!");
				return ;
			}
			else
				cicle = Integer.parseInt(line);
			while ((line = br.readLine()) != null) {
				String arr[] = line.split(" ");
				Flyable fly;
				if (arr.length <= 4 || !arr[0].matches("[a-zA-Z]+") || !arr[2].matches("[0-9]+")
						|| !arr[3].matches("[0-9]+") || !arr[4].matches("[0-9]+"))
				{
					br.close();
					System.out.println("Check you data!");
					return ;
				}
				try {
				fly = af.newAircraft(arr[0], arr[1], Integer.parseInt(arr[2]),
						Integer.parseInt(arr[3]), Integer.parseInt(arr[4]));
				}
				catch (TypeException e)
				{
					System.out.println( "TypeException : "+ e.getMessage());
					br.close();
					return ;
				}
				fl.add(fly);
			}
			br.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		try {
			System.setOut(new PrintStream(new File("simulation.txt")));
		} catch (Exception e) {
			System.out.println("Something went wrong");
		}
		int i = -1;
		
		while (++i < fl.size())
			fl.get(i).registerTower(wt);
		i = -1;
		while (++i < cicle)
			wt.changeWeather();
	}
}
