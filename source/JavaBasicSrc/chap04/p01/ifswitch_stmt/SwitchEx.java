package p01.ifswitch_stmt;

public class SwitchEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = (int)(Math.random()*6) + 1;
		
		/********************************************************
		 * switch안에 들어가는 데이터 타입 
		 *   ==> char, byte, shrot, int, long, short, string이 가능
		 ********************************************************/
		switch(num)
		{
			case 1:
				System.out.println("1번이 나왔습니다.");
				break;
			case 2:
				System.out.println("2번이 나왔습니다.");
				break;
			case 3:
				System.out.println("3번이 나왔습니다.");
				break;
			case 4:
				System.out.println("4번이 나왔습니다.");
				break;
			case 5:
				System.out.println("5번이 나왔습니다.");
				break;
			default:
				System.out.println("6번이 나왔습니다.");
				break;
		}
	}

}