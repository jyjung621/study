package p07.polymorphism.field;

public class CarEx {

	public static void main(String[] args) {
		Car car = new Car();

		for (int i = 1; i <= 5; i++) {
			// problemLocation : 1(앞왼쪽), 2(앞오른쪽), 3(뒤왼쪽), 4(뒤오른쪽)
			//					 0(정상인경우)
			int problemLocation = car.run();

			switch (problemLocation) {
			case 1:
				System.out.println("앞왼쪽 HankookTire로 교체");
				// 부모인 Tire 데이터 타입의 frontLeftTire 변수에 자식객체를 할당
				// => 한국타이어로 교체한 이후에 run할 때 한국타이어의 roll()
				// 	  method를 실행하게 됨
				car.frontLeftTier = new HankookTire("앞왼쪽", 15);
				break;
			case 2:
				System.out.println("앞오른쪽 KumhoTire로 교체");
				car.forntRightTire = new KumhoTire("앞오른쪽", 13);
				break;
			case 3:
				System.out.println("뒤왼쪽 HankookTire로 교체");
				car.backLeftTire = new HankookTire("뒤왼쪽", 14);
				break;
			case 4:
				System.out.println("뒤오른쪽 KumhoTire로 교체");
				car.backRightTire = new KumhoTire("뒤오른쪽", 17);
				break;
			}
			System.out.println("----------------------------");
		}

	}

}
