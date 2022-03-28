package viewer;

import java.util.Scanner;
import java.util.ArrayList;

import controller.MoviesController;
import model.MoviesDTO;
import model.UserDTO;

import myUtil.ScannerUtil;
import myUtil.ArrayUtil;

public class MoviesViewer {
	private Scanner scanner;
	private MoviesController moviesController;
	private UserDTO logIn;
	private ReviewViewer reviewViewer;
	private ScheduleViewer scheduleViewer;

	public void setLogIn(UserDTO logIn) {
		this.logIn = logIn;
	}

	public void setScheduleViewer(ScheduleViewer scheduleViewer) {
		this.scheduleViewer = scheduleViewer;
	}

	public MoviesViewer(Scanner scanner, ReviewViewer reviewViewer) {
		moviesController = new MoviesController();
		this.scanner = scanner;
		this.reviewViewer = reviewViewer;
	}

	public void categoryMenu() {
		while (true) {
			System.out.println("-----------------------------------------------------------------");
			int userChoice = ScannerUtil.nextIntOnly(scanner,
					"[1] 전체 영화 보기\n[2] 평점 순으로 보기\n[3] 장르별로 보기\n[4] 시청등급별로 보기\n[0] 뒤로가기\n", 0, 4);
			if (userChoice == 0) {
				ScannerUtil.notificationL(null);
				break;
			} else if (userChoice == 1) {
				printAll();
			} else if (userChoice == 2) {
				printByRating();
			} else if (userChoice == 3) {
				showByGenre();
			} else if (userChoice == 4) {
				showByAgeLimit();
			}
		}
	}

