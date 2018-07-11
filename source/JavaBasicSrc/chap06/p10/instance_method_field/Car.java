package p10.instance_method_field;

public class Car {
	// Field
	String model;
	int speed;
	
	// 생성자
	public Car(String model) {
	//	super();
		this.model = model;
	}
	
	// 메소드
	void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
	void run()
	{
		for(int i=0; i<=50; i+=10)
		{
			// this라는 객체(인스턴스)를 method에도 사용 가능
			this.setSpeed(i);
			System.out.println(this.model + "가 달립니다.(시속 : " +this.speed + "km/h");
		}
	}
	
}
