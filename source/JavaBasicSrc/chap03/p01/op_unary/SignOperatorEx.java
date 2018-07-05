package p01.op_unary;

public class SignOperatorEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x = -100;
		int result1 = +x;	// 변수에 부호를 곱해주는 것  
		int result2 = -x;
		
		System.out.println("result1 = " + result1);
		System.out.println("result2 = " + result2);
		
		short s = 100;
		//short result3 = -s;
		int result3 = -s;
		System.out.println("result3 = " + result3);
	}

}
