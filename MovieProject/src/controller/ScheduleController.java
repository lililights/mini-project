package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import model.ScheduleDTO;

public class ScheduleController {
	private ArrayList<ScheduleDTO> list;
	private Random random;
	private int nextId;

	public ScheduleController() {
		list = new ArrayList<>();
		random = new Random();
		nextId = 1;

		for (int i = 7; i <= 11; i++) {

			ScheduleDTO default1 = new ScheduleDTO();
			default1.setMovieId(random.nextInt(18) + 1);
			default1.setTheaterId(random.nextInt(6) + 1);
			Calendar cal1 = Calendar.getInstance();
			cal1.set(2021, 9, i, 6, 30);
			default1.setScheduledTime(cal1);
			insert(default1);

			ScheduleDTO default2 = new ScheduleDTO();
			default2.setMovieId(random.nextInt(18) + 1);
			default2.setTheaterId(random.nextInt(6) + 1);
			Calendar cal2 = Calendar.getInstance();
			cal2.set(2021, 9, i, 6, 50);
			default2.setScheduledTime(cal2);
			insert(default2);

			ScheduleDTO default3 = new ScheduleDTO();
			default3.setMovieId(random.nextInt(18) + 1);
			default3.setTheaterId(random.nextInt(6) + 1);
			Calendar cal3 = Calendar.getInstance();
			cal3.set(2021, 9, i, 7, 10);
			default3.setScheduledTime(cal3);
			insert(default3);

			ScheduleDTO default4 = new ScheduleDTO();
			default4.setMovieId(random.nextInt(18) + 1);
			default4.setTheaterId(random.nextInt(6) + 1);
			Calendar cal4 = Calendar.getInstance();
			cal4.set(2021, 9, i, 7, 40);
			default4.setScheduledTime(cal4);
			insert(default4);

			ScheduleDTO default5 = new ScheduleDTO();
			default5.setMovieId(random.nextInt(18) + 1);
			default5.setTheaterId(random.nextInt(6) + 1);
			Calendar cal5 = Calendar.getInstance();
			cal5.set(2021, 9, i, 8, 15);
			default5.setScheduledTime(cal5);
			insert(default5);

			ScheduleDTO default6 = new ScheduleDTO();
			default6.setMovieId(random.nextInt(18) + 1);
			default6.setTheaterId(random.nextInt(6) + 1);
			Calendar cal6 = Calendar.getInstance();
			cal6.set(2021, 9, i, 8, 40);
			default6.setScheduledTime(cal6);
			insert(default6);

			ScheduleDTO default7 = new ScheduleDTO();
			default7.setMovieId(random.nextInt(18) + 1);
			default7.setTheaterId(random.nextInt(6) + 1);
			Calendar cal7 = Calendar.getInstance();
			cal7.set(2021, 9, i, 9, 10);
			default7.setScheduledTime(cal7);
			insert(default7);

			ScheduleDTO default8 = new ScheduleDTO();
			default8.setMovieId(random.nextInt(18) + 1);
			default8.setTheaterId(random.nextInt(6) + 1);
			Calendar cal8 = Calendar.getInstance();
			cal8.set(2021, 9, i, 9, 40);
			default8.setScheduledTime(cal8);
			insert(default8);

			ScheduleDTO default9 = new ScheduleDTO();
			default9.setMovieId(random.nextInt(18) + 1);
			default9.setTheaterId(random.nextInt(6) + 1);
			Calendar cal9 = Calendar.getInstance();
			cal9.set(2021, 9, i, 10, 15);
			default9.setScheduledTime(cal9);
			insert(default9);

			ScheduleDTO default10 = new ScheduleDTO();
			default10.setMovieId(random.nextInt(18) + 1);
			default10.setTheaterId(random.nextInt(6) + 1);
			Calendar cal10 = Calendar.getInstance();
			cal10.set(2021, 9, i, 10, 55);
			default10.setScheduledTime(cal10);
			insert(default10);

			ScheduleDTO default11 = new ScheduleDTO();
			default11.setMovieId(random.nextInt(18) + 1);
			default11.setTheaterId(random.nextInt(6) + 1);
			Calendar cal11 = Calendar.getInstance();
			cal11.set(2021, 9, i, 11, 15);
			default11.setScheduledTime(cal11);
			insert(default11);

			ScheduleDTO default12 = new ScheduleDTO();
			default12.setMovieId(random.nextInt(18) + 1);
			default12.setTheaterId(random.nextInt(6) + 1);
			Calendar cal12 = Calendar.getInstance();
			cal12.set(2021, 9, i, 11, 35);
			default12.setScheduledTime(cal12);
			insert(default12);

			ScheduleDTO default13 = new ScheduleDTO();
			default13.setMovieId(random.nextInt(18) + 1);
			default13.setTheaterId(random.nextInt(6) + 1);
			Calendar cal13 = Calendar.getInstance();
			cal13.set(2021, 9, i, 12, 05);
			default13.setScheduledTime(cal13);
			insert(default13);

			ScheduleDTO default14 = new ScheduleDTO();
			default14.setMovieId(random.nextInt(18) + 1);
			default14.setTheaterId(random.nextInt(6) + 1);
			Calendar cal14 = Calendar.getInstance();
			cal14.set(2021, 9, i, 12, 45);
			default14.setScheduledTime(cal14);
			insert(default14);

			ScheduleDTO default15 = new ScheduleDTO();
			default15.setMovieId(random.nextInt(18) + 1);
			default15.setTheaterId(random.nextInt(6) + 1);
			Calendar cal15 = Calendar.getInstance();
			cal15.set(2021, 9, i, 13, 10);
			default15.setScheduledTime(cal15);
			insert(default15);

			ScheduleDTO default16 = new ScheduleDTO();
			default16.setMovieId(random.nextInt(18) + 1);
			default16.setTheaterId(random.nextInt(6) + 1);
			Calendar cal16 = Calendar.getInstance();
			cal16.set(2021, 9, i, 13, 40);
			default16.setScheduledTime(cal16);
			insert(default16);

			ScheduleDTO default17 = new ScheduleDTO();
			default17.setMovieId(random.nextInt(18) + 1);
			default17.setTheaterId(random.nextInt(6) + 1);
			Calendar cal17 = Calendar.getInstance();
			cal17.set(2021, 9, i, 14, 20);
			default17.setScheduledTime(cal17);
			insert(default17);

			ScheduleDTO default18 = new ScheduleDTO();
			default18.setMovieId(random.nextInt(18) + 1);
			default18.setTheaterId(random.nextInt(6) + 1);
			Calendar cal18 = Calendar.getInstance();
			cal18.set(2021, 9, i, 14, 55);
			default18.setScheduledTime(cal18);
			insert(default18);

			ScheduleDTO default19 = new ScheduleDTO();
			default19.setMovieId(random.nextInt(18) + 1);
			default19.setTheaterId(random.nextInt(6) + 1);
			Calendar cal19 = Calendar.getInstance();
			cal19.set(2021, 9, i, 15, 10);
			default19.setScheduledTime(cal19);
			insert(default19);

			ScheduleDTO default20 = new ScheduleDTO();
			default20.setMovieId(random.nextInt(18) + 1);
			default20.setTheaterId(random.nextInt(6) + 1);
			Calendar cal20 = Calendar.getInstance();
			cal20.set(2021, 9, i, 15, 35);
			default20.setScheduledTime(cal20);
			insert(default20);

			ScheduleDTO default21 = new ScheduleDTO();
			default21.setMovieId(random.nextInt(18) + 1);
			default21.setTheaterId(random.nextInt(6) + 1);
			Calendar cal21 = Calendar.getInstance();
			cal21.set(2021, 9, i, 16, 25);
			default21.setScheduledTime(cal21);
			insert(default21);

			ScheduleDTO default22 = new ScheduleDTO();
			default22.setMovieId(random.nextInt(18) + 1);
			default22.setTheaterId(random.nextInt(6) + 1);
			Calendar cal22 = Calendar.getInstance();
			cal22.set(2021, 9, i, 16, 55);
			default22.setScheduledTime(cal22);
			insert(default22);

			ScheduleDTO default23 = new ScheduleDTO();
			default23.setMovieId(random.nextInt(18) + 1);
			default23.setTheaterId(random.nextInt(6) + 1);
			Calendar cal23 = Calendar.getInstance();
			cal23.set(2021, 9, i, 17, 10);
			default23.setScheduledTime(cal23);
			insert(default23);

			ScheduleDTO default24 = new ScheduleDTO();
			default24.setMovieId(random.nextInt(18) + 1);
			default24.setTheaterId(random.nextInt(6) + 1);
			Calendar cal24 = Calendar.getInstance();
			cal24.set(2021, 9, i, 17, 40);
			default24.setScheduledTime(cal24);
			insert(default24);

			ScheduleDTO default265 = new ScheduleDTO();
			default265.setMovieId(random.nextInt(18) + 1);
			default265.setTheaterId(random.nextInt(6) + 1);
			Calendar cal265 = Calendar.getInstance();
			cal265.set(2021, 9, i, 18, 15);
			default265.setScheduledTime(cal265);
			insert(default265);

			ScheduleDTO default26 = new ScheduleDTO();
			default26.setMovieId(random.nextInt(18) + 1);
			default26.setTheaterId(random.nextInt(6) + 1);
			Calendar cal26 = Calendar.getInstance();
			cal26.set(2021, 9, i, 18, 45);
			default26.setScheduledTime(cal26);
			insert(default26);

			ScheduleDTO default27 = new ScheduleDTO();
			default27.setMovieId(random.nextInt(18) + 1);
			default27.setTheaterId(random.nextInt(6) + 1);
			Calendar cal27 = Calendar.getInstance();
			cal27.set(2021, 9, i, 19, 10);
			default27.setScheduledTime(cal27);
			insert(default27);

			ScheduleDTO default28 = new ScheduleDTO();
			default28.setMovieId(random.nextInt(18) + 1);
			default28.setTheaterId(random.nextInt(6) + 1);
			Calendar cal28 = Calendar.getInstance();
			cal28.set(2021, 9, i, 19, 40);
			default28.setScheduledTime(cal28);
			insert(default28);

			ScheduleDTO default29 = new ScheduleDTO();
			default29.setMovieId(random.nextInt(18) + 1);
			default29.setTheaterId(random.nextInt(6) + 1);
			Calendar cal29 = Calendar.getInstance();
			cal29.set(2021, 9, i, 20, 10);
			default29.setScheduledTime(cal29);
			insert(default29);

			ScheduleDTO default30 = new ScheduleDTO();
			default30.setMovieId(random.nextInt(18) + 1);
			default30.setTheaterId(random.nextInt(6) + 1);
			Calendar cal30 = Calendar.getInstance();
			cal30.set(2021, 9, i, 20, 30);
			default30.setScheduledTime(cal30);
			insert(default30);

			ScheduleDTO default31 = new ScheduleDTO();
			default31.setMovieId(random.nextInt(18) + 1);
			default31.setTheaterId(random.nextInt(6) + 1);
			Calendar cal31 = Calendar.getInstance();
			cal31.set(2021, 9, i, 21, 5);
			default31.setScheduledTime(cal31);
			insert(default31);

			ScheduleDTO default32 = new ScheduleDTO();
			default32.setMovieId(random.nextInt(18) + 1);
			default32.setTheaterId(random.nextInt(6) + 1);
			Calendar cal32 = Calendar.getInstance();
			cal32.set(2021, 9, i, 21, 40);
			default32.setScheduledTime(cal32);
			insert(default32);

			ScheduleDTO default33 = new ScheduleDTO();
			default33.setMovieId(random.nextInt(18) + 1);
			default33.setTheaterId(random.nextInt(6) + 1);
			Calendar cal33 = Calendar.getInstance();
			cal33.set(2021, 9, i, 22, 10);
			default33.setScheduledTime(cal33);
			insert(default33);

			ScheduleDTO default34 = new ScheduleDTO();
			default34.setMovieId(random.nextInt(18) + 1);
			default34.setTheaterId(random.nextInt(6) + 1);
			Calendar cal34 = Calendar.getInstance();
			cal34.set(2021, 9, i, 22, 40);
			default34.setScheduledTime(cal34);
			insert(default34);

			ScheduleDTO default35 = new ScheduleDTO();
			default35.setMovieId(random.nextInt(18) + 1);
			default35.setTheaterId(random.nextInt(6) + 1);
			Calendar cal35 = Calendar.getInstance();
			cal35.set(2021, 9, i, 23, 15);
			default35.setScheduledTime(cal35);
			insert(default35);

			ScheduleDTO default36 = new ScheduleDTO();
			default36.setMovieId(random.nextInt(18) + 1);
			default36.setTheaterId(random.nextInt(6) + 1);
			Calendar cal36 = Calendar.getInstance();
			cal36.set(2021, 9, i, 23, 40);
			default36.setScheduledTime(cal36);
			insert(default36);

			ScheduleDTO default37 = new ScheduleDTO();
			default37.setMovieId(random.nextInt(18) + 1);
			default37.setTheaterId(random.nextInt(6) + 1);
			Calendar cal37 = Calendar.getInstance();
			cal37.set(2021, 9, i, 24, 00);
			default37.setScheduledTime(cal37);
			insert(default37);

			ScheduleDTO default38 = new ScheduleDTO();
			default38.setMovieId(random.nextInt(18) + 1);
			default38.setTheaterId(random.nextInt(6) + 1);
			Calendar cal38 = Calendar.getInstance();
			cal38.set(2021, 9, i, 24, 15);
			default38.setScheduledTime(cal38);
			insert(default38);

			ScheduleDTO default39 = new ScheduleDTO();
			default39.setMovieId(random.nextInt(18) + 1);
			default39.setTheaterId(random.nextInt(6) + 1);
			Calendar cal39 = Calendar.getInstance();
			cal39.set(2021, 9, i, 20, 55);
			default39.setScheduledTime(cal39);
			insert(default39);

			ScheduleDTO default40 = new ScheduleDTO();
			default40.setMovieId(random.nextInt(18) + 1);
			default40.setTheaterId(random.nextInt(6) + 1);
			Calendar cal40 = Calendar.getInstance();
			cal40.set(2021, 9, i, 21, 20);
			default40.setScheduledTime(cal40);
			insert(default40);
		}
		deleteDuplicate();
	}

