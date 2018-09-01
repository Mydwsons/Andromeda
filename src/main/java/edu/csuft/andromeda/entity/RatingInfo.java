package edu.csuft.andromeda.entity;

public class RatingInfo {
	String name;
	String score;
	String time;

	public RatingInfo() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "RatingInfo [name=" + name + ", score=" + score + ", time=" + time + "]";
	}

}
