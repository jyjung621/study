package ch06;

public class Car2Ex {
	public static void main(String[] args) {
		Car2[] car = new Car2[3];
		car[0] = new Bus();
		car[1] = new Ambulance();
		car[2] = new FireEngine();
		
		for(Car2 c : car) {
			c.move();	//	Child Method ���� ( Overriding)
			System.out.println("for Car2 --> " + c.a);	//	��� ������ �θ𲬷� �����
			c.move();
//			c.special();	//	���� �Ұ�... Child�� �����ؾ���
			
			//	instanceof -> �����ϰ��ִ� Ÿ�� Ȯ��
			if(c instanceof Ambulance) {
				Ambulance am = (Ambulance) c;
				am.special();
				System.out.println(am.a);
			}
		}
	}
}
