package p05.field_polymorphism;

public class CarEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car myCar = new Car();
		
		myCar.run();
		
		myCar.frontLeftTire = new KumhoTire();
		myCar.frontRightTire = new KumhoTire();
		
		myCar.run();
	}

}
