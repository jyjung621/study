package p05.method_basic;

public class CalculatorEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*************************************
		 *  Calculator의 method 호출할 경우에는
		 *  기본적으로 new를 통해 인스턴스를 만들고, 
		 *  인스턴스를 통해 메소드 호출
		 *************************************/
		Calculator myCalc = new Calculator();	// default 생성자 사용
		myCalc.powerOn();
		
		int result1 = myCalc.plus(5, 6);
		System.out.println("result1 : " + result1);
		
		byte x = 10;
		byte y = 4;
		double result2 = myCalc.divide(x, y);
		System.out.println("result2 : " + result2);
		
		myCalc.poweroff();

	}

}
