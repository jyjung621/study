package p03.method_override;

public class Computer extends Calculator {

	/***************************************************************
	 * 부모의 areaCircle 메소드와 return type, method이름, 인자의 수와 데이터타입이 동일한 메소드를 자식 클래스에서
	 * 재정의(override) 가능
	 ***************************************************************/
	@Override
	double areaCircle(double r) {
		System.out.println("Computer 객체의 areaCircle() 실행");
		return Math.PI * r * r;
	}
}
