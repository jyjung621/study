package p01.class_basic;

public class CarEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 객체 생성
		Car myCar = new Car();
		
		// Field 값 읽기
		System.out.println("제작회사 = " + myCar.company);
		System.out.println("모델명 = " + myCar.model);
		System.out.println("색상 = " + myCar.color);
		System.out.println("최고속도 = " + myCar.maxSpeed);
		
		/************************************************
		 *  Field 변수에 초기값을 주지 않더라도, 
		 *  new를 통하여 인스턴스가 생성되면 초기값이 자동으로 Setting됨
		 ************************************************/
		System.out.println("현재속도 = " + myCar.speed); // 출력 : 0
		
		// Field 값 변경
		myCar.speed = 60;
		System.out.println("현재속도 = " + myCar.speed);
	}

}
