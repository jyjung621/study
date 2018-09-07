package ch05;

class Car1 {
	String color;
	static int speed;	//	클래스 변수 (공유되는 변수) 인스턴스가 여러개 생성되더라도 공유함
	
	void print () {
		System.out.println("색깔 : " + color);
		System.out.println("속도 : " + speed);
		System.out.println("-----------------");
	}
}

public class Car1Ex {
	public static void main(String[] args) {
		Car1.speed = 130;
		
		Car1 c1 = new Car1();
		Car1 c2 = new Car1();
		
		c1.color = "빨강";
		c1.speed = 200;
		c2.color = "노랑";
		c2.speed = 150;
		c1.print();
		c2.print();
		//c1.color = "초록";
		//yourCar.speed = 150;
		//yourCar.print();
	}

}
