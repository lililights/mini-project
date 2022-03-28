package viewer;

import java.util.Scanner;
import java.util.ArrayList;

import controller.ScheduleController;
import model.ScheduleDTO;
import model.UserDTO;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import myUtil.ScannerUtil;

public class ScheduleViewer {

	private Scanner scanner;
	private ScheduleController scheduleController;
	private UserDTO logIn;
	private Calendar cal;
	private SimpleDateFormat mde1;
	private SimpleDateFormat mde2;
	private SimpleDateFormat hm;
	private MoviesViewer moviesViewer;
	private TheaterViewer theaterViewer;

	public void setLogIn(UserDTO logIn) {
		this.logIn = logIn;
	}

	public void setTheaterViewer(TheaterViewer theaterViewer) {
		this.theaterViewer = theaterViewer;
	}

	public ScheduleViewer(Scanner scanner, MoviesViewer moviesViewer) {
		this.scanner = scanner;
		this.moviesViewer = moviesViewer;
		scheduleController = new ScheduleController();
		cal = Calendar.getInstance();
		mde1 = new SimpleDateFormat("MM/dd(EEE)");
		mde2 = new SimpleDateFormat("M월 d일 EEE요일");
		hm = new SimpleDateFormat("HH:mm");
	}

	public void showByMovies(int movieId, String movieName) {
		while (true) {
			if (scheduleController.selectByMovieId(movieId).isEmpty()) {
				ScannerUtil.notificationL("해당 영화는 상영일정이 없습니다.");

				if (logIn == null || logIn.getLevel() != 1) {
					ScannerUtil.ok(scanner, null);
					System.out.println();
					break;

				} else {
					String userChoice2 = ScannerUtil.nextLine(scanner, "[N] 관리자 메뉴: 새 상영일정 등록\n[0] 뒤로가기\n");

					while (!userChoice2.equals("0") && !userChoice2.equalsIgnoreCase("N")) {
						System.out.println("(잘못 입력하셨습니다.)");
						System.out.println("-----------------------------------------------------------------");
						userChoice2 = ScannerUtil.nextLine(scanner, "[N] 관리자 메뉴: 새 상영일정 등록\n[0] 뒤로가기\n");
					}
					if (userChoice2.equals("0")) {
						ScannerUtil.notificationL(null);
						break;
					} else if (userChoice2.equalsIgnoreCase("N")) {
						insertNew();
					}
				}
			} else {
				System.out.println();
				printByMovies(movieId, movieName);

				if (logIn == null || logIn.getLevel() != 1) {
					ScannerUtil.nextIntOnly(scanner, "[0] 뒤로가기\n", 0, 0);
					ScannerUtil.notificationL(null);
					break;
				} else {
					String userChoice2 = ScannerUtil.nextLine(scanner,
							"[N] 관리자 메뉴: 새 상영일정 등록\n[E] 관리자 메뉴: 상영일정 수정\n[D] 관리자 메뉴: 상영일정 삭제\n[0] 뒤로가기\n");

					while (!userChoice2.equals("0") && !userChoice2.equalsIgnoreCase("N")
							&& !userChoice2.equalsIgnoreCase("E") && !userChoice2.equalsIgnoreCase("D")) {
						System.out.println("(잘못 입력하셨습니다.)");
						System.out.println("-----------------------------------------------------------------");
						userChoice2 = ScannerUtil.nextLine(scanner,
								"[N] 관리자 메뉴: 새 상영일정 등록\n[E] 관리자 메뉴: 상영일정 수정\n[D] 관리자 메뉴: 상영일정 삭제\n[0] 뒤로가기\n");
					}
					if (userChoice2.equals("0")) {
						ScannerUtil.notificationL(null);
						break;
					} else if (userChoice2.equalsIgnoreCase("N")) {
						insertNew();
					} else if (userChoice2.equalsIgnoreCase("E")) {
						updateByMovies(movieId);
					} else if (userChoice2.equalsIgnoreCase("D")) {
						deleteByMovies(movieId);
					}
				}
			}
		}
	}

