package p11.static_method_field;

public class CalculatorEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		// static으로 선언된 field 인 pi를 사용시, '클래스이름.pi'로 사용
		double result1 = 10 * 10 * Calculator.pi;
		// static으로 선언된 method 인 plus를 사용시, '클래스이름.plus'로 사용
		int result2 = Calculator.plus(10, 5);
		int result3 = Calculator.minus(10, 5);
		
		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
		System.out.println("result3 : " + result3);
	}

}
