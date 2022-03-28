package personnelManager;

public class Pm2 {

	private int department;
	// 1 = 경영관리부
	// 2 = 기획부
	// 3 = 마케팅부
	// 4 = 연구개발부
	// 5 = 영업부
	// 6 = 기타 임원
	private int position;
	// 1 = 이사
	// 2 = 부장
	// 3 = 차장
	// 4 = 과장
	// 5 = 대리
	// 6 = 사원
	private String name;
	private String residentId;
	private String phoneNum;
	private int entryDate;
	private int id;

	private final int CUR_YEAR = 2021;
	private final int MONTHS = 12;
	private final double TAX_RATE = 0.08;
	private int ySalary;

	public void setDepartment(int department) {
		this.department = department;
	}

	public int getDepartment() {
		return department;
	}

	public String getDepartmentName() {
		if (department == 1) {
			return "경영관리부";
		} else if (department == 2) {
			return "기획부";
		} else if (department == 3) {
			return "마케팅부";
		} else if (department == 4) {
			return "연구개발부";
		} else if (department == 5) {
			return "영업부";
		}
		return "기타 임원";
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getPosition() {
		return position;
	}

	public String getPositionName() {
		if (position == 1) {
			return "이사";
		} else if (position == 2) {
			return "부장";
		} else if (position == 3) {
			return "차장";
		} else if (position == 4) {
			return "과장";
		} else if (position == 5) {
			return "대리";
		}
		return "사원";
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setResidentId(String residentId) {
		this.residentId = residentId;
	}

	public String getResidentId() {
		return residentId;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setEntryDate(int entryDate) {
		this.entryDate = entryDate;
	}

	public int getEntryDate() {
		return entryDate;
	}

	public void setId(int entryDate, int nextId) {
		if (entryDate >= 20000000) {
			this.id = ((entryDate - 20000000) / 100 * 100) + nextId;
		} else {
			this.id = ((entryDate - 19000000) / 100 * 100) + nextId;
		}
	}

	public int getId() {
		return id;
	}

	public void printOne() {
		System.out.println("\n============================================================");
		System.out.printf("[사원번호] %06d\t\t[ 이 름 ] %s\n", id, name);
		System.out.printf("[ 부 서 ] %-6s\t[ 직 급 ] %s\n\n", getDepartmentName(), getPositionName());
		System.out.printf("주민번호: %s*****\n연락처: %s\n입사일: %d(YYYY/MM/DD)\n", residentId, phoneNum, entryDate);
		System.out.println("============================================================\n");
	}

	public void setYSalary(int ySalary) {
		this.ySalary = ySalary;
	}

	public void printSalary() {
		int mSalary = ((ySalary * 10000) / MONTHS) / 10 * 10;
		int tax = ((int) (mSalary * TAX_RATE)) / 10 * 10;
		int taxSalary = (mSalary - tax) / 10 * 10;

		System.out.println("\n============================================================");
		System.out.printf("%s님의 기본급은 월 %d원이고,\n", name, mSalary);
		System.out.printf("예상 세금은 %d원, 실수력액은 %d원입니다.\n", tax, taxSalary);
		System.out.println("============================================================\n");
	}

	public void printHolidays() {
		int period = CUR_YEAR - (entryDate / 10000);
		int holidays = 12;
		if (period > 0) {
			holidays += 3;
			for (int i = 3; i <= period; i++) {
				if (i % 2 != 0) {
					holidays += 1;
				}
			}
		}
		System.out.println("\n============================================================");
		System.out.printf("%s님은 입사 %d년차로 총 %d일의 연차휴가를 사용하실 수 있습니다.\n", name, period, holidays);
		System.out.println("\n* 근로기준법에 따라 근속연수 1년 미만은 12일, 1년 이상은 15일,\n이후로는 2년마다 추가 1일씩의 연차휴가가 발생됩니다.");
		System.out.println("============================================================\n");
	}

}
