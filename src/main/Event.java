package main;

public abstract class Event implements Comparable<Event>{

	public Double time; 
	public Person person;

	public abstract void exec();
	
	public Event(double t, Person p) {this.time = t; this.person = p;}
	
    public int compareTo(Event otherEvent) {      
        //compare name
        int nameDiff = time.compareTo(otherEvent.time);
        if(nameDiff != 0){
            return nameDiff;
        }
        //names are equals compare age
        return 0;
    }

	public Double getTime() {
		return time;
	}

}
