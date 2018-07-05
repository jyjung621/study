package p02.op_binary;

public class CompareOperatorEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int v2 = 1;
		double v3 = 1.0;		
		/**************************************
		 * 비교연산자(==) 수행할 때, 자료형이 큰 타입으로 변환
		 * v2 값인 1을 1.0으로 변환하여 == 연산을 수행
		 **************************************/
		System.out.println(v2 == v3);	// true
		
		
		double v4 = 0.1;
		float v5 = 0.1F;
		System.out.println(v4 +"\t" + v5);
		/*************************************
		 * double인 v4의 소숫점이하 자리수의 값과 
		 * float인 v5의 소숫점이하 값이 틀려서 false가 됨
		 *************************************/
		System.out.println(v4 == v5);	// false
		System.out.println(v4 == (double)v5);	// false
		System.out.println((float)v4 == v5);	// true
	}

}
