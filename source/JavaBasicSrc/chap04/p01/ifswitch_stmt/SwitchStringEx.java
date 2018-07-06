package p01.ifswitch_stmt;

public class SwitchStringEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String position = "과장";
		
		/********************************************************
		 * switch안에 들어가는 데이터 타입 
		 *   ==> char, byte, shrot, int, long, short, string이 가능
		 ********************************************************/
		switch(position)
		{
			case "부장":
				System.out.println("700만원");
				break;
			case "과장":
				System.out.println("500만원");
				break;
			default:
				System.out.println("300만원");
				break;
		}
	}

}
