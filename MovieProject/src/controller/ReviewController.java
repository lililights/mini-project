package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import model.ReviewDTO;

public class ReviewController {
	private ArrayList<ReviewDTO> list;
	private int nextId;
	Random random = new Random();

	public ReviewController() {
		list = new ArrayList<>();
		nextId = 1;

		for (int i = 1; i <= 18; i++) {
			ReviewDTO default1 = new ReviewDTO();
			default1.setMovieId(i);
			default1.setUserId(5);
			default1.setRating(random.nextInt(7) + 3);
			default1.setComment("올해 최고의 영화");
			default1.setWrittenDate(Calendar.getInstance());
			insert(default1);

			ReviewDTO default2 = new ReviewDTO();
			default2.setMovieId(i);
			default2.setUserId(6);
			default2.setRating(random.nextInt(7) + 3);
			default2.setComment("영상미도 좋고 너무 재밌어요!");
			default2.setWrittenDate(Calendar.getInstance());
			insert(default2);

			ReviewDTO default3 = new ReviewDTO();
			default3.setMovieId(i);
			default3.setUserId(7);
			default3.setRating(random.nextInt(7) + 3);
			default3.setComment("개꿀잼. 꼭 영화관에서 봐야함.");
			default3.setWrittenDate(Calendar.getInstance());
			insert(default3);
		}

		for (int i = 1; i <= 18; i++) {
			ReviewDTO default4 = new ReviewDTO();
			default4.setMovieId(i);
			default4.setUserId(2);
			default4.setRating(random.nextInt(6) + 4);
			default4.setTitle("(영화" + i + " 예시) 몽환적인 느낌에 동화같은 영화");
			default4.setComment(
					"<라이프 오브 파이 Life of Pi, 2012>에서는 이 이야기가 사실이라는 가정을 한다. \n하지만 이 이야기를 믿고 안 믿고는 각자의 몫이다. 그리고 그것은 인생을 바라보는 시\n각, 그리고 종교를 바라보는 시각과도 연결된다. 영화 후반부에 파이는 이런 말을 했다. \n내가 고통받고 있을 때 나를 버린 것...");
			default4.setWrittenDate(Calendar.getInstance());
			insert(default4);

			ReviewDTO default5 = new ReviewDTO();
			default5.setMovieId(i);
			default5.setUserId(3);
			default5.setRating(random.nextInt(6) + 4);
			default5.setTitle("(영화" + i + " 예시) [영화 투모로우 워 정보&후기] 테넷과 에일리언이 생각나는 미래와의...");
			default5.setComment(
					"시간여행이 주제인 영화 <테넷>에서는 알 수 없는 미래세력의 요청으로 제3차 세계대전\n을 막기 위해 주인공들이 과거의 시간으로 인버전하여 업무를 수행하지만, <투모로우 워\n>에서는 주인공들이 30년 후로 점프해서 정확히 7일 동안만 외계괴물들을 소탕하는 작전\n에 투입되었다가 다시...");
			default5.setWrittenDate(Calendar.getInstance());
			insert(default5);
		}
	}

	public void insert(ReviewDTO r) {
		r.setReviewId(nextId++);

		list.add(r);
	}

	public ArrayList<ReviewDTO> selectAll() {
		ArrayList<ReviewDTO> temp = new ArrayList<>();

		for (ReviewDTO r : list) {
			ReviewDTO tempR = new ReviewDTO(r);
			temp.add(tempR);
		}
		return temp;
	}

	public ArrayList<ReviewDTO> selectByMovieId(int movieId) {
		ArrayList<ReviewDTO> temp = new ArrayList<>();

		for (ReviewDTO r : list) {
			if (r.getMovieId() == movieId) {
				ReviewDTO tempR = new ReviewDTO(r);
				temp.add(tempR);
			}
		}
		return temp;
	}

	public ArrayList<ReviewDTO> reviewByMovieId(int movieId) {
		ArrayList<ReviewDTO> temp = new ArrayList<>();

		for (ReviewDTO r : list) {
			if (r.getMovieId() == movieId) {
				ReviewDTO tempR = new ReviewDTO(r);
				if (tempR.getTitle() == null) {
					temp.add(tempR);
				}
			}
		}
		return temp;
	}

	public ArrayList<ReviewDTO> proReviewByMovieId(int movieId) {
		ArrayList<ReviewDTO> temp = new ArrayList<>();

		for (ReviewDTO r : list) {
			if (r.getMovieId() == movieId) {
				ReviewDTO tempR = new ReviewDTO(r);
				if (tempR.getTitle() != null) {
					temp.add(tempR);
				}
			}
		}
		return temp;
	}

	public void deleteByUserId(int userId) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUserId() == userId) {
				list.remove(i);
				i = -1;
			}
		}
	}
}
