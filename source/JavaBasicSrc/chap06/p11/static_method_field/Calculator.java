package p11.static_method_field;

public class Calculator {
	
	/*********************************************************************
	 *  static 의미
	 *    - main 메소드가 실행될 때, static으로 선언된 field, method들을 
	 *   	메모리에 미리 올려 놓아 달라고 자바시스템에 요청한다는의미
	 *  static 을 사용할 수 있는 범위
	 *    - field, method만 가능
	 *    	(class, constructor 사용 불가)  (이유 : 인스턴스 생성시만 사용가능한 것들이기 때문)
	 *  static으로 선언하면, 프로그램이 시작해서 종료될 때가지 메모리에 있음
	 *  	=> 어느 class에서, 어떤 싯점에서도 static으로 선언된 field, method 사용가능
	 *********************************************************************/
	static double pi = 3.14159;
	
	static int plus(int x, int y)
	{
		return x + y;
	}
	
	static int minus(int x, int y)
	{
		return x - y;
	}
}
