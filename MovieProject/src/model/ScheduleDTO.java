package model;

import java.util.Calendar;

public class ScheduleDTO {

	private int scheduleId;
	private int movieId;
	private int theaterId;
	private Calendar scheduledTime;

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

	public Calendar getScheduledTime() {
		return scheduledTime;
	}

	public void setScheduledTime(Calendar scheduledTime) {
		this.scheduledTime = scheduledTime;
	}
	
	public ScheduleDTO() {
		
	}
	
	public ScheduleDTO(ScheduleDTO s) {
		scheduleId =s.scheduleId;
		movieId = s.movieId;
		theaterId = s.theaterId;
		scheduledTime = s.scheduledTime;
	}

	public boolean equals(Object o) {
		if (o instanceof ScheduleDTO) {
			ScheduleDTO s = (ScheduleDTO) o;
			if (scheduleId == s.scheduleId) {
				return true;
			}
		}
		return false;
	}

}