	private void printByMovies(int movieId, String movieName) {
		ArrayList<ScheduleDTO> temp1 = scheduleController.selectByMovieId(movieId);
		ArrayList<ScheduleDTO> temp2 = scheduleController.sortBySchelduledTime(temp1);
		ArrayList<ScheduleDTO> temp3 = scheduleController.sortTheaterId(temp2);

		System.out.println("=================================================================");
		System.out.println("<" + movieName + "> 상영시간표");
		System.out.println("=================================================================");

		for (int i = 0; i < temp3.size(); i++) {
			cal = temp3.get(i).getScheduledTime();
			if (i == 0 || temp3.get(i).getTheaterId() != temp3.get(i - 1).getTheaterId()) {
				System.out.print(" " + theaterViewer.getTheaterName(temp3.get(i).getTheaterId()));
			}
			if (i == 0 || temp3.get(i).getTheaterId() != temp3.get(i - 1).getTheaterId()
					|| temp3.get(i).getScheduledTime().get(Calendar.DAY_OF_MONTH) != temp3.get(i - 1).getScheduledTime()
							.get(Calendar.DAY_OF_MONTH)) {
				System.out.print("\n\n " + mde1.format(cal.getTime()) + " ");
			}
			System.out.print(" " + hm.format(cal.getTime()) + "  ");
			if (i < temp3.size() - 1 && temp3.get(i).getTheaterId() != temp3.get(i + 1).getTheaterId()) {
				System.out.println("\n-----------------------------------------------------------------");
			}
		}
		System.out.println("\n=================================================================\n");
	}

	private void updateByMovies(int movieId) {
		ArrayList<ScheduleDTO> temp1 = scheduleController.selectByMovieId(movieId);
		ArrayList<ScheduleDTO> temp2 = scheduleController.sortBySchelduledTime(temp1);
		ArrayList<ScheduleDTO> temp3 = scheduleController.sortTheaterId(temp2);
		System.out.println("-----------------------------------------------------------------");
		System.out.println("수정할 상영일정을 선택해주세요.\n");
		for (int i = 0; i < temp3.size(); i++) {
			System.out.print("[" + (i + 1) + "] ");
			cal = temp3.get(i).getScheduledTime();
			System.out.println(mde1.format(cal.getTime()) + " " + hm.format(cal.getTime()) + " "
					+ theaterViewer.getTheaterName(temp3.get(i).getTheaterId()));
		}
		int userChoice = ScannerUtil.nextIntOnly(scanner, "", 1, temp3.size());

		ScheduleDTO s = scheduleController.selectOne(temp3.get(userChoice - 1).getScheduleId());
		System.out.println("-----------------------------------------------------------------");
		int mon = ScannerUtil.nextIntOnly(scanner, "변경할 상영일정의 날짜를 입력해주세요.\n\n월(1~12):\n", 1, 12);
		System.out.println("-----------------------------------------------------------------");
		int d = ScannerUtil.nextIntOnly(scanner, "일(1~31):\n", 1, 31);
		System.out.println("-----------------------------------------------------------------");
		int h = ScannerUtil.nextIntOnly(scanner, "시(00~23):\n", 00, 23);
		System.out.println("-----------------------------------------------------------------");
		int min = ScannerUtil.nextIntOnly(scanner, "분(00~59):\n", 00, 59);

		Calendar cal = Calendar.getInstance();
		cal.set(2021, mon - 1, d, h, min);
		s.setScheduledTime(cal);

		System.out.println("-----------------------------------------------------------------");
		String yesNo = ScannerUtil.nextLine(scanner, "정말로 수정하시겠습니까?\n수정하려면 [Y], 취소하려면 [X]를 입력해주세요.\n");
		while (!(yesNo.equalsIgnoreCase("X")) && !(yesNo.equalsIgnoreCase("Y"))) {
			System.out.println("(잘못 입력하셨습니다.)");
			System.out.println("-----------------------------------------------------------------");
			yesNo = ScannerUtil.nextLine(scanner, "정말로 수정하시겠습니까?\n수정하려면 [Y], 취소하려면 [X]를 입력해주세요.\n");
		}
		if (yesNo.equalsIgnoreCase("Y")) {
			scheduleController.update(s);
			ScannerUtil.notificationL("변경이 완료되었습니다. 이전 화면으로 돌아갑니다.");
			ScannerUtil.ok(scanner, null);

		} else if (yesNo.equalsIgnoreCase("X")) {
			System.out.println("\n<<변경이 취소되었습니다. 이전 화면으로 돌아갑니다.>>");
		}
	}

