package main;

import java.util.ArrayList;

public class Person {

	public boolean signed;
	public boolean isMoving;
	public Double intent; // Propensity to sign
	public Double awareness; 
	public Integer id;
	public ArrayList<ExposureEvent> Events;
	public Double CAC;

	public Person(int id) {
		this.id = id;
		this.signed = false;
		this.isMoving = false;
		this.intent = 0d;
		this.awareness = 0d;
		this.Events = new ArrayList<ExposureEvent>();
		this.CAC = 0d;
	}
	
}
