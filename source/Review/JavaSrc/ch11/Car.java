package ch11;

public class Car {
	void print() {
		System.out.println("�� ����");
	}
}

class Bus extends Car {
	void print() {
		System.out.println("�� ������");
	}

	void move() {
		System.out.println("�°��� 50����");
	}
}

class Taxi extends Car {
	void print() {
		System.out.println("�� �ý���");
	}
}
