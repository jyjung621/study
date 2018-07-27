package p06.console.scanner;

import java.util.Scanner;

public class ScannerEx {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("문자열 입력 > ");
		String inputString = scanner.nextLine();
		System.out.println(inputString);
		System.out.println();
		
		System.out.print("정수 입력 > ");
		//	nextLine, nextInt, nextDouble 메소드 들은
		//	사용자가 enter key를 입력했을 경우에 값을 가져오고
		//	값에는 enter key값이 제거되서 들어옴
		int inputint = scanner.nextInt();
		System.out.println(inputint);
		System.out.println();
		
		System.out.print("실수 입력 > ");
		double inputDouble = scanner.nextDouble();
		System.out.println(inputDouble);
				
	}
}
