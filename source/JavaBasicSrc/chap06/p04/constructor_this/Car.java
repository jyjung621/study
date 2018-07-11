package p04.constructor_this;

public class Car {

	// Field
	// company는 인스턴스에 무관하게 모든 객체가 공통으로 갖는 값
	String company = "현대자동차";
	// model, color, maxSpeed는 new로 인스턴스 생성시 마다, 
	// 각 인스턴스의 필드값을 별도로 설정하기 위한 것
	String model;
	String color;
	int maxSpeed;
	
	
	// 생성자
	public Car() {
		
	}
	public Car(String model) {
		// Car(String model, String color, int maxSpeed)
		// 생성자 호출하는 메소드가 ==> this(model, null, 0)
		this(model, "은색", 250);
	}
	public Car(String model, String color) {
		this(model, color, 250);
	}
	
	/***********************************************
	 *  Method에서 데이터 타입의 순서가 중복되면 동일한 메소드로 인식함
	 *  데이터 타입 순서에 유의해서 오버로딩 할 것
	 ***********************************************/
	public Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	public Car(String color, int maxSpeed, String model) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	
}
