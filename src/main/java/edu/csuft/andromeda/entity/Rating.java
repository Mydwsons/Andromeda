package edu.csuft.andromeda.entity;

public class Rating {
	int id;
	int userId;
	String score;
	String time;

	public Rating() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
		return "Rating [id=" + id + ", userId=" + userId + ", score=" + score + ", time=" + time + "]";
	}

}
