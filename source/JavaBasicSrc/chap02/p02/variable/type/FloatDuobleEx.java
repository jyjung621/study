package p02.variable.type;

public class FloatDuobleEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 실수값 저장, 실수에서 literal의 기본값은 double임
		double var1 = 3.14;
		//float var2 = 3.14;	// 3.14가 double type이어서 float로 할당 불가
		float var3 = 3.14F;
		
		// 정밀도 테스트
		double var4 = 0.1234567890123456789;
		float var5 = 0.1234567890123456789F;
		
		System.out.println("var1 : " + var1);
		System.out.println("var3 : " + var3);
		System.out.println("var4 : " + var4);
		System.out.println("var5 : " + var5);
		
		// 실수 숫자를 e를 사용해서 표현
		int var6 = 3000000;
		double var7 = 3e6;
		float var8 = 2e-3F;
		double var9 = 2e-3;
		
		System.out.println("var6 : " + var6);
		System.out.println("var7 : " + var7);
		System.out.println("var8 : " + var8);
		System.out.println("var9 : " + var9);
		
		
		
	}

}