	public void insert(ScheduleDTO s) {
		s.setScheduleId(nextId++);
		list.add(s);
	}

	public ArrayList<ScheduleDTO> selectAll() {
		ArrayList<ScheduleDTO> temp = new ArrayList<>();

		for (ScheduleDTO s : list) {
			ScheduleDTO tempS = new ScheduleDTO(s);
			temp.add(tempS);
		}
		return temp;
	}

	public ScheduleDTO selectOne(int scheduleId) {
		for (ScheduleDTO s : list) {
			if (s.getScheduleId() == scheduleId) {
				return new ScheduleDTO(s);
			}
		}
		return null;
	}

	public ArrayList<ScheduleDTO> selectByTheaterId(int theaterId) {
		ArrayList<ScheduleDTO> temp = new ArrayList<>();

		for (ScheduleDTO s : list) {
			if (s.getTheaterId() == theaterId) {
				ScheduleDTO tempR = new ScheduleDTO(s);
				temp.add(tempR);
			}
		}
		return temp;
	}

	public ArrayList<ScheduleDTO> selectByMovieId(int movieId) {
		ArrayList<ScheduleDTO> temp = new ArrayList<>();

		for (ScheduleDTO s : list) {
			if (s.getMovieId() == movieId) {
				ScheduleDTO tempR = new ScheduleDTO(s);
				temp.add(tempR);
			}
		}
		return temp;
	}

