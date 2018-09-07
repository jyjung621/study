package ch06;

public class Car2Ex {
	public static void main(String[] args) {
		Car2[] car = new Car2[3];
		car[0] = new Bus();
		car[1] = new Ambulance();
		car[2] = new FireEngine();
		
		for(Car2 c : car) {
			c.move();	//	Child Method 실행 ( Overriding)
			System.out.println("for Car2 --> " + c.a);	//	멤버 변수는 부모껄로 적용됨
			c.move();
//			c.special();	//	실행 불가... Child가 수행해야함
			
			//	instanceof -> 참조하고있는 타입 확인
			if(c instanceof Ambulance) {
				Ambulance am = (Ambulance) c;
				am.special();
				System.out.println(am.a);
			}
		}
	}
}
