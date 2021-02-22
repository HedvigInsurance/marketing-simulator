package main;

public class Channel {

	public String name;
	public Double CPV; // Cost per view
	public Double awarenessIncrease;
	public Double exposureRate;
	
	public Channel(String name, Double cpv, Double awarenessIncrease, Double exposureRate) { // 1/time between exposures

		this.name = name;
		this.CPV = cpv;
		this.awarenessIncrease = awarenessIncrease;
		this.exposureRate = exposureRate;
	}
	
}
