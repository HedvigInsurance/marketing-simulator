package main;

public class ExposureEvent extends Event {

	public Channel c;
	
	public ExposureEvent(double t, Channel c, Person p) {
		super(t, p);
		this.c = c;
		
		//System.out.println("New exposure event: " + c.name + " at time: " + t);
	}

	@Override
	public void exec() {
		//System.out.println("Exposure:[" + c.name + "]: person:" + super.person.id + " awareness:"+ super.person.awareness);
		super.person.awareness = Math.min(1d, super.person.awareness + c.awarenessIncrease); // Awareness 1 is max
		Main.totalSpend += c.CPV;
		super.person.Events.add(this);
		
		Main.Simulator.add(new ExposureEvent(super.time + Main.nextTime(c.exposureRate),c, super.person));
	}

}