	private void deleteByMovies(int movieId) {
		ArrayList<ScheduleDTO> temp1 = scheduleController.selectByMovieId(movieId);
		ArrayList<ScheduleDTO> temp2 = scheduleController.sortBySchelduledTime(temp1);
		ArrayList<ScheduleDTO> temp3 = scheduleController.sortTheaterId(temp2);
		System.out.println("-----------------------------------------------------------------");
		System.out.println("삭제할 상영일정을 선택해주세요.\n");
		for (int i = 0; i < temp3.size(); i++) {
			System.out.print("[" + (i + 1) + "] ");
			cal = temp3.get(i).getScheduledTime();
			System.out.println(mde1.format(cal.getTime()) + " " + hm.format(cal.getTime()) + " "
					+ theaterViewer.getTheaterName(temp3.get(i).getTheaterId()));
		}
		int userChoice = ScannerUtil.nextIntOnly(scanner, "", 1, temp3.size());

		System.out.println("-----------------------------------------------------------------");
		String yesNo = ScannerUtil.nextLine(scanner, "정말로 삭제하시겠습니까?삭제하려면 [Y], 돌아가려면 [X]를 입력해주세요.\n");

		while (!(yesNo.equalsIgnoreCase("X")) && !(yesNo.equalsIgnoreCase("Y"))) {
			System.out.println("(잘못 입력하셨습니다.)");
			System.out.println("-----------------------------------------------------------------");
			yesNo = ScannerUtil.nextLine(scanner, "정말로 삭제하시겠습니까?삭제하려면 [Y], 돌아가려면 [X]를 입력해주세요.\n");
		}

		if (yesNo.equalsIgnoreCase("Y")) {
			scheduleController.delete(temp3.get(userChoice - 1).getScheduleId());
			ScannerUtil.notificationL("삭제가 완료되었습니다. 이전 화면으로 돌아갑니다.");
			ScannerUtil.ok(scanner, null);

		} else if (yesNo.equalsIgnoreCase("X")) {
			System.out.println("\n<<삭제가 취소되었습니다. 이전 화면으로 돌아갑니다.>>");
		}
	}

	public void showByTheater(int theaterId, String theaterName) {
		while (true) {
			System.out.println("-----------------------------------------------------------------");
			int userChoice = ScannerUtil.nextIntOnly(scanner,
					"[1] 10월 7일 목요일\n[2] 10월 8일 금요일\n[3] 10월 9일 토요일\n[4] 10월 10일 일요일\n[5] 10월 11일 월요일\n[0] 뒤로가기\n", 0,
					5);
			if (userChoice == 0) {
				ScannerUtil.notificationL(null);
				break;
			} else {
				int date = userChoice + 6;
				printAllByTheater(theaterId, date, theaterName);
			}
		}
	}

