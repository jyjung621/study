package p02.constructor;

public class Car {
	
	String color;
	int price;
	
	
	/*************************************************************
	 *  - 생성자(constructor) : new를 통해 인스턴스(객체)가 생성될 때,
	 *    최초로 자바에서 자동으로 불리어지는 특수한 메소드
	 *  - 생성자 이름 == class이름
	 *  - 생성자 메소드의 인자가 없는 것을 default 생성자라고 함
	 *  - default 생성자는 프로그래머가 class 생성시, 명시적으로 
	 *    생성자를 만들지 않더라도 Java 시스템에서 자동으로 만들어줌
	 *  - 생성자가 default 생성자가 아닌 일반 생성자를 만들어 놓을경우
	 *    자바시스템에서 default 생성자를 자동으로 만들어 주지않음
	 *  - Class를 만들 때, default 생성자가 필요없더라도 반드시 만들어 놓아야함
	 ************************************************************/
	public Car() {	
		System.out.println("this의 주소 = " + this);

		System.out.println("default 생성자가 불러졌습니다.");
	}

	/****************************************
	 *  생성자로, 인자가 2개인 생성자
	 *  생성자의 가장 기본적인 역할 : Field 값 초기화
	 ****************************************/   
	/*public Car(String string, int i) {
		System.out.println(string);
		System.out.println(i);
		System.out.println("인자가 2개인 생성자가 불리어졌습니다.");
		color = string;
		price = i;
	}	*/
	
	/**********************************************************
	 *  Eclipse 지원 -> 생성자 만들기
	 *  우클릭 -> source(Alt+Shift+s) -> Generate Constructor... 
	 **********************************************************/
	public Car(String color, int price) {
		//super();	// 7장 상속에서 배움, 부모 class의 생성자를 부르는 메소드
		// this : new를 통해 메모리에 생성된 해당 인스턴스 객체의 주소를 가짐
		System.out.println("this의 주소 = " + this);
		this.color = color;
		this.price = price;
	}

	
	
}
