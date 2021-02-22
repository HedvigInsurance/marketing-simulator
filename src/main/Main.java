package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {

	public static PriorityQueue<Event> Simulator;
	public static HashMap<Integer, Person> Cohort;
	public static ArrayList<Channel> Channels;
	public static int cohortSize = 20;
	public static int simulationLength = 4*365; // In days
	public static double moveRate = 1d/(365d*4d); // = lambda i.e. you move ones every 4 years
	public static Double totalSpend = 0d;
	
	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		Simulator = new PriorityQueue<Event>();
		Cohort = new HashMap<Integer, Person>();
		Channels = new ArrayList<Channel>();
		runSimulator();
	}

	public static void init() {
		//System.out.println(nextTime(moveRate)/365d);
		//System.exit(0);
		
		Channels.add(new Channel("fb",0.5d,0.05d,1/10d));
		Channels.add(new Channel("google",0.4d,0.05d,1/7d));
		Channels.add(new Channel("tv",1d,0.2d,1/2d));
		Channels.add(new Channel("atl",1d,0.2d,1/3d));
	
		for(int i = 0; i<cohortSize; i++) {
			Person p = new Person(i);
			Simulator.add(new MoveEvent(nextTime(moveRate),p)); // When the person moves next time 
			for(Channel c : Channels) {
				Simulator.add(new ExposureEvent(nextTime(c.exposureRate),c, p)); // When the person is exposed to the channel next time 
			}
			Cohort.put(i, p);
		}
		
		System.out.println("Number of persons:" + Simulator.size());
		System.out.println("Number of channels:" + Channels.size());
	}
	
	public static void exit() {
		for(Person p : Cohort.values()) {
			System.out.println("Person #" +p.id + ": signed?" + p.signed + " -> CAC:" + p.CAC.intValue() + "kr");
		}
		System.out.println("Total spend: " + totalSpend.intValue() + "kr");
		System.out.println("Simulation done");
	}
	
	public static void runSimulator() {
		System.out.println("Initilizing simulator...");
		init();
		System.out.println("...done");	
		System.out.println("Running simulator");
		while(!Simulator.isEmpty()){
		    Event e = Simulator.poll();
		    //System.out.println("Time:" + e.getTime());
		    if(e.getTime()>simulationLength) break; 
		    e.exec();
		}
		exit();
	}
	
	public static double nextTime(double lambda) { // Generate next time an event occurs for Poisson process
		return -Math.log(1.0 - Math.random()) / lambda;
	}
	
}
