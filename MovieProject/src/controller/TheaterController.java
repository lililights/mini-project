package controller;

import java.util.ArrayList;
import model.TheaterDTO;

public class TheaterController {
	private ArrayList<TheaterDTO> list;
	private int nextId;

	public TheaterController() {
		list = new ArrayList<>();
		nextId = 1;

		TheaterDTO default1 = new TheaterDTO();
		default1.setBranch("강남점");
		default1.setContactNum("1544-1121");
		default1.setLocation("서울 강남구 역삼동 814-6 스타플렉스");
		insert(default1);

		TheaterDTO default2 = new TheaterDTO();
		default2.setBranch("동대문점");
		default2.setContactNum("1544-1122");
		default2.setLocation("서울 중구 을지로6가 17-2");
		insert(default2);

		TheaterDTO default3 = new TheaterDTO();
		default3.setBranch("센트럴시티점");
		default3.setContactNum("1544-1123");
		default3.setLocation("서울 서초구 반포동 19-3 센트럴시티");
		insert(default3);

		TheaterDTO default4 = new TheaterDTO();
		default4.setBranch("여의도점");
		default4.setContactNum("1544-1124");
		default4.setLocation("서울 영등포구 여의도동 23-1 지하3층");
		insert(default4);

		TheaterDTO default5 = new TheaterDTO();
		default5.setBranch("잠실점");
		default5.setContactNum("1544-1125");
		default5.setLocation("서울 송파구 신천동 29");
		insert(default5);

		TheaterDTO default6 = new TheaterDTO();
		default6.setBranch("홍대점");
		default6.setContactNum("1544-1126");
		default6.setLocation("서울 마포구 동교동 159-12 토로스 쇼핑타워");
		insert(default6);
	}

	public void insert(TheaterDTO t) {
		t.setTheaterId(nextId++);
		list.add(t);
	}

	public ArrayList<TheaterDTO> selectAll() {
		ArrayList<TheaterDTO> temp = new ArrayList<>();
		for (TheaterDTO t : list) {
			TheaterDTO tempB = new TheaterDTO(t);
			temp.add(tempB);
		}
		return temp;
	}

	public TheaterDTO selectOne(int theaterId) {
		for (TheaterDTO t : list) {
			if (t.getTheaterId() == theaterId) {
				return new TheaterDTO(t);
			}
		}
		return null;
	}

	public void update(TheaterDTO t) {
		int index = list.indexOf(t);
		list.set(index, t);
	}

	public void delete(int theaterId) {
		TheaterDTO t = new TheaterDTO();
		t.setTheaterId(theaterId);
		list.remove(t);
	}
}