	private void printAllByTheater(int theaterId, int date, String theaterName) {
		while (true) {
			ArrayList<ScheduleDTO> temp = scheduleController.selectByTheaterId(theaterId);
			if (scheduleController.getByDate(temp, date).isEmpty()) {
				ScannerUtil.notificationL("해당 날짜에는 상영일정이 없습니다.");

				if (logIn == null || logIn.getLevel() != 1) {
					ScannerUtil.ok(scanner, null);
					System.out.println();
					break;

				} else {
					String userChoice2 = ScannerUtil.nextLine(scanner, "[N] 관리자 메뉴: 새 상영일정 등록\n[0] 뒤로가기\n");

					while (!userChoice2.equals("0") && !userChoice2.equalsIgnoreCase("N")) {
						System.out.println("(잘못 입력하셨습니다.)");
						System.out.println("-----------------------------------------------------------------");
						userChoice2 = ScannerUtil.nextLine(scanner, "[N] 관리자 메뉴: 새 상영일정 등록\n[0] 뒤로가기\n");
					}
					if (userChoice2.equals("0")) {
						ScannerUtil.notificationL(null);
						break;
					} else if (userChoice2.equalsIgnoreCase("N")) {
						insertNew();
					}
				}
			} else {
				System.out.println();
				printOneByTheater(theaterId, date, theaterName);

				if (logIn == null || logIn.getLevel() != 1) {
					ScannerUtil.nextIntOnly(scanner, "[0] 뒤로가기\n", 0, 0);
					ScannerUtil.notificationL(null);
					break;
				} else {
					String userChoice2 = ScannerUtil.nextLine(scanner,
							"[N] 관리자 메뉴: 새 상영일정 등록\n[E] 관리자 메뉴: 상영일정 수정\n[D] 관리자 메뉴: 상영일정 삭제\n[0] 뒤로가기\n");

					while (!userChoice2.equals("0") && !userChoice2.equalsIgnoreCase("N")
							&& !userChoice2.equalsIgnoreCase("E") && !userChoice2.equalsIgnoreCase("D")) {
						System.out.println("(잘못 입력하셨습니다.)");
						System.out.println("-----------------------------------------------------------------");
						userChoice2 = ScannerUtil.nextLine(scanner,
								"[N] 관리자 메뉴: 새 상영일정 등록\n[E] 관리자 메뉴: 상영일정 수정\n[D] 관리자 메뉴: 상영일정 삭제\n[0] 뒤로가기\n");
					}
					if (userChoice2.equals("0")) {
						ScannerUtil.notificationL(null);
						break;
					} else if (userChoice2.equalsIgnoreCase("N")) {
						insertNew();
					} else if (userChoice2.equalsIgnoreCase("E")) {
						updateByTheater(theaterId, date);
					} else if (userChoice2.equalsIgnoreCase("D")) {
						deleteByTheater(theaterId, date);
						if (scheduleController.getByDate(temp, date).isEmpty()) {
							ScannerUtil.notificationL("해당 날짜에는 상영일정이 없습니다.");
							String userChoice3 = ScannerUtil.nextLine(scanner, "[N] 관리자 메뉴: 새 상영일정 등록\n[0] 뒤로가기\n");

							while (!userChoice2.equals("0") && !userChoice2.equalsIgnoreCase("N")) {
								System.out.println("(잘못 입력하셨습니다.)");
								System.out.println("-----------------------------------------------------------------");
								userChoice2 = ScannerUtil.nextLine(scanner, "[N] 관리자 메뉴: 새 상영일정 등록\n[0] 뒤로가기\n");
							}

							if (userChoice3.equals("0")) {
								ScannerUtil.notificationL(null);
								break;
							} else if (userChoice3.equalsIgnoreCase("N")) {
								insertNew();
							}
						}
					}
				}
			}
		}
	}

