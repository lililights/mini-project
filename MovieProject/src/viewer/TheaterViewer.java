package viewer;

import java.util.Scanner;

import controller.TheaterController;
import model.TheaterDTO;
import model.UserDTO;

import myUtil.ScannerUtil;
import myUtil.ArrayUtil;

public class TheaterViewer {
	private Scanner scanner;
	private TheaterController theaterController;
	private UserDTO logIn;
	private ScheduleViewer scheduleViewer;

	public void setLogIn(UserDTO logIn) {
		this.logIn = logIn;
	}

	public TheaterViewer(Scanner scanner, ScheduleViewer scheduleViewer) {
		theaterController = new TheaterController();
		this.scanner = scanner;
		this.scheduleViewer = scheduleViewer;
	}

	public void printAll() {
		while (true) {
			if (theaterController.selectAll().isEmpty()) {
				ScannerUtil.notificationL("등록된 영화관이 없습니다.");

				if (logIn != null && logIn.getLevel() == 1) {
					String userChoice = ScannerUtil.nextLine(scanner, "[N] 관리자 메뉴: 새 영화관 등록\n[0] 뒤로가기\n");

					if (userChoice.equalsIgnoreCase("N")) {
						insertNew();

					} else if (userChoice.equals("0")) {
						System.out.println("\n<<이전 화면으로 돌아갑니다.>>");
						break;

					} else {
						System.out.println("(잘못 입력하셨습니다.)");
					}

				} else {
					ScannerUtil.ok(scanner, null);
					break;
				}
			} else {
				System.out.println("-----------------------------------------------------------------");
				int index = 1;
				int[] indexArr = new int[1];

				for (int i = 1; i <= theaterController.selectAll().size(); i++) {
					System.out.print("[" + i + "] ");

					while (theaterController.selectOne(index) == null) {
						index++;
					}
					if (theaterController.selectOne(index) != null) {
						TheaterDTO t = theaterController.selectOne(index);
						System.out.println(t.getBranch());
						indexArr = ArrayUtil.add(indexArr, index);
						index++;
					}
				}
				if (logIn != null && logIn.getLevel() == 1) {
					String userChoice = ScannerUtil.nextLine(scanner, "[N] 관리자 메뉴: 새 영화관 등록\n[0] 뒤로가기\n");

					if (userChoice.equalsIgnoreCase("N")) {
						insertNew();

					} else if (!(userChoice.equalsIgnoreCase("N"))) {
						String pattern = "^[0-9]+$";

						if (!userChoice.matches(pattern)) {
							System.out.println("(잘못 입력하셨습니다.)");

						} else {
							int userChoiceInt = Integer.parseInt(userChoice);

							if (userChoiceInt == 0) {
								System.out.println("\n<<이전 화면으로 돌아갑니다.>>");
								break;

							} else if (userChoiceInt < 0 || userChoiceInt >= ArrayUtil.size(indexArr)) {
								System.out.println("(잘못 입력하셨습니다.)");

							} else if (theaterController.selectOne(ArrayUtil.get(indexArr, userChoiceInt)) == null) {
								System.out.println("(잘못 입력하셨습니다.)");

							} else if (theaterController.selectOne(ArrayUtil.get(indexArr, userChoiceInt)) != null) {
								int theaterId = ArrayUtil.get(indexArr, userChoiceInt);
								selectOne(theaterId);
							}
						}
					}
				} else {
					int userChoice = ScannerUtil.nextIntOnlyPass(scanner, "[0] 뒤로가기\n");

					if (userChoice == 0) {
						System.out.println("\n<<이전 화면으로 돌아갑니다.>>");
						break;

					} else if (userChoice < 0 || userChoice >= ArrayUtil.size(indexArr)) {
						System.out.println("(잘못 입력하셨습니다.)");

					} else if (theaterController.selectOne(ArrayUtil.get(indexArr, userChoice)) == null) {
						System.out.println("(잘못 입력하셨습니다.)");

					} else if (theaterController.selectOne(ArrayUtil.get(indexArr, userChoice)) != null) {
						int theaterId = ArrayUtil.get(indexArr, userChoice);
						selectOne(theaterId);
					}
				}
			}
		}
	}

