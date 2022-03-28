package model;

import java.util.Calendar;

public class ReviewDTO {

	private int reviewId;
	private int userId;
	private int movieId;
	private String title;
	private String comment;
	private int rating;
	private Calendar writtenDate;

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Calendar getWrittenDate() {
		return writtenDate;
	}

	public void setWrittenDate(Calendar writtenDate) {
		this.writtenDate = writtenDate;
	}

	public boolean equals(Object o) {
		if (o instanceof ReviewDTO) {
			ReviewDTO r = (ReviewDTO) o;
			if (reviewId == r.reviewId) {
				return true;
			}
		}
		return false;
	}

	public ReviewDTO() {

	}

	public ReviewDTO(ReviewDTO r) {
		reviewId = r.reviewId;
		userId = r.userId;
		movieId = r.movieId;
		title = r.title;
		comment = r.comment;
		rating = r.rating;
		writtenDate = Calendar.getInstance();
		writtenDate.setTime(r.writtenDate.getTime());
	}
}