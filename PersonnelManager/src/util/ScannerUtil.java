package util;

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

	public static int nextInt(Scanner scanner, String message, int min, int max) {
		int num = nextInt(scanner, message);

		while (!(num >= min && num <= max)) {
			System.out.println("잘못 입력하셨습니다.");
			System.out.println("------------------------------------------------------------");
			num = nextInt(scanner, message);
		}

		return num;
	}

	public static String nextLine(Scanner scanner, String message) {
		printMessage(message);
		String temp = scanner.nextLine();

		if (temp.isEmpty()) {
			temp = scanner.nextLine();
		}

		return temp;
	}
}
