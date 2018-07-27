package p05.console.system_in;

import java.io.IOException;
import java.io.InputStream;

public class SystemInEx1 {
	public static void main(String[] args) throws Exception {
		System.out.println("== 메뉴 ==");
		System.out.println("1. 예금 조회");
		System.out.println("2. 예금 출금");
		System.out.println("3. 예금 입금");
		System.out.println("4. 종료 하기");
		System.out.print("메뉴를 선택하세요 : ");
		
		//	System.in은 InputStream의 자식이어서
		//	InputStream으로 data type을 선언
		InputStream is = System.in;
		//	read 메소드의 return 값은 int이나 바이트로 들어옴
		//	프로그램내에서는 char로 작성하는 편이 용이하여 casting하여 사용함
		char inputChar = (char) is.read();
		switch(inputChar)
		{
			case '1':
				System.out.println("예금 조회를 선택하셨습니다.");
				break;
			case '2':
				System.out.println("예금 출금을 선택하셨습니다.");
				break;
			case '3':
				System.out.println("예금 입금을 선택하셨습니다.");
				break;
			case '4':
				System.out.println("종료 하기를 선택하셨습니다.");
				break;
		}
	}
}