	public void selectOne(int theaterId) {
		while (true) {
			TheaterDTO t = theaterController.selectOne(theaterId);
			System.out.println("-----------------------------------------------------------------");
			int userChoice = ScannerUtil.nextIntOnly(scanner,
					"[1] <" + t.getBranch() + "> 상영스케줄 보기\n[2] <" + t.getBranch() + "> 정보 보기\n[0] 뒤로가기\n", 0, 2);

			if (userChoice == 0) {
				ScannerUtil.notificationL(null);
				break;
			} else if (userChoice == 1) {
				scheduleViewer.showByTheater(theaterId, getTheaterName(theaterId));
			} else if (userChoice == 2) {
				System.out.println();
				printOne(theaterId);
				if (theaterController.selectOne(theaterId) == null) {
					break;
				}
			}
		}
	}

	private void printOne(int theaterId) {
		while (true) {
			TheaterDTO t = theaterController.selectOne(theaterId);
			System.out.println("=================================================================");
			System.out.println("<" + t.getBranch() + "> 영화관 정보");
			System.out.println("-----------------------------------------------------------------");
			System.out.println("전화번호: " + t.getContactNum());
			System.out.println("위치: " + t.getLocation());
			System.out.println("=================================================================\n");

			if (logIn != null && logIn.getLevel() == 1) {
				String userChoice = ScannerUtil.nextLine(scanner,
						"[E] 관리자 메뉴: 영화관 정보 수정\n[D] 관리자 메뉴: 영화관 삭제\n[0] 뒤로가기\n");

				while (!userChoice.equals("0") && !userChoice.equalsIgnoreCase("E")
						&& !userChoice.equalsIgnoreCase("D")) {
					ScannerUtil.notificationS(null);
					userChoice = ScannerUtil.nextLine(scanner, "[E] 관리자 메뉴: 영화관 정보 수정\n[D] 관리자 메뉴: 영화관 삭제\n[0] 뒤로가기\n");
				}

				if (userChoice.equals("0")) {
					ScannerUtil.notificationL(null);
					break;

				} else if (userChoice.equalsIgnoreCase("E")) {
					update(theaterId);
				} else if (userChoice.equalsIgnoreCase("D")) {
					delete(theaterId);
					if (theaterController.selectOne(theaterId) == null) {
						break;
					}
				}

			} else {
				int userChoice = ScannerUtil.nextIntOnly(scanner, "[0] 뒤로가기\n", 0, 0);
				if (userChoice == 0) {
					ScannerUtil.notificationL(null);
					break;
				}
			}
		}
	}

	private void update(int theaterId) {
		TheaterDTO t = theaterController.selectOne(theaterId);
		System.out.println("-----------------------------------------------------------------");
		t.setBranch(ScannerUtil.nextLine(scanner, "변경할 영화관의 명칭을 입력해주세요.\n"));
		System.out.println("-----------------------------------------------------------------");
		t.setContactNum(ScannerUtil.nextLine(scanner, "변경할 영화관의 연락처를 입력해주세요.\n"));
		System.out.println("-----------------------------------------------------------------");
		t.setLocation(ScannerUtil.nextLine(scanner, "변경할 영화관의 위치를 입력해주세요.\n"));

		System.out.println("-----------------------------------------------------------------");
		String yesNo = ScannerUtil.nextLine(scanner, "정말로 수정하시겠습니까?\n수정하려면 [Y], 취소하려면 [X]를 입력해주세요.\n");
		while (!(yesNo.equalsIgnoreCase("X")) && !(yesNo.equalsIgnoreCase("Y"))) {
			System.out.println("(잘못 입력하셨습니다.)");
			System.out.println("-----------------------------------------------------------------");
			yesNo = ScannerUtil.nextLine(scanner, "정말로 수정하시겠습니까?\n수정하려면 [Y], 취소하려면 [X]를 입력해주세요.\n");
		}
		if (yesNo.equalsIgnoreCase("Y")) {
			theaterController.update(t);
			ScannerUtil.notificationL("변경이 완료되었습니다. 이전 화면으로 돌아갑니다.");
			ScannerUtil.ok(scanner, null);
			printOne(theaterId);
		} else if (yesNo.equalsIgnoreCase("X")) {
			ScannerUtil.notificationL("변경이 취소되었습니다. 이전 화면으로 돌아갑니다.");
			System.out.println();
		}
	}