	public void update(ScheduleDTO s) {
		int index = list.indexOf(s);
		list.set(index, s);
	}

	public void delete(int scheduleId) {
		ScheduleDTO s = new ScheduleDTO();
		s.setScheduleId(scheduleId);
		list.remove(s);
	}

	public void deleteByMovieId(int movieId) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getMovieId() == movieId) {
				list.remove(i);
				i = -1;
			}
		}
	}

	public void deleteByTheaterId(int theaterId) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTheaterId() == theaterId) {
				list.remove(i);
				i = -1;
			}
		}
	}

	public void deleteDuplicate() {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (i != j && list.get(i).getMovieId() == list.get(j).getMovieId()
						&& list.get(i).getTheaterId() == list.get(j).getTheaterId()
						&& list.get(i).getScheduledTime().equals(list.get(j).getScheduledTime())) {
					list.remove(j);
					j = -1;
				}
			}
		}
	}

	public ArrayList<ScheduleDTO> sortByMovieId(ArrayList<ScheduleDTO> temp1) {
		ArrayList<ScheduleDTO> temp2 = new ArrayList<>();
		for (int i = 0; i < temp1.size() - 1; i++) {
			if (temp1.get(i).getMovieId() > temp1.get(i + 1).getMovieId()) {
				temp2.add(temp1.get(i));
				temp1.set(i, temp1.get(i + 1));
				temp1.set((i + 1), temp2.get(0));
				temp2.clear();
				i = -1;
			}
		}
		return temp1;
	}

	public ArrayList<ScheduleDTO> sortTheaterId(ArrayList<ScheduleDTO> temp1) {
		ArrayList<ScheduleDTO> temp2 = new ArrayList<>();
		for (int i = 0; i < temp1.size() - 1; i++) {
			if (temp1.get(i).getTheaterId() > temp1.get(i + 1).getTheaterId()) {
				temp2.add(temp1.get(i));
				temp1.set(i, temp1.get(i + 1));
				temp1.set((i + 1), temp2.get(0));
				temp2.clear();
				i = -1;
			}
		}
		return temp1;
	}

	public ArrayList<ScheduleDTO> sortBySchelduledTime(ArrayList<ScheduleDTO> temp1) {
		ArrayList<ScheduleDTO> temp2 = new ArrayList<>();
		int t1;
		int t2;
		for (int i = 0; i < temp1.size() - 1; i++) {
			t1 = temp1.get(i).getScheduledTime().get(Calendar.MINUTE);
			t2 = temp1.get(i + 1).getScheduledTime().get(Calendar.MINUTE);
			if (t1 > t2) {
				temp2.add(temp1.get(i));
				temp1.set(i, temp1.get(i + 1));
				temp1.set((i + 1), temp2.get(0));
				temp2.clear();
				i = -1;
			}
		}
		for (int i = 0; i < temp1.size() - 1; i++) {
			t1 = temp1.get(i).getScheduledTime().get(Calendar.HOUR_OF_DAY);
			t2 = temp1.get(i + 1).getScheduledTime().get(Calendar.HOUR_OF_DAY);
			if (t1 > t2) {
				temp2.add(temp1.get(i));
				temp1.set(i, temp1.get(i + 1));
				temp1.set((i + 1), temp2.get(0));
				temp2.clear();
				i = -1;
			}
		}
		for (int i = 0; i < temp1.size() - 1; i++) {
			t1 = temp1.get(i).getScheduledTime().get(Calendar.DAY_OF_MONTH);
			t2 = temp1.get(i + 1).getScheduledTime().get(Calendar.DAY_OF_MONTH);
			if (t1 > t2) {
				temp2.add(temp1.get(i));
				temp1.set(i, temp1.get(i + 1));
				temp1.set((i + 1), temp2.get(0));
				temp2.clear();
				i = -1;
			}
		}
		for (int i = 0; i < temp1.size() - 1; i++) {
			t1 = temp1.get(i).getScheduledTime().get(Calendar.MONTH);
			t2 = temp1.get(i + 1).getScheduledTime().get(Calendar.MONTH);
			if (t1 > t2) {
				temp2.add(temp1.get(i));
				temp1.set(i, temp1.get(i + 1));
				temp1.set((i + 1), temp2.get(0));
				temp2.clear();
				i = -1;
			}
		}
		return temp1;
	}

	public ArrayList<ScheduleDTO> getByDate(ArrayList<ScheduleDTO> temp1, int date) {
		ArrayList<ScheduleDTO> temp2 = new ArrayList<>();
		for (int i = 0; i < temp1.size(); i++) {
			if (temp1.get(i).getScheduledTime().get(Calendar.DAY_OF_MONTH) == date) {
				temp2.add(temp1.get(i));
			}
		}
		return temp2;
	}
}
