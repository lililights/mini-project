package viewer;

import java.util.Scanner;

import controller.UserController;
import model.UserDTO;

import myUtil.ScannerUtil;

public class UserViewer {
	private Scanner scanner;
	private UserController userController;
	private UserDTO logIn;
	private MoviesViewer moviesViewer;
	private ReviewViewer reviewViewer;
	private TheaterViewer theaterViewer;
	private ScheduleViewer scheduleViewer;

	public UserViewer() {
		scanner = new Scanner(System.in);
		userController = new UserController();
		logIn = null;

		reviewViewer = new ReviewViewer(scanner, this);
		moviesViewer = new MoviesViewer(scanner, reviewViewer);
		scheduleViewer = new ScheduleViewer(scanner, moviesViewer);
		theaterViewer = new TheaterViewer(scanner, scheduleViewer);
		moviesViewer.setScheduleViewer(scheduleViewer);
		scheduleViewer.setTheaterViewer(theaterViewer);
	}

	public void showMain() {
		while (true) {
			if (logIn != null) {
				showUserMain();
			} else {
				System.out.println("=================================================================");
				System.out.println("			GARAN MOVIE WORLD");
				System.out.println("=================================================================");

				int userChoice = ScannerUtil.nextIntOnly(scanner, "[1] 현재상영작\n[2] 영화관 찾기\n[3] 로그인/회원가입\n[0] 종료\n", 0,
						3);

				if (userChoice == 1) {
					moviesViewer.categoryMenu();
				} else if (userChoice == 2) {
					theaterViewer.printAll();
					System.out.println();
				} else if (userChoice == 3) {
					logIn();
					if (logIn != null) {
						moviesViewer.setLogIn(logIn);
						theaterViewer.setLogIn(logIn);
						reviewViewer.setLogIn(logIn);
						scheduleViewer.setLogIn(logIn);
					}
				} else if (userChoice == 0) {
					System.out.println("-----------------------------------------------------------------");
					System.out.println("<이용해주셔서 감사합니다.>");
					System.out.println("=================================================================");
					scanner.close();
					break;
				}
			}
		}
	}

	private void showUserMain() {
		while (logIn != null) {
			if (logIn.getLevel() == 1) {
				System.out.println("=================================================================");
				System.out.println("			GARAN MOVIE WORLD");
				System.out.println("=================================================================");

				int userChoice = ScannerUtil.nextIntOnly(scanner, "[1] 현재상영작\n[2] 영화관 찾기\n[3] 관리자 퀵메뉴\n[0] 로그아웃\n", 0,
						3);

				if (userChoice == 1) {
					moviesViewer.categoryMenu();
				} else if (userChoice == 2) {
					theaterViewer.printAll();
					System.out.println();
				} else if (userChoice == 3) {
					adminShortCut();
				} else if (userChoice == 0) {
					logIn = null;
					moviesViewer.setLogIn(null);
					theaterViewer.setLogIn(null);
					reviewViewer.setLogIn(null);
					scheduleViewer.setLogIn(null);
					ScannerUtil.notificationL("로그아웃 하셨습니다.");
					break;
				}

			} else {
				System.out.println("=================================================================");
				System.out.println("			GARAN MOVIE WORLD");
				System.out.println("=================================================================");

				int userChoice = ScannerUtil.nextIntOnly(scanner, "[1] 현재상영작\n[2] 영화관 찾기\n[3] 회원정보\n[0] 로그아웃\n", 0, 3);

				if (userChoice == 1) {
					moviesViewer.categoryMenu();
				} else if (userChoice == 2) {
					theaterViewer.printAll();
					System.out.println();
				} else if (userChoice == 3) {
					System.out.println();
					userPage();
				} else if (userChoice == 0) {
					logIn = null;
					moviesViewer.setLogIn(null);
					theaterViewer.setLogIn(null);
					reviewViewer.setLogIn(null);
					scheduleViewer.setLogIn(null);
					ScannerUtil.notificationL("로그아웃 하셨습니다.");
					break;
				}
			}
		}
	}

