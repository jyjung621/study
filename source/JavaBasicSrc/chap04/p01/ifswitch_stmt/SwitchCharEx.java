package p01.ifswitch_stmt;

public class SwitchCharEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char grade = 'B';
		
		/********************************************************
		 * switch안에 들어가는 데이터 타입 
		 *   ==> char, byte, shrot, int, long, short, string이 가능
		 ********************************************************/
		switch(grade)
		{
			case 'A':
			case 'a':
				System.out.println("우수 회원입니다.");
				break;
			case 'B':
			case 'b':
				System.out.println("일반 회원입니다.");
				break;
			default:
				System.out.println("손님 입니다.");
				break;
		}
	}

}
