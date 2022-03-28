package personnelManager;

import java.util.Scanner;
import java.util.ArrayList;
import util.ScannerUtil;

public class Pm1 {

	private static Scanner scanner = new Scanner(System.in);
	private static ArrayList<Pm2> list = new ArrayList<>();
	private static ArrayList<Pm2> listTemp = new ArrayList<>();
	private static int nextId = 1;

	private static final int FOUND_DATE = 19900101;
	private static final int CUR_DATE = 20211231;

	public static void main(String[] args) {
		showMenu();
	}

	private static void showMenu() {
		while (true) {
			System.out.println("============================================================");
			System.out.println("			사원관리 프로그램");
			System.out.println("============================================================");

			int userChoice = ScannerUtil.nextInt(scanner, "[1] 새 사원 등록하기\n[2] 사원 목록 보기\n[3] 종료하기\n", 1, 3);
			System.out.println("------------------------------------------------------------");

			if (userChoice == 1) {
				insert();

			} else if (userChoice == 2) {
				showlist();

			} else {
				System.out.println("<프로그램을 종료합니다.>");
				System.out.println("============================================================");
				scanner.close();
				break;
			}

		}
	}

	private static void insert() {
		Pm2 p = new Pm2();

		System.out.println("STEP1. 등록할 사원의 부서를 선택하세요.");
		p.setDepartment(
				ScannerUtil.nextInt(scanner, "[1] 경영관리부\n[2] 기획부\n[3] 마케팅부\n[4] 연구개발부\n[5] 영업부\n[6] 기타임원\n", 1, 6));
		System.out.println("------------------------------------------------------------");
		System.out.println("STEP2. 등록할 사원의 직급을 선택하세요.");
		p.setPosition(ScannerUtil.nextInt(scanner, "[1] 이사\n[2] 부장\n[3] 차장\n[4] 과장\n[5] 대리\n[6] 사원\n", 1, 6));
		System.out.println("------------------------------------------------------------");
		p.setName(ScannerUtil.nextLine(scanner, "STEP3. 등록할 사원의 이름을 입력하세요.\n"));
		System.out.println("------------------------------------------------------------");
		p.setResidentId(ScannerUtil.nextLine(scanner, "STEP4. 등록할 사원의 주민번호 앞 7자리를 입력하세요. (예:901217-1)\n"));
		System.out.println("------------------------------------------------------------");
		p.setPhoneNum(ScannerUtil.nextLine(scanner, "STEP5. 등록할 사원의 연락처를 입력하세요. (예: 010-1234-5678)\n"));
		System.out.println("------------------------------------------------------------");
		p.setEntryDate(ScannerUtil.nextInt(scanner, "STEP6. 등록할 사원의 입사날짜를 형식에 맞춰 정확히 입력하세요.\nYYYYMMDD (예: 20140701)\n",
				FOUND_DATE, CUR_DATE));
		p.setId(p.getEntryDate(), nextId);
		System.out.println("------------------------------------------------------------");
		nextId++;

		list.add(p);

		System.out.println("<등록이 완료되었습니다. 초기메뉴로 돌아갑니다.>\n\n\n");
	}

	private static void showlist() {
		if (list.isEmpty()) {
			System.out.println("<아직 등록된 사원이 없습니다. 초기메뉴로 돌아갑니다.>\n\n\n");
		} else {
			int userChoice = ScannerUtil.nextInt(scanner, "[1] 입사일 순으로 보기\n[2] 직급 순으로 보기\n[3] 부서 순으로 보기\n", 1, 3);
			System.out.println("------------------------------------------------------------");

			if (userChoice == 1) {
				sortByEntryDate();

			} else if (userChoice == 2) {
				sortByPosition();

			} else {
				sortByDepartment();
			}

			selectOne();
		}
	}

