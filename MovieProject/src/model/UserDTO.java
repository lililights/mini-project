package model;

public class UserDTO {

	private int userId;
	private int level;
	private String username;
	private String password;
	private String nickname;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public boolean equals(Object o) {
		if (o instanceof UserDTO) {
			UserDTO u = (UserDTO) o;
			if (userId == u.userId) {
				return true;
			}
		}
		return false;
	}
}
