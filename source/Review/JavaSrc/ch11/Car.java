package ch11;

public class Car {
	void print() {
		System.out.println("난 차임");
	}
}

class Bus extends Car {
	void print() {
		System.out.println("난 버스임");
	}

	void move() {
		System.out.println("승객이 50명임");
	}
}

class Taxi extends Car {
	void print() {
		System.out.println("난 택시임");
	}
}
