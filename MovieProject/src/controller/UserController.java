package controller;

import java.util.ArrayList;
import model.UserDTO;

public class UserController {
	private ArrayList<UserDTO> list;
	private int nextId;

	public UserController() {
		list = new ArrayList<UserDTO>();
		UserDTO u = new UserDTO();
		nextId = 1;

		u.setLevel(1);
		u.setUsername("admin");
		u.setPassword("111");
		u.setNickname("관리자");

		insert(u);

		for (int i = 1; i <= 3; i++) {
			UserDTO u1 = new UserDTO();
			u1.setLevel(2);
			u1.setUsername("a" + i);
			u1.setPassword("111");
			u1.setNickname("전문평론가" + i);

			insert(u1);
		}

		for (int i = 1; i <= 3; i++) {
			UserDTO u2 = new UserDTO();
			u2.setLevel(3);
			u2.setUsername("b" + i);
			u2.setPassword("111");
			u2.setNickname("회원" + i);

			insert(u2);
		}
	}

	public void insert(UserDTO u) {
		u.setUserId(nextId++);

		list.add(u);
	}

	public UserDTO deepCopy(UserDTO u) {
		UserDTO temp = new UserDTO();

		temp.setUserId(u.getUserId());
		temp.setLevel(u.getLevel());
		temp.setUsername(u.getUsername());
		temp.setPassword(u.getPassword());
		temp.setNickname(u.getNickname());

		return temp;
	}

	public UserDTO selectOne(int userId) {
		for (UserDTO u : list) {
			if (u.getUserId() == userId) {
				return deepCopy(u);
			}
		}
		return null;
	}

	public void update(UserDTO u) {
		int index = list.indexOf(u);
		list.set(index, u);
	}

	public void delete(int userId) {
		UserDTO u = new UserDTO();
		u.setUserId(userId);
		list.remove(u);
	}

	public boolean validateUsername(String username) {
		if (username.equalsIgnoreCase("X") || username.equalsIgnoreCase("O")) {
			return true;
		}
		for (UserDTO u : list) {
			if (u.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}

	public UserDTO auth(String username, String password) {
		for (UserDTO u : list) {
			if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
				return deepCopy(u);
			}
		}
		return null;
	}

}