	private void delete(int theaterId) {
		System.out.println("-----------------------------------------------------------------");
		String yesNo = ScannerUtil.nextLine(scanner, "정말로 삭제하시겠습니까?삭제하려면 [Y], 돌아가려면 [X]를 입력해주세요.\n");

		while (!(yesNo.equalsIgnoreCase("X")) && !(yesNo.equalsIgnoreCase("Y"))) {
			System.out.println("(잘못 입력하셨습니다.)");
			System.out.println("-----------------------------------------------------------------");
			yesNo = ScannerUtil.nextLine(scanner, "정말로 삭제하시겠습니까?삭제하려면 [Y], 돌아가려면 [X]를 입력해주세요.\n");
		}

		if (yesNo.equalsIgnoreCase("Y")) {
			scheduleViewer.deleteByTheaterId(theaterId);
			theaterController.delete(theaterId);
			ScannerUtil.notificationL("삭제가 완료되었습니다. 이전 화면으로 돌아갑니다.");
			ScannerUtil.ok(scanner, null);
		} else if (yesNo.equalsIgnoreCase("X")) {
			ScannerUtil.notificationL("삭제가 취소되었습니다. 이전 화면으로 돌아갑니다.)");
		}
	}

	public void insertNew() {
		TheaterDTO t = new TheaterDTO();
		System.out.println("-----------------------------------------------------------------");
		t.setBranch(ScannerUtil.nextLine(scanner, "등록할 영화관의 명칭을 입력해주세요.\n"));
		System.out.println("-----------------------------------------------------------------");
		t.setContactNum(ScannerUtil.nextLine(scanner, "등록할 영화관의 연락처를 입력해주세요.\n"));
		System.out.println("-----------------------------------------------------------------");
		t.setLocation(ScannerUtil.nextLine(scanner, "등록할 영화관의 위치를 입력해주세요.\n"));

		theaterController.insert(t);
		ScannerUtil.notificationL("등록이 완료되었습니다.");
		ScannerUtil.ok(scanner, null);
	}

	public String getTheaterName(int theaterId) {
		return (theaterController.selectOne(theaterId).getBranch());
	}

	public int getTheaterList() {
		if (theaterController.selectAll().isEmpty()) {
			ScannerUtil.notificationL("등록된 영화관이 없습니다. 이전 화면으로 돌아갑니다.");
			ScannerUtil.ok(scanner, null);
		} else {
			System.out.println("-----------------------------------------------------------------");
			System.out.println("새 상영일정을 등록할 영화관을 선택해주세요.\n");
			int index = 1;
			int[] indexArr = new int[1];

			for (int i = 1; i <= theaterController.selectAll().size(); i++) {
				System.out.print("[" + i + "] ");

				while (theaterController.selectOne(index) == null) {
					index++;
				}
				if (theaterController.selectOne(index) != null) {
					TheaterDTO t = theaterController.selectOne(index);
					System.out.println(t.getBranch());
					indexArr = ArrayUtil.add(indexArr, index);
					index++;
				}
			}
			int userChoice = ScannerUtil.nextIntOnlyPass(scanner, "");

			if (userChoice < 1 || userChoice >= ArrayUtil.size(indexArr)) {
				System.out.println("(잘못 입력하셨습니다.)");
				getTheaterList();

			} else {
				int theaterId = ArrayUtil.get(indexArr, userChoice);
				return theaterId;
			}
		}
		return 0;
	}
}