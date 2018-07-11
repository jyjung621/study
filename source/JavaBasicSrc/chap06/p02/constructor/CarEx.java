package p02.constructor;

public class CarEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car myCar = new Car();
		System.out.println("myCar의 주소 = " + myCar);
		System.out.println("main에서 myCar 인스턴스를 생성했습니다.");
		
		Car myCar1 = new Car("검정", 3000);
		System.out.println("main에서 myCar1 인스턴스를 생성했습니다.");
		System.out.println("myCar1의 주소 = " + myCar1);
		System.out.println("myCar1.color = " + myCar1.color);
		System.out.println("myCar1.price = " + myCar1.price);
		
		Car myCar2 = new Car("노랑", 6000);
		System.out.println("myCar2의 주소 = " + myCar2);
		System.out.println("myCar2.color = " + myCar2.color);
		System.out.println("myCar2.price = " + myCar2.price);
	}

}