	private static void sortByEntryDate() {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).getEntryDate() > list.get(i + 1).getEntryDate()) {
				listTemp.add(list.get(i));
				list.set(i, list.get(i + 1));
				list.set((i + 1), listTemp.get(0));
				listTemp.clear();
				i = -1;
			}
		}
	}

	private static void sortByPosition() {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).getPosition() > list.get(i + 1).getPosition()) {
				listTemp.add(list.get(i));
				list.set(i, list.get(i + 1));
				list.set((i + 1), listTemp.get(0));
				listTemp.clear();
				i = -1;
			}
		}
	}

	private static void sortByDepartment() {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).getDepartment() > list.get(i + 1).getDepartment()) {
				listTemp.add(list.get(i));
				list.set(i, list.get(i + 1));
				list.set((i + 1), listTemp.get(0));
				listTemp.clear();
				i = -1;
			}
		}
	}

	private static void selectOne() {
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("[%d] %s %s %s\n", (i + 1), list.get(i).getDepartmentName(),
					list.get(i).getPositionName(), list.get(i).getName());
		}
		int userChoice = ScannerUtil.nextInt(scanner, "상세보기할 사원의 번호, 또는 초기메뉴로 돌아가려면 [0]을 입력하세요.\n", 0, list.size()) - 1;

		if (userChoice != -1) {
			Pm2 p = list.get(userChoice);
			showOne(p);
		} else {
			System.out.println("------------------------------------------------------------");
			System.out.println("<초기메뉴로 돌아갑니다.>\n\n\n");
		}
	}

	private static void showOne(Pm2 p) {
		p.printOne();

		int userChoice = ScannerUtil.nextInt(scanner, "[1] 수정\n[2] 삭제\n[3] 월급 계산하기\n[4] 연차 계산하기\n[5] 사원 목록으로 돌아가기\n", 1,
				5);

		if (userChoice == 1) {
			System.out.println("------------------------------------------------------------");
			update(p);

		} else if (userChoice == 2) {
			System.out.println("------------------------------------------------------------");
			delete(p);

		} else if (userChoice == 3) {
			System.out.println("------------------------------------------------------------");
			p.setYSalary(ScannerUtil.nextInt(scanner, p.getName() + "님의 연봉을 입력하세요. (단위: 만원)\n"));
			p.printSalary();
			System.out.println("<목록으로 돌아갑니다.>\n");
			System.out.println("------------------------------------------------------------");
			selectOne();

		} else if (userChoice == 4) {
			p.printHolidays();
			System.out.println("<목록으로 돌아갑니다.>\n");
			System.out.println("------------------------------------------------------------");
			selectOne();

		} else if (userChoice == 5) {
			System.out.println("------------------------------------------------------------");
			selectOne();
		}

	}

	private static void update(Pm2 p) {

		int userChoice = ScannerUtil.nextInt(scanner, "수정할 항목을 선택하세요.\n[1] 직급\n[2] 부서\n[3] 연락처\n", 1, 3);
		System.out.println("------------------------------------------------------------");

		if (userChoice == 1) {
			System.out.println("수정된 사원의 직급을 선택하세요.");
			p.setPosition(ScannerUtil.nextInt(scanner, "[1] 이사\n[2] 부장\n[3] 차장\n[4] 과장\n[5] 대리\n[6] 사원\n", 1, 6));

		} else if (userChoice == 2) {
			System.out.println("수정된 사원의 부서를 선택하세요.");
			p.setDepartment(
					ScannerUtil.nextInt(scanner, "[1] 경영관리부\n[2] 기획부\n[3] 마케팅부\n[4] 연구개발부\n[5] 영업부\n[6] 기타임원\n", 1, 6));

		} else {
			p.setPhoneNum(ScannerUtil.nextLine(scanner, "수정된 사원의 연락처를 입력하세요. (예: 010-1234-5678)\n"));
		}

		p.printOne();
		System.out.println("<수정되었습니다. 목록으로 돌아갑니다.>\n\n\n");
		System.out.println("------------------------------------------------------------");
		selectOne();
	}

	private static void delete(Pm2 p) {

		String yesNo = ScannerUtil.nextLine(scanner, "정말로 삭제하시겠습니까?\n삭제하려면 [Y]키, 또는 돌아가려면 아무키나 누르세요.\n");
		System.out.println("------------------------------------------------------------");

		if (yesNo.equalsIgnoreCase("Y")) {
			list.remove(p);
			System.out.println("<삭제되었습니다. 목록으로 돌아갑니다.>\n\n\n");
			System.out.println("------------------------------------------------------------");
			selectOne();

		} else {
			selectOne();
		}
	}
}