	private void logIn() {
		System.out.println("-----------------------------------------------------------------");
		System.out.println("회원이신가요?");

		while (logIn == null) {
			System.out.println("로그인을 하려면 ID를, 회원가입을 하려면 [Y], 돌아가려면 [X]를 입력해주세요.\n");
			System.out.print("ID: ");
			String username = scanner.nextLine();

			if (username.equalsIgnoreCase("Y")) {
				register();
				break;
			} else if (username.equalsIgnoreCase("X")) {
				ScannerUtil.notificationL(null);
				break;
			}

			if (!username.equalsIgnoreCase("Y") && !username.equalsIgnoreCase("X")) {
				System.out.print("password: ");
				String password = scanner.nextLine();

				if (userController.auth(username, password) == null) {
					ScannerUtil.notificationS("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
				}

				logIn = userController.auth(username, password);

				if (!(logIn == null)) {
					if (logIn.getLevel() == 1) {
						ScannerUtil.notificationL("관리자 권한으로 로그인 하셨습니다.");
					} else if (logIn.getLevel() == 2 || logIn.getLevel() == 3) {
						ScannerUtil.notificationL(logIn.getNickname() + "님 환영합니다. 로그인 하셨습니다.");
					}
				}
			}
		}
	}

	private void register() {
		System.out.println("-----------------------------------------------------------------");
		String username = ScannerUtil.nextLine(scanner, "STEP1. 사용하실 아이디를 입력해주세요.\n");

		while (userController.validateUsername(username) || username.equalsIgnoreCase("Y")) {
			ScannerUtil.notificationS("해당 아이디는 사용하실 수 없습니다.");
			username = ScannerUtil.nextLine(scanner, "STEP1. 사용하실 아이디를 입력하시거나 회원가입을 취소하려면 [X]를 입력해주세요.\n");

			if (username.equalsIgnoreCase("X")) {
				ScannerUtil.notificationL(null);
				break;
			}
		}

		if (!username.equalsIgnoreCase("X")) {
			System.out.println("-----------------------------------------------------------------");
			String password = ScannerUtil.nextLine(scanner, "STEP2. 사용하실 비밀번호를 입력해주세요.\n");
			System.out.println("-----------------------------------------------------------------");
			String nickname = ScannerUtil.nextLine(scanner, "STEP3. 사용하실 닉네임을 입력해주세요.\n");

			UserDTO u = new UserDTO();

			u.setLevel(3);
			u.setUsername(username);
			u.setPassword(password);
			u.setNickname(nickname);

			userController.insert(u);
			ScannerUtil.notificationL(nickname + "님 회원이 되신걸 환영합니다. 로그인 해주세요.");
			ScannerUtil.ok(scanner, null);
			System.out.println();
		}
	}

	private void userPage() {
		while (true) {
			printOne(logIn.getUserId());
			int userChoice = ScannerUtil.nextIntOnly(scanner, "[1] 회원정보 수정\n[2] 회원 탈퇴\n[0] 뒤로가기\n", 0, 2);

			if (userChoice == 1) {
				update(logIn.getUserId());
			} else if (userChoice == 2) {
				delete(logIn.getUserId());
				if (userController.selectOne(userChoice) == null) {
					break;
				}
			} else if (userChoice == 0) {
				ScannerUtil.notificationL(null);
				break;
			}

			if (logIn == null) {
				break;
			}
		}
	}

	private void printOne(int userid) {
		UserDTO u = userController.selectOne(userid);
		System.out.println("=================================================================");
		System.out.println(u.getNickname() + "님의 회원정보");
		System.out.println("-----------------------------------------------------------------");
		System.out.printf("회원번호: %03d\n", u.getUserId());
		System.out.println("아이디: " + u.getUsername());
		System.out.println("닉네임: " + u.getNickname());
		System.out.println("=================================================================\n");
	}

	private void update(int userId) {
		System.out.println("-----------------------------------------------------------------");
		String password = ScannerUtil.nextLine(scanner, "STEP1. 새로운 비밀번호를 입력해주세요.\n");
		System.out.println("-----------------------------------------------------------------");
		String nickname = ScannerUtil.nextLine(scanner, "STEP2. 새로운 닉네임을 입력해주세요.\n");
		System.out.println("-----------------------------------------------------------------");
		String yesNo = ScannerUtil.nextLine(scanner, "정말로 수정하시겠습니까?\n수정하려면 [Y], 취소하려면 [X]를 입력해주세요.\n");

		while (!(yesNo.equalsIgnoreCase("X")) && !(yesNo.equalsIgnoreCase("Y"))) {
			System.out.println("(잘못 입력하셨습니다.)");
			System.out.println("-----------------------------------------------------------------");
			yesNo = ScannerUtil.nextLine(scanner, "정말로 수정하시겠습니까?\n수정하려면 [Y], 취소하려면 [X]를 입력해주세요.\n");
		}

		if (yesNo.equalsIgnoreCase("Y")) {
			System.out.println("-----------------------------------------------------------------");
			System.out.println("기존 비밀번호를 입력해주세요.\n");
			System.out.print("password: ");
			String oldPassword = scanner.nextLine();

			while (userController.auth(logIn.getUsername(), oldPassword) == null) {
				ScannerUtil.notificationS("비밀번호를 잘못 입력하셨습니다.");
				System.out.println("비밀번호를 다시 입력해주시거나 변경을 취소하려면 [X]를 입력해주세요.\n");
				System.out.print("password: ");
				oldPassword = scanner.nextLine();

				if (oldPassword.equalsIgnoreCase("X")) {
					ScannerUtil.notificationL("변경이 취소되었습니다. 이전 화면으로 돌아갑니다.");
					break;
				}
			}
			if (userController.auth(logIn.getUsername(), oldPassword) != null) {
				UserDTO u = new UserDTO();
				u.setUserId(logIn.getUserId());
				u.setLevel(logIn.getLevel());
				u.setUsername(logIn.getUsername());
				u.setPassword(password);
				u.setNickname(nickname);

				userController.update(u);
				ScannerUtil.notificationL("변경이 완료되었습니다. 이전 화면으로 돌아갑니다.");
				ScannerUtil.ok(scanner, null);
				System.out.println();
			}

		} else if (yesNo.equalsIgnoreCase("X")) {
			ScannerUtil.notificationL("변경이 취소되었습니다. 이전 화면으로 돌아갑니다.");
		}
	}

	private void delete(int userId) {
		System.out.println("-----------------------------------------------------------------");
		String yesNo = ScannerUtil.nextLine(scanner, "정말로 탈퇴하시겠습니까?\n탈퇴하려면 [Y], 취소하려면 [X]를 입력해주세요.\n");

		while (!(yesNo.equalsIgnoreCase("X")) && !(yesNo.equalsIgnoreCase("Y"))) {
			System.out.println("(잘못 입력하셨습니다.)");
			System.out.println("-----------------------------------------------------------------");
			yesNo = ScannerUtil.nextLine(scanner, "정말로 탈퇴하시겠습니까?\n탈퇴하려면 [Y], 취소하려면 [X]를 입력해주세요.\n");
		}

		if (yesNo.equalsIgnoreCase("Y")) {
			System.out.println("-----------------------------------------------------------------");
			System.out.println("비밀번호를 입력해주세요.\n");
			System.out.print("password: ");
			String password = scanner.nextLine();

			while (userController.auth(logIn.getUsername(), password) == null) {
				ScannerUtil.notificationS("비밀번호를 잘못 입력하셨습니다.");
				System.out.println("비밀번호를 다시 입력해주시거나 탈퇴를 취소하려면 [X]를 입력해주세요.\n");
				System.out.print("password: ");
				password = scanner.nextLine();

				if (password.equalsIgnoreCase("X")) {
					ScannerUtil.notificationL("탈퇴가 취소되었습니다. 이전 화면으로 돌아갑니다.");
					break;
				}
			}

			if (userController.auth(logIn.getUsername(), password) != null) {
				reviewViewer.deleteByUserId(userId);
				userController.delete(userId);
				logIn = null;
				moviesViewer.setLogIn(null);
				theaterViewer.setLogIn(null);
				reviewViewer.setLogIn(null);
				scheduleViewer.setLogIn(null);
				ScannerUtil.notificationL("탈퇴가 완료되었습니다. 초기메뉴로 돌아갑니다.");
			}
		} else if (yesNo.equalsIgnoreCase("X")) {
			ScannerUtil.notificationL("탈퇴가 취소되었습니다. 이전 화면으로 돌아갑니다.");
		}
	}

	private void adminShortCut() {
		while (true) {
			System.out.println("-----------------------------------------------------------------");
			int userChoice = ScannerUtil.nextIntOnly(scanner, "[1] 새 영화 등록\n[2] 새 극장 등록\n[3] 새 상영일정 등록\n[0] 뒤로가기\n", 0,
					3);
			if (userChoice == 1) {
				moviesViewer.insertNew();
			} else if (userChoice == 2) {
				theaterViewer.insertNew();
			} else if (userChoice == 3) {
				scheduleViewer.insertNew();
			} else if (userChoice == 0) {
				ScannerUtil.notificationL(null);
				break;
			}
		}
	}

	public String printNickName(int id) {
		return (userController.selectOne(id).getNickname());
	}
}
