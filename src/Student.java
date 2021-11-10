
public class Student implements Comparable<Student> {
	private int id,duration;
	private double rating;
	private String name;
	private int situationID = -1; //indicator for the student whether its full or not.(if its full, equal to house id.)
	private int isStayed = 0; // for the output, indicates that if a student ever stayed a house.
	
	
	public Student(int id, String name, int duration, double rating) {
		super();
		this.id = id;
		this.duration = duration;
		this.rating = rating;
		this.name = name;
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.id - o.id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", duration=" + duration + ", rating=" + rating + ", name=" + name
				+ ", situationID=" + situationID + ", isStayed=" + isStayed + "]";
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSituationID() {
		return situationID;
	}

	public void setSituationID(int situationID) {
		this.situationID = situationID;
	}

	public int getIsStayed() {
		return isStayed;
	}

	public void setIsStayed(int isStayed) {
		this.isStayed = isStayed;
	}

	
	
	
	
	

}
