package p07.polymorphism.field;

public class Car {
	// field
	Tire frontLeftTier = new Tire("앞왼쪽", 6);
	Tire forntRightTire = new Tire("앞오른쪽", 2);
	Tire backLeftTire = new Tire("뒤왼쪽", 3);
	Tire backRightTire = new Tire("뒤오른쪽", 4);
	
	// constructor
	
	// method
	int run() {
		System.out.println("[자동차가 달립니다.]");
		// return값 => 1(앞왼쪽), 2(앞오른쪽), 3(뒤왼쪽), 4(뒤오른쪽)
		//			   0(정상적인경우)
		if (frontLeftTier.roll() == false) {
			stop();
			return 1;
		}
		if (forntRightTire.roll() == false) {
			stop();
			return 2;
		}
		if (backLeftTire.roll() == false) {
			stop();
			return 3;
		}
		if (backRightTire.roll() == false) {
			stop();
			return 4;
		}
		return 0;		
	}
	
	void stop() {
		System.out.println("[자동차가 멉춥니다.]");
	}

}
