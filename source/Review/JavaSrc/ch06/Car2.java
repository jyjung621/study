package ch06;

public class Car2 {
	int a = 7;
	
	void move() {
		System.out.println("�� �̵�");
	}
}

class Bus extends Car2 {
	int a = 25;
	
	void move() {
		System.out.println("40�� �¿�� �̵�");
	}
}

class Ambulance extends Car2 {
	int a = 100;
	
	void move() {
		System.out.println("���̷� �︮�� �̵�");
	}
	
	void special() {
		System.out.println("ȯ�ڸ� �¿�� �ִ�");
	}
}

class FireEngine extends Car2 {
	int a = 11;
	void move() {
		System.out.println("�� �Ѹ��鼭 �̵�");
	}
}
