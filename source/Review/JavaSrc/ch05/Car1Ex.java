package ch05;

class Car1 {
	String color;
	static int speed;	//	Ŭ���� ���� (�����Ǵ� ����) �ν��Ͻ��� ������ �����Ǵ��� ������
	
	void print () {
		System.out.println("���� : " + color);
		System.out.println("�ӵ� : " + speed);
		System.out.println("-----------------");
	}
}

public class Car1Ex {
	public static void main(String[] args) {
		Car1.speed = 130;
		
		Car1 c1 = new Car1();
		Car1 c2 = new Car1();
		
		c1.color = "����";
		c1.speed = 200;
		c2.color = "���";
		c2.speed = 150;
		c1.print();
		c2.print();
		//c1.color = "�ʷ�";
		//yourCar.speed = 150;
		//yourCar.print();
	}

}
