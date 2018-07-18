package p05.field_polymorphism;

public class Car {
	Tire frontLeftTire = new HankookTire();
	Tire frontRightTire = new HankookTire();
	Tire backLeftTire = new HankookTire();
	Tire backRigtTire = new HankookTire();
	
	void run()
	{
		frontLeftTire.roll();
		frontRightTire.roll();
		backLeftTire.roll();
		backRigtTire.roll();
	}
}
