
public class House implements Comparable<House>{
	private int id,duration;
	private double rating;
	private int situationID = -1; //indicator for the house whether its full or not.(if its full, equal to student id.)
	
	
	
	
	
	
	
	public House(int id, int duration, double rating) {
		super();
		this.id = id;
		this.duration = duration;
		this.rating = rating;
	}


	@Override
	public int compareTo(House o) {
		// TODO Auto-generated method stub
		return this.id - o.id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


	public int getSituationID() {
		return situationID;
	}


	public void setSituationID(int situationID) {
		this.situationID = situationID;
	}
	
	
	

}
