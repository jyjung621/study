package p03.variable.typeconversion;

public class CastingEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
											// casting --> 큰자료형 -> 작은자료형
		int intValue = 44032;
		// (char) 의미 : char data type으로 강제 형변환(casting) 시키라는 의미
		char charValue = (char) intValue;	
		System.out.println(charValue);
		
		long longValue = 500;
		intValue = (int) longValue;
		System.out.println(intValue);
		
		double doubleValue = 3.14;
		intValue = (int) doubleValue;
		System.out.println(intValue);
		
		
	}

}
