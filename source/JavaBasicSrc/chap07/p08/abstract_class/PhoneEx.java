package p08.abstract_class;

public class PhoneEx {

	public static void main(String[] args) {
		// Phone은 abstract class인데, new로 해서
		// instance 생성 불가
//		Phone phone = new Phone();
		
		// SmartPhone 자식객체가 생성되면서, 부모 abstract
		// class인 Phone 인스턴스가 생성됨 
		SmartPhone smartPhone = new SmartPhone("홍길동");
		
		// 부모 abstract class의 메소드 호출
		smartPhone.turnOn();
		// 자식 class의 method 호출
		smartPhone.internetSearch();
		smartPhone.turnOff();

	}

}