	private void printAll() {
		while (true) {
			if (moviesController.selectAll().isEmpty()) {
				ScannerUtil.notificationL("등록된 영화 목록이 없습니다.");

				if (logIn != null && logIn.getLevel() == 1) {
					String userChoice = ScannerUtil.nextLine(scanner, "[N] 관리자 메뉴: 새 영화 등록\n[0] 뒤로가기\n");

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

				for (int i = 1; i <= moviesController.selectAll().size(); i++) {
					System.out.print("[" + i + "] ");

					while (moviesController.selectOne(index) == null) {
						index++;
					}
					if (moviesController.selectOne(index) != null) {
						MoviesDTO m = moviesController.selectOne(index);
						System.out.println(m.getTitleKor() + " "
								+ reviewViewer.getRatingStars(reviewViewer.getAverageRating(index)));
						indexArr = ArrayUtil.add(indexArr, index);
						index++;
					}
				}

				if ((logIn != null && logIn.getLevel() == 1)) {
					String userChoice = ScannerUtil.nextLine(scanner, "[N] 관리자 메뉴: 새 영화 등록\n[0] 뒤로가기\n");

					if (userChoice.equalsIgnoreCase("N")) {
						insertNew();

					} else if (!(userChoice.equalsIgnoreCase("N"))) {
						String pattern = "^[0-9]+$";

						if (!userChoice.matches(pattern)) {
							System.out.println("(잘못 입력하셨습니다.)");

						} else {
							int userChoiceInt = Integer.parseInt(userChoice);

							if (userChoiceInt == 0) {
								ScannerUtil.notificationL(null);
								break;

							} else if (userChoiceInt < 0 || userChoiceInt >= ArrayUtil.size(indexArr)) {
								System.out.println("(잘못 입력하셨습니다.)");

							} else if (moviesController.selectOne(ArrayUtil.get(indexArr, userChoiceInt)) == null) {
								System.out.println("(잘못 입력하셨습니다.)");

							} else if (moviesController.selectOne(ArrayUtil.get(indexArr, userChoiceInt)) != null) {
								System.out.println();
								printOneMenu(ArrayUtil.get(indexArr, userChoiceInt));
							}
						}
					}
				} else {
					int userChoice = ScannerUtil.nextIntOnlyPass(scanner, "[0] 뒤로가기\n");

					if (userChoice < 0 || userChoice >= ArrayUtil.size(indexArr)) {
						System.out.println("(잘못 입력하셨습니다.)");

					} else if (userChoice == 0) {
						ScannerUtil.notificationL(null);
						break;

					} else if (moviesController.selectOne(ArrayUtil.get(indexArr, userChoice)) == null) {
						System.out.println("(잘못 입력하셨습니다.)");

					} else if (moviesController.selectOne(ArrayUtil.get(indexArr, userChoice)) != null) {
						System.out.println();
						printOneMenu(ArrayUtil.get(indexArr, userChoice));
					}
				}
			}
		}
	}

	public void printOne(int movieId) {
		MoviesDTO m = moviesController.selectOne(movieId);
		System.out.println("=================================================================");
		System.out.println(m.getTitleKor() + " / " + m.getTitleEng());
		System.out.println("=================================================================");
		System.out.println(" ┌───────────┐");
		System.out.println(" │           │  " + m.getGenre());
		System.out.println(" │           │ --------------------------------------------------");
		System.out.println(" │   image   │  " + m.getAgeLimitText());
		System.out.println(" │           │ --------------------------------------------------");
		System.out.println(" │           │  " + reviewViewer.getAverageRating(movieId)
				+ reviewViewer.getRatingStars(reviewViewer.getAverageRating(movieId)));
		System.out.println(" │           │ --------------------------------------------------");
		System.out.println(" └───────────┘");
		System.out.println(m.getPlot());
		System.out.println("=================================================================\n");
	}

	private void printOneMenu(int movieId) {
		while (true) {
			printOne(movieId);
			System.out.println("[1] 회원 리뷰 보기\n[2] 전문가평 보기\n[3] 상영일정 보기");
			if (logIn != null && logIn.getLevel() == 1) {
				System.out.println("[E] 관리자 메뉴: 영화정보 수정\n[D] 관리자 메뉴: 영화정보 삭제");
			}
			String userChoice2 = ScannerUtil.nextLine(scanner, "[0] 뒤로가기\n");

			if (userChoice2.equals("0")) {
				ScannerUtil.notificationL(null);
				break;
			} else if (userChoice2.equals("1")) {
				reviewViewer.printReview(movieId);
			} else if (userChoice2.equals("2")) {
				reviewViewer.printProReview(movieId);
			} else if (userChoice2.equals("3")) {
				scheduleViewer.showByMovies(movieId, getMovieName(movieId));
			} else if (logIn != null && logIn.getLevel() == 1) {
				if (userChoice2.equalsIgnoreCase("E")) {
					update(movieId);
				} else if (userChoice2.equalsIgnoreCase("D")) {
					delete(movieId);
					if (moviesController.selectOne(movieId) == null) {
						break;
					}
				} else {
					System.out.println("(잘못 입력하셨습니다.)");
					System.out.println();
				}
			} else {
				System.out.println("(잘못 입력하셨습니다.)");
				System.out.println();
			}
		}
	}

	private void showByGenre() {
		while (true) {
			System.out.println("-----------------------------------------------------------------");
			int userChoice = ScannerUtil.nextIntOnly(scanner,
					"[1] 드라마	[2] 로맨스\n[3] 액션		[4] 스릴러\n[5] SF		[6] 판타지\n[7] 모험		[8] 미스터리\n[9] 공포		[10] 범죄\n[11] 전쟁		[12] 코미디\n[13] 뮤지컬	[14] 애니메이션\n[0] 뒤로가기\n",
					0, 14);
			if (userChoice == 0) {
				break;
			} else {
				String codeByGenre;
				if (userChoice == 1) {
					codeByGenre = "드라마";
					printByGenre(codeByGenre);
				} else if (userChoice == 2) {
					codeByGenre = "로맨스";
					printByGenre(codeByGenre);
				} else if (userChoice == 3) {
					codeByGenre = "액션";
					printByGenre(codeByGenre);
				} else if (userChoice == 4) {
					codeByGenre = "스릴러";
					printByGenre(codeByGenre);
				} else if (userChoice == 5) {
					codeByGenre = "SF";
					printByGenre(codeByGenre);
				} else if (userChoice == 6) {
					codeByGenre = "판타지";
					printByGenre(codeByGenre);
				} else if (userChoice == 7) {
					codeByGenre = "모험";
					printByGenre(codeByGenre);
				} else if (userChoice == 8) {
					codeByGenre = "미스터리";
					printByGenre(codeByGenre);
				} else if (userChoice == 9) {
					codeByGenre = "공포";
					printByGenre(codeByGenre);
				} else if (userChoice == 10) {
					codeByGenre = "범죄";
					printByGenre(codeByGenre);
				} else if (userChoice == 11) {
					codeByGenre = "전쟁";
					printByGenre(codeByGenre);
				} else if (userChoice == 12) {
					codeByGenre = "코미디";
					printByGenre(codeByGenre);
				} else if (userChoice == 13) {
					codeByGenre = "뮤지컬";
					printByGenre(codeByGenre);
				} else if (userChoice == 14) {
					codeByGenre = "애니메이션";
					printByGenre(codeByGenre);
				}
			}
		}
	}

	private void printByGenre(String codeByGenre) {
		while (true) {
			ArrayList<MoviesDTO> list = moviesController.selectAll();
			ArrayList<MoviesDTO> temp = new ArrayList<>();
			for (MoviesDTO m : list) {
				if (m.getGenre().contains(codeByGenre)) {
					temp.add(m);
				}
			}
			if (temp.isEmpty()) {
				ScannerUtil.notificationL("등록된 영화 목록이 없습니다.");
				ScannerUtil.ok(scanner, null);
				break;
			} else {
				System.out.println("-----------------------------------------------------------------");
				for (int i = 1; i <= temp.size(); i++) {
					System.out.println("[" + i + "] " + temp.get(i - 1).getTitleKor());
				}
				int userChoice2 = ScannerUtil.nextIntOnlyPass(scanner, "[0] 뒤로가기\n");
				if (userChoice2 == 0) {
					ScannerUtil.notificationL(null);
					break;
				} else if (userChoice2 < 1 || userChoice2 > temp.size()) {
					System.out.println("(잘못 입력하셨습니다.)");
				} else {
					System.out.println();
					printOneMenu(temp.get(userChoice2 - 1).getMovieId());
				}
			}
		}
	}

	private void showByAgeLimit() {
		while (true) {
			System.out.println("-----------------------------------------------------------------");
			int userChoice = ScannerUtil.nextIntOnly(scanner,
					"[1] 전체 관람가\n[2] 12세 관람가\n[3] 15세 관람가\n[4] 청소년 관람불가\n[0] 뒤로가기\n", 0, 4);
			if (userChoice == 0) {
				ScannerUtil.notificationL(null);
				break;
			} else {
				int codeByAgeLimit;
				if (userChoice == 1) {
					codeByAgeLimit = 0;
					printByAgeLimit(codeByAgeLimit);
				} else if (userChoice == 2) {
					codeByAgeLimit = 12;
					printByAgeLimit(codeByAgeLimit);
				} else if (userChoice == 3) {
					codeByAgeLimit = 15;
					printByAgeLimit(codeByAgeLimit);
				} else if (userChoice == 4) {
					codeByAgeLimit = 18;
					printByAgeLimit(codeByAgeLimit);
				}
			}
		}
	}

	private void printByAgeLimit(int codeByAgeLimit) {
		while (true) {
			ArrayList<MoviesDTO> list = moviesController.selectAll();
			ArrayList<MoviesDTO> temp = new ArrayList<>();
			for (MoviesDTO m : list) {
				if (m.getAgeLimit() == codeByAgeLimit) {
					temp.add(m);
				}
			}
			if (temp.isEmpty()) {
				ScannerUtil.notificationL("등록된 영화 목록이 없습니다.");
				ScannerUtil.ok(scanner, null);
				break;
			} else {
				System.out.println("-----------------------------------------------------------------");
				for (int i = 1; i <= temp.size(); i++) {
					System.out.println("[" + i + "] " + temp.get(i - 1).getTitleKor());
				}
				int userChoice2 = ScannerUtil.nextIntOnlyPass(scanner, "[0] 뒤로가기\n");
				if (userChoice2 == 0) {
					ScannerUtil.notificationL(null);
					break;
				} else if (userChoice2 < 1 || userChoice2 > temp.size()) {
					System.out.println("(잘못 입력하셨습니다.)");
				} else {
					System.out.println();
					printOneMenu(temp.get(userChoice2 - 1).getMovieId());
				}
			}
		}
	}

	private void printByRating() {
		while (true) {
			ArrayList<MoviesDTO> m = moviesController.selectAll();
			if (m.isEmpty()) {
				ScannerUtil.notificationL("등록된 영화 목록이 없습니다.");
				ScannerUtil.ok(scanner, null);
				break;
			} else {
				System.out.println("-----------------------------------------------------------------");
				for (int i = 0; i < m.size() - 1; i++) {
					if (reviewViewer.getAverageRating(m.get(i).getMovieId()) < reviewViewer
							.getAverageRating(m.get(i + 1).getMovieId())) {
						MoviesDTO temp = m.get(i);
						m.set(i, m.get(i + 1));
						m.set(i + 1, temp);
						i = -1;
					}
				}
				for (int i = 1; i <= m.size(); i++) {
					System.out.println("[" + i + "] " + m.get(i - 1).getTitleKor() + " "
							+ reviewViewer.getRatingStars(reviewViewer.getAverageRating(m.get(i - 1).getMovieId())));
				}
				int userChoice = ScannerUtil.nextIntOnlyPass(scanner, "[0] 뒤로가기\n");
				if (userChoice == 0) {
					ScannerUtil.notificationL(null);
					break;
				} else if (userChoice < 1 || userChoice > m.size()) {
					System.out.println("(잘못 입력하셨습니다.)");
				} else {
					System.out.println();
					printOneMenu(m.get(userChoice - 1).getMovieId());
				}
			}
		}
	}

	private void update(int movieId) {
		MoviesDTO m = moviesController.selectOne(movieId);
		System.out.println("-----------------------------------------------------------------");
		m.setGenre(ScannerUtil.nextLine(scanner, "변경할 영화의 장르를 입력해주세요. (예: 액션, SF, 드라마)\n"));
		System.out.println("-----------------------------------------------------------------");
		int userChoice = ScannerUtil.nextIntOnly(scanner,
				"변경할 영화의 시청등급을 입력해주세요.\n\n[1] 전체 관람가\n[2] 12세 관람가\n[3] 15세 관람가\n[4] 청소년 관람불가\n", 1, 4);
		if (userChoice == 1) {
			m.setAgeLimit(0);
		} else if (userChoice == 2) {
			m.setAgeLimit(12);
		} else if (userChoice == 3) {
			m.setAgeLimit(15);
		} else if (userChoice == 4) {
			m.setAgeLimit(18);
		}
		System.out.println("-----------------------------------------------------------------");
		m.setPlot(ScannerUtil.nextLine(scanner, "변경할 영화의 소개글를 입력해주세요.\n"));
		System.out.println("-----------------------------------------------------------------");
		String yesNo = ScannerUtil.nextLine(scanner, "정말로 수정하시겠습니까?\n수정하려면 [Y], 취소하려면 [X]를 입력해주세요.\n");
		while (!(yesNo.equalsIgnoreCase("X")) && !(yesNo.equalsIgnoreCase("Y"))) {
			System.out.println("(잘못 입력하셨습니다.)");
			System.out.println("-----------------------------------------------------------------");
			yesNo = ScannerUtil.nextLine(scanner, "정말로 수정하시겠습니까?\n수정하려면 [Y], 취소하려면 [X]를 입력해주세요.\n");
		}
		if (yesNo.equalsIgnoreCase("Y")) {
			moviesController.update(m);
			ScannerUtil.notificationL("변경이 완료되었습니다. 이전 화면으로 돌아갑니다.");
			ScannerUtil.ok(scanner, null);
			System.out.println();

		} else if (yesNo.equalsIgnoreCase("X")) {
			ScannerUtil.notificationL("변경이 취소되었습니다. 이전 화면으로 돌아갑니다.");
		}

	}

	private void delete(int movieId) {
		System.out.println("-----------------------------------------------------------------");
		String yesNo = ScannerUtil.nextLine(scanner, "정말로 삭제하시겠습니까?삭제하려면 [Y], 돌아가려면 [X]를 입력해주세요.\n");

		while (!(yesNo.equalsIgnoreCase("X")) && !(yesNo.equalsIgnoreCase("Y"))) {
			System.out.println("(잘못 입력하셨습니다.)");
			System.out.println("-----------------------------------------------------------------");
			yesNo = ScannerUtil.nextLine(scanner, "정말로 삭제하시겠습니까?삭제하려면 [Y], 돌아가려면 [X]를 입력해주세요.\n");
		}

		if (yesNo.equalsIgnoreCase("Y")) {
			scheduleViewer.deleteByMovieId(movieId);
			moviesController.delete(movieId);
			ScannerUtil.notificationL("삭제가 완료되었습니다. 이전 화면으로 돌아갑니다.");
			ScannerUtil.ok(scanner, null);

		} else if (yesNo.equalsIgnoreCase("X")) {
			ScannerUtil.notificationL("삭제가 취소되었습니다. 이전 화면으로 돌아갑니다.");
		}
	}

	public void insertNew() {
		MoviesDTO m = new MoviesDTO();

		System.out.println("-----------------------------------------------------------------");
		m.setTitleKor(ScannerUtil.nextLine(scanner, "등록할 영화의 한글 제목을 입력해주세요.\n"));
		System.out.println("-----------------------------------------------------------------");
		m.setTitleEng(ScannerUtil.nextLine(scanner, "등록할 영화의 영문 제목을 입력해주세요.\n"));
		System.out.println("-----------------------------------------------------------------");
		m.setGenre(ScannerUtil.nextLine(scanner, "등록할 영화의 장르를 입력해주세요. (예: 액션, SF, 드라마)\n"));
		System.out.println("-----------------------------------------------------------------");
		int userChoice = ScannerUtil.nextIntOnly(scanner,
				"등록할 영화의 시청등급을 입력해주세요.\n\n[1] 전체 관람가\n[2] 12세 관람가\n[3] 15세 관람가\n[4] 청소년 관람불가\n", 1, 4);
		if (userChoice == 1) {
			m.setAgeLimit(0);
		} else if (userChoice == 2) {
			m.setAgeLimit(12);
		} else if (userChoice == 3) {
			m.setAgeLimit(15);
		} else if (userChoice == 4) {
			m.setAgeLimit(18);
		}
		System.out.println("-----------------------------------------------------------------");
		m.setPlot(ScannerUtil.nextLine(scanner, "등록할 영화의 소개글을 입력해주세요.\n"));

		moviesController.insert(m);
		ScannerUtil.notificationL("등록이 완료되었습니다.");
		ScannerUtil.ok(scanner, null);
	}

	public String getMovieName(int movieId) {
		return (moviesController.selectOne(movieId).getTitleKor());
	}

	public int getMovieList() {
		if (moviesController.selectAll().isEmpty()) {
			ScannerUtil.notificationL("등록된 영화 목록이 없습니다.");
			ScannerUtil.ok(scanner, null);

		} else {
			System.out.println("-----------------------------------------------------------------");
			System.out.println("새 상영일정을 등록할 영화를 선택해주세요.\n");
			int index = 1;
			int[] indexArr = new int[1];

			for (int i = 1; i <= moviesController.selectAll().size(); i++) {
				System.out.print("[" + i + "] ");

				while (moviesController.selectOne(index) == null) {
					index++;
				}
				if (moviesController.selectOne(index) != null) {
					MoviesDTO m = moviesController.selectOne(index);
					System.out.println(m.getTitleKor());
					indexArr = ArrayUtil.add(indexArr, index);
					index++;
				}
			}
			int userChoice = ScannerUtil.nextIntOnlyPass(scanner, "");

			if (userChoice < 1 || userChoice >= ArrayUtil.size(indexArr)) {
				System.out.println("(잘못 입력하셨습니다.)");
				getMovieList();

			} else {
				int movieId = ArrayUtil.get(indexArr, userChoice);
				return movieId;
			}
		}
		return 0;
	}
}