	private void printOneByTheater(int theaterId, int date, String theaterName) {
		ArrayList<ScheduleDTO> temp1 = scheduleController.selectByTheaterId(theaterId);
		ArrayList<ScheduleDTO> temp2 = scheduleController.getByDate(temp1, date);
		ArrayList<ScheduleDTO> temp3 = scheduleController.sortBySchelduledTime(temp2);
		ArrayList<ScheduleDTO> temp4 = scheduleController.sortByMovieId(temp3);

		cal = temp4.get(0).getScheduledTime();

		System.out.println("=================================================================");
		System.out.println(mde2.format(cal.getTime()) + " <" + theaterName + "> 상영시간표");
		System.out.println("=================================================================");

		for (int i = 0; i < temp4.size(); i++) {
			cal = temp4.get(i).getScheduledTime();
			if (i == 0 || temp4.get(i).getMovieId() != temp4.get(i - 1).getMovieId()) {
				System.out.println(" " + moviesViewer.getMovieName(temp4.get(i).getMovieId()));
				System.out.println();
			}
			System.out.print(" " + hm.format(cal.getTime()) + "  ");
			if (i < temp4.size() - 1 && temp4.get(i).getMovieId() != temp4.get(i + 1).getMovieId()) {
				System.out.println("\n-----------------------------------------------------------------");
			}
		}
		System.out.println("\n=================================================================\n");
	}

	private void updateByTheater(int theaterId, int date) {
		ArrayList<ScheduleDTO> temp1 = scheduleController.selectByTheaterId(theaterId);
		ArrayList<ScheduleDTO> temp2 = scheduleController.getByDate(temp1, date);
		ArrayList<ScheduleDTO> temp3 = scheduleController.sortBySchelduledTime(temp2);
		ArrayList<ScheduleDTO> temp4 = scheduleController.sortByMovieId(temp3);
		System.out.println("-----------------------------------------------------------------");
		System.out.println("수정할 상영일정을 선택해주세요.\n");
		for (int i = 0; i < temp4.size(); i++) {
			System.out.print("[" + (i + 1) + "] ");
			cal = temp4.get(i).getScheduledTime();
			System.out.println(mde1.format(cal.getTime()) + " " + hm.format(cal.getTime()) + " "
					+ moviesViewer.getMovieName(temp4.get(i).getMovieId()));
		}
		int userChoice = ScannerUtil.nextIntOnly(scanner, "", 1, temp4.size());

		ScheduleDTO s = scheduleController.selectOne(temp4.get(userChoice - 1).getScheduleId());
		System.out.println("-----------------------------------------------------------------");
		int mon = ScannerUtil.nextIntOnly(scanner, "변경할 상영일정의 날짜를 입력해주세요.\n\n월(1~12):\n", 1, 12);
		System.out.println("-----------------------------------------------------------------");
		int d = ScannerUtil.nextIntOnly(scanner, "일(1~31):\n", 1, 31);
		System.out.println("-----------------------------------------------------------------");
		int h = ScannerUtil.nextIntOnly(scanner, "시(00~23):\n", 00, 23);
		System.out.println("-----------------------------------------------------------------");
		int min = ScannerUtil.nextIntOnly(scanner, "분(00~59):\n", 00, 59);

		Calendar cal = Calendar.getInstance();
		cal.set(2021, mon - 1, d, h, min);
		s.setScheduledTime(cal);

		System.out.println("-----------------------------------------------------------------");
		String yesNo = ScannerUtil.nextLine(scanner, "정말로 수정하시겠습니까?\n수정하려면 [Y], 취소하려면 [X]를 입력해주세요.\n");
		while (!(yesNo.equalsIgnoreCase("X")) && !(yesNo.equalsIgnoreCase("Y"))) {
			System.out.println("(잘못 입력하셨습니다.)");
			System.out.println("-----------------------------------------------------------------");
			yesNo = ScannerUtil.nextLine(scanner, "정말로 수정하시겠습니까?\n수정하려면 [Y], 취소하려면 [X]를 입력해주세요.\n");
		}
		if (yesNo.equalsIgnoreCase("Y")) {
			scheduleController.update(s);
			ScannerUtil.notificationL("변경이 완료되었습니다. 이전 화면으로 돌아갑니다.");
			ScannerUtil.ok(scanner, null);

		} else if (yesNo.equalsIgnoreCase("X")) {
			System.out.println("\n<<변경이 취소되었습니다. 이전 화면으로 돌아갑니다.>>");
		}
	}

