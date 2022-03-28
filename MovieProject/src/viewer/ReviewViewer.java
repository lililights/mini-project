package viewer;

import java.util.Scanner;
import java.util.ArrayList;

import controller.ReviewController;
import model.ReviewDTO;
import model.UserDTO;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import myUtil.ScannerUtil;

public class ReviewViewer {
	private Scanner scanner;
	private ReviewController reviewController;
	private UserDTO logIn;
	private UserViewer userViewer;
	private final String DATE_FORMAT_STRING = new String("yy/M/d H:m");

	public void setLogIn(UserDTO logIn) {
		this.logIn = logIn;
	}

	public ReviewViewer(Scanner scanner, UserViewer userViewer) {
		reviewController = new ReviewController();
		this.scanner = scanner;
		this.userViewer = userViewer;
	}

	public void printReview(int movieId) {
		while (true) {
			ArrayList<ReviewDTO> list = reviewController.reviewByMovieId(movieId);
			if (list.isEmpty()) {
				ScannerUtil.notificationL("아직 등록된 리뷰가 없습니다.");
				ScannerUtil.ok(scanner, null);
				System.out.println();
				break;

			} else {
				System.out.println("-----------------------------------------------------------------");
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_STRING);
				System.out.printf("[평균평점] %s %.1f\n\n", getRatingStars(getAverageRating(movieId)),
						getAverageRating(movieId));

				for (ReviewDTO r : list) {
					System.out.print(getRatingStars(r.getRating()) + "  ");
					System.out.print(userViewer.printNickName(r.getUserId()) + ": " + r.getComment());
					System.out.println(" (" + sdf.format(r.getWrittenDate().getTime()) + ")");
				}
			}
			System.out.println("-----------------------------------------------------------------");
			int userChoice = ScannerUtil.nextIntOnly(scanner, "[1] 평점/한줄평 남기기\n[0] 뒤로가기\n", 0, 1);

			if (userChoice == 1) {
				if (logIn == null) {
					ScannerUtil.notificationL("평점을 남기려면 로그인 해주세요.");
					ScannerUtil.ok(scanner, null);
					break;
				} else {
					writeReview(movieId);
				}
			} else if (userChoice == 0) {
				ScannerUtil.notificationL(null);
				break;
			}
		}
	}

	private void writeReview(int movieId) {
		ReviewDTO r = new ReviewDTO();
		System.out.println("-----------------------------------------------------------------");
		r.setMovieId(movieId);
		r.setRating(ScannerUtil.nextIntOnly(scanner,
				"별점을 입력해주세요.\n\n[1] 1점 [2] 2점 [3] 3점 [4] 4점 [5] 5점\n[6] 6점 [7] 7점 [8] 8점 [9] 9점 [10] 10점\n", 1, 10));
		System.out.println("-----------------------------------------------------------------");
		r.setComment(ScannerUtil.nextLine(scanner, userViewer.printNickName(logIn.getUserId()) + "님의 한줄평:\n"));
		r.setUserId(logIn.getUserId());
		r.setWrittenDate(Calendar.getInstance());

		reviewController.insert(r);
	}

	public void printProReview(int movieId) {
		while (true) {
			ArrayList<ReviewDTO> list = reviewController.proReviewByMovieId(movieId);
			if (list.isEmpty()) {
				ScannerUtil.notificationL("아직 등록된 리뷰가 없습니다.");
				ScannerUtil.ok(scanner, null);
				System.out.println();
				break;

			} else {
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_STRING);
				System.out.println();
				for (ReviewDTO r : list) {
					System.out.println("=================================================================");
					System.out.println(r.getTitle());
					System.out.println("-----------------------------------------------------------------");
					System.out.println(
							userViewer.printNickName(r.getUserId()) + "  " + sdf.format(r.getWrittenDate().getTime()));
					System.out.println("-----------------------------------------------------------------");
					System.out.print((r.getRating()) * 10 + " " + getRatingStars(r.getRating()));
					System.out.println();
					System.out.println(r.getComment());
				}
			}
			System.out.println("=================================================================");
			System.out.println("(* 리뷰 예시의 내용은 모든 영화 동일)\n");

			if (logIn != null && logIn.getLevel() == 2) {
				int userChoice = ScannerUtil.nextIntOnly(scanner, "[1] 새 리뷰 올리기\n[0] 뒤로가기\n", 0, 1);
				if (userChoice == 1) {
					writeProReview(movieId);
				} else if (userChoice == 0) {
					ScannerUtil.notificationL(null);
					break;
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

	private void writeProReview(int movieId) {
		ReviewDTO r = new ReviewDTO();
		System.out.println("-----------------------------------------------------------------");
		r.setMovieId(movieId);
		r.setRating(ScannerUtil.nextIntOnly(scanner,
				"별점을 입력해주세요.\n[1] 1점 [2] 2점 [3] 3점 [4] 4점 [5] 5점\n[6] 6점 [7] 7점 [8] 8점 [9] 9점 [10] 10점\n", 1, 10));
		System.out.println("-----------------------------------------------------------------");
		r.setTitle(ScannerUtil.nextLine(scanner, "제목을 입력해주세요.\n"));
		System.out.println("-----------------------------------------------------------------");
		r.setComment(ScannerUtil.nextLine(scanner, "내용을 입력해주세요.\n"));
		r.setUserId(logIn.getUserId());
		r.setWrittenDate(Calendar.getInstance());

		reviewController.insert(r);
		ScannerUtil.notificationL("등록이 완료되었습니다.");
		ScannerUtil.ok(scanner, null);
		System.out.println();
	}

	public double getAverageRating(int movieId) {
		ArrayList<ReviewDTO> list = reviewController.selectByMovieId(movieId);
		if (list.size() == 0) {
			return 0;
		}
		int sum = 0;
		for (ReviewDTO r : list) {
			sum += r.getRating();
		}
		double average = (double) sum / list.size();
		return average;
	}

	public String getRatingStars(double rating) {
		if (rating < 3) {
			return "★☆☆☆☆";
		} else if (rating >= 3 && rating < 5) {
			return "★★☆☆☆";
		} else if (rating >= 5 && rating < 7) {
			return "★★★☆☆";
		} else if (rating >= 7 && rating < 9) {
			return "★★★★☆";
		} else if (rating >= 9) {
			return "★★★★★";
		}
		return null;
	}

	public void deleteByUserId(int userId) {
		reviewController.deleteByUserId(userId);
	}
}
