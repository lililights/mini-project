package myUtil;

import java.util.Scanner;

public class ScannerUtil {

	private static void printMessage(String message) {
		System.out.println(message);
		System.out.print("> ");
	}

	public static int nextInt(Scanner scanner, String message) {
		printMessage(message);
		return scanner.nextInt();
	}

	public static int nextIntOnly(Scanner scanner, String message) {
		String temp = nextLine(scanner, message);
		String pattern = "^[0-9]+$";
		while (!temp.matches(pattern)) {
			System.out.println("(잘못 입력하셨습니다.)");
			System.out.println("-----------------------------------------------------------------");
			temp = nextLine(scanner, message);
		}
		int result = Integer.parseInt(temp);
		return result;
	}

	public static int nextIntOnlyPass(Scanner scanner, String message) {
		String temp = nextLine(scanner, message);
		String pattern = "^[0-9]+$";
		while (!temp.matches(pattern)) {
			return 9999;
		}
		int result = Integer.parseInt(temp);
		return result;
	}

	public static int nextInt(Scanner scanner, String message, int min, int max) {
		int num = nextInt(scanner, message);

		while (!(num >= min && num <= max)) {
			System.out.println("(잘못 입력하셨습니다.)");
			System.out.println("-----------------------------------------------------------------");
			num = nextInt(scanner, message);
		}
		return num;
	}

	public static int nextIntOnly(Scanner scanner, String message, int min, int max) {
		int num = nextIntOnly(scanner, message);

		while (!(num >= min && num <= max)) {
			System.out.println("(잘못 입력하셨습니다.)");
			System.out.println("-----------------------------------------------------------------");
			num = nextIntOnly(scanner, message);
		}
		return num;
	}

	public static int nextIntOnlyPass(Scanner scanner, String message, int min, int max) {
		String temp = nextLine(scanner, message);
		String pattern = "^[0-9]+$";

		if (!temp.matches(pattern)) {
			temp = "9999";
		}

		int result = Integer.parseInt(temp);

		if (!(result >= min && result <= max)) {
			System.out.println("(잘못 입력하셨습니다.)");
		}
		return result;
	}

	public static void notificationL(String message) {
		if (message == null) {
			message = "이전 화면으로 돌아갑니다.";
		}
		System.out.print("\n<<");
		System.out.print(message);
		System.out.println(">>\n");
	}

	public static void notificationS(String message) {
		if (message == null) {
			message = "잘못 입력하셨습니다.";
		}
		System.out.print("(");
		System.out.print(message);
		System.out.println(")");
		System.out.println("-----------------------------------------------------------------");
	}

	public static String nextLine(Scanner scanner, String message) {
		printMessage(message);
		String temp = scanner.nextLine();

		if (temp.isEmpty()) {
			temp = scanner.nextLine();
		}
		return temp;
	}

	public static String ok(Scanner scanner, String message) {
		if (message == null) {
			message = "[확인] 계속 진행하려면 아무키나 눌러주세요.\n";
		}
		printMessage(message);
		String temp = scanner.nextLine();

		if (temp.isEmpty()) {
			temp = scanner.nextLine();
		}
		return temp;
	}
}
