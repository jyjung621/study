package p03.constructor_overloading;

public class Car {

	// Field
	// company는 인스턴스에 무관하게 모든 객체가 공통으로 갖는 값
	String company = "현대자동차";
	// model, color, maxSpeed는 new로 인스턴스 생성시 마다, 
	// 각 인스턴스의 필드값을 별도로 설정하기 위한 것
	String model;
	String color;
	int maxSpeed;
	
	
	//생성자
	/*****************************************************************
	 *  생성자 overloading : new로 인스턴스 생성할 때, 요청된 인자 갯수, 
	 *  	인자의 data type에 맞게 해당 생성자를 시스템에서 자동으로 부르는것을 말함
	 *****************************************************************/
	public Car() {
		//super();
	}
	public Car(String model) {
		//super();
		this.model = model;
	}
	public Car(String model, String color) {
		//super();
		this.model = model;
		this.color = color;
	}
	public Car(String model, String color, int maxSpeed) {
		//super();
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	
}
