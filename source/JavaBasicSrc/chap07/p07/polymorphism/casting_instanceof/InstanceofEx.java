package p07.polymorphism.casting_instanceof;

public class InstanceofEx {
	public static void method1(Parent parent) {
		// A instanceof B : A 변수가 B class의 객체이냐
		// => 객체이면 true, 객체가 아니면 false
		if (parent instanceof Child) {
			Child child = (Child) parent;
			System.out.println("method1 - Child로 변환 성공");
		} else {
			System.out.println("method1 - Child로 변환되지 않음");
		}
	}
	
	// 부모 타입을 자식타입으로 강제 형변환하는 메소드
	public static void method2(Parent parent) {
		Child child = (Child) parent;
		System.out.println("method1 - Child로 변환 성공");
	}
	

	public static void main(String[] args) {
		// 부모 Parent타입에 자식객체를 할당(자동형변환)
		Parent parentA = new Child();
		method1(parentA);
		method2(parentA);
		
		Parent parentB = new Parent();
		method1(parentB);
//		method2(parentB);

	}

}
