package p02.loopstatement;

import java.io.IOException;

public class WhileKeyControlEx {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		boolean run = true;
		int speed = 0;
		int keyCode = 0;		// 키보드 자판의 한글자의 코드값
		
		while(run)
		{
			/**************************************************
			 *  keyCode 13  ==>  CR(Carriage Return)
			 *  keyCode 10  ==>  LF(Line Feed, New line)
			 *  keyboard에서 enter key를 입력하면 CR, LF 두개의 문자가 발생 
			 **************************************************/
			if((keyCode != 13) && (keyCode != 10))
			{
				System.out.println("-------------------");
				System.out.println("1.증속 | 2.감속 | 3.중지");
				System.out.println("-------------------");
				System.out.println("선택 : ");
			}
			System.out.println("현재 keyCode 값 = " + keyCode);
			
			// read는 key에서 enter key를 쳤을 경우에만 값을 retrun 함
			// inputBuffer가 다 비워질때까지 read()함  buffer에 아무것도 없을경우 대기
			keyCode = System.in.read();	// 키보드의 키 코드를 읽음
			if(keyCode == 49)		// 1을 읽었을 경우
			{
				speed++;
				System.out.println("현재 속도 = " + speed);
			}
			else if(keyCode == 50)	// 2을 읽었을 경우
			{
				speed--;
				System.out.println("현재 속도 = " + speed);
			}
			else if(keyCode == 51)	// 3을 읽었을 경우
			{
				run = false;
			}
			
		}
		
		System.out.println("프로그램 종료");
	}

}
