package p03.variable.typeconversion;

public class PromotionEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
										// promotion --> 작은자료형 -> 큰자료형
		byte byteValue = 10;
		int intValue = byteValue;		// byte -> int로 자동변환 (promotion)
		System.out.println(intValue);
		
		char charValue = '가';
		intValue = charValue;			// char -> int로 자동변환 (promotion)		
		System.out.println("가의 유니코드 = " + intValue);
		
		intValue = 500;
		long longValue = intValue;		// int -> long로 자동변환 (promotion)
		System.out.println(intValue);
		
		intValue = 200;
		double doubleValue = intValue;	// int -> double로 자동변환 (promotion)
		System.out.println(intValue);
		
	}

}
