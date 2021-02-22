package main;

public class MoveEvent extends Event {

	public MoveEvent(double t, Person p) {
		super(t, p);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void exec() {
		// TODO Auto-generated method stub
		System.out.println("Person " + super.person.id +" is moving! at day:" + super.time.intValue());
		if(super.person.awareness == 1) {
			super.person.signed = true; // Conversion!
			
			for(ExposureEvent e : super.person.Events) {
				super.person.CAC += e.c.CPV;
			}
		}
	}


}
