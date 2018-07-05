package p01.op_unary;

public class BitReverseOperatorEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int v1 = 10;
		int v2 = ~v1;	// v2는 v1의 1의 보수 ==> -11		
		//byte v3 = 10;
		//byte v4 = ~v3;
		
		int v3 = ~v1 +1;	// v3는 v1의 2의 보수 ==> 10
		System.out.println(toBinaryString(v1) + "(십진수 = " + v1 +")");
		System.out.println(toBinaryString(v2) + "(십진수 = " + v2 +")");
		System.out.println(toBinaryString(v3) + "(십진수 = " + v3 +")");
				
	}
	
	public static String toBinaryString(int value) {
		/*
		 * Integer.toBinaryString(value) : input 값이 int인 value
		 * 								   return값은 이진수 문자열로 변환
		 */
		String str = Integer.toBinaryString(value);
		System.out.println("before while str : " + str);
		while(str.length() < 32)	// str.length() : 문자열의 길이를 구하는 것
		{
			str = "0" + str;
		}
		System.out.println("after while str : " + str);
		
		return str;
		
	}

}
