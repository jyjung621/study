package p02.loopstatement;

import java.util.Scanner;

public class DoWhileEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("메시지를 입력하세요");
		System.out.println("프로그램을 종료하려면 q를 입력하세요.");
		
		Scanner scanner = new Scanner(System.in);		// Scanner 객체 생성
		String inputString;
		
		do
		{
			System.out.print(">");
			// nextLine() 메소드 호출, 키보드로 입력한 문자열을 얻음
			inputString = scanner.nextLine();	
			System.out.println(inputString);
		}while(!inputString.equals("q"));	// equals() 메소드 , 문자열을 비교할 때 사용
		
		System.out.println();
		System.out.println("프로그램 종료");
		
	}

}