	private void deleteByTheater(int theaterId, int date) {
		ArrayList<ScheduleDTO> temp1 = scheduleController.selectByTheaterId(theaterId);
		ArrayList<ScheduleDTO> temp2 = scheduleController.getByDate(temp1, date);
		ArrayList<ScheduleDTO> temp3 = scheduleController.sortBySchelduledTime(temp2);
		ArrayList<ScheduleDTO> temp4 = scheduleController.sortByMovieId(temp3);
		System.out.println("-----------------------------------------------------------------");
		System.out.println("삭제할 상영일정을 선택해주세요.\n");
		for (int i = 0; i < temp4.size(); i++) {
			System.out.print("[" + (i + 1) + "] ");
			cal = temp4.get(i).getScheduledTime();
			System.out.println(mde1.format(cal.getTime()) + " " + hm.format(cal.getTime()) + " "
					+ moviesViewer.getMovieName(temp4.get(i).getMovieId()));
		}
		int userChoice = ScannerUtil.nextIntOnly(scanner, "", 1, temp4.size());

		System.out.println("-----------------------------------------------------------------");
		String yesNo = ScannerUtil.nextLine(scanner, "정말로 삭제하시겠습니까?삭제하려면 [Y], 돌아가려면 [X]를 입력해주세요.\n");

		while (!(yesNo.equalsIgnoreCase("X")) && !(yesNo.equalsIgnoreCase("Y"))) {
			System.out.println("(잘못 입력하셨습니다.)");
			System.out.println("-----------------------------------------------------------------");
			yesNo = ScannerUtil.nextLine(scanner, "정말로 삭제하시겠습니까?삭제하려면 [Y], 돌아가려면 [X]를 입력해주세요.\n");
		}

		if (yesNo.equalsIgnoreCase("Y")) {
			scheduleController.delete(temp4.get(userChoice - 1).getScheduleId());
			ScannerUtil.notificationL("삭제가 완료되었습니다. 이전 화면으로 돌아갑니다.");
			ScannerUtil.ok(scanner, null);

		} else if (yesNo.equalsIgnoreCase("X")) {
			System.out.println("\n<<삭제가 취소되었습니다. 이전 화면으로 돌아갑니다.>>");
		}
	}

	public void deleteByMovieId(int movieId) {
		scheduleController.deleteByMovieId(movieId);
	}

	public void deleteByTheaterId(int theaterId) {
		scheduleController.deleteByTheaterId(theaterId);
	}

	public void insertNew() {
		ScheduleDTO s = new ScheduleDTO();

		int movieId = moviesViewer.getMovieList();
		s.setMovieId(movieId);
		int theaterId = theaterViewer.getTheaterList();
		s.setTheaterId(theaterId);
		System.out.println("-----------------------------------------------------------------");
		int mon = ScannerUtil.nextIntOnly(scanner, "새 상영일정을 등록할 날짜를 입력해주세요.\n\n월(1~12):\n", 1, 12);
		System.out.println("-----------------------------------------------------------------");
		int d = ScannerUtil.nextIntOnly(scanner, "일(1~31):\n", 1, 31);
		System.out.println("-----------------------------------------------------------------");
		int h = ScannerUtil.nextIntOnly(scanner, "시(00~23):\n", 00, 23);
		System.out.println("-----------------------------------------------------------------");
		int min = ScannerUtil.nextIntOnly(scanner, "분(00~59):\n", 00, 59);

		Calendar cal = Calendar.getInstance();
		cal.set(2021, mon - 1, d, h, min);
		s.setScheduledTime(cal);

		scheduleController.insert(s);
		ScannerUtil.notificationL("등록이 완료되었습니다.");
		ScannerUtil.ok(scanner, null);
	}
}
