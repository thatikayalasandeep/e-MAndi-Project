package model;

public class Feedback {
 
	private long yourid;
	private int rating;
	private String comment;
	private String suggestion;
	
	public Feedback(long yourid, int rating, String comment, String suggestion) {
		this.yourid = yourid;
		this.rating = rating;
		this.comment = comment;
		this.suggestion = suggestion;
	}

	public long getYourid() {
		return yourid;
	}

	public void setYourid(long yourid) {
		this.yourid = yourid;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	
	
	
	
}
