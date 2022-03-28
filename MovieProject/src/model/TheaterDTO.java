package model;

public class TheaterDTO {

	private int theaterId;
	private String branch;
	private String location;
	private String contactNum;

	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public TheaterDTO() {

	}

	public TheaterDTO(TheaterDTO t) {
		theaterId = t.theaterId;
		branch = t.branch;
		location = t.location;
		contactNum = t.contactNum;
	}

	public boolean equals(Object o) {
		if (o instanceof TheaterDTO) {
			TheaterDTO t = (TheaterDTO) o;
			if (theaterId == t.theaterId) {
				return true;
			}
		}
		return false;
	}

}
