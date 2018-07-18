package p01.nested_basic;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		A a = new A();		
		//	인스턴스 멤버 클래스 객체 생성
		A.B b = a.new B();
		b.field1 = 3;
		b.method1();
		
		//	정적 멤버 클래스 객체 생성
		A.C c = new A.C();
		//	instance field, method 사용할 때는 인스턴스 c 사용
		c.filed1 = 3;
		c.method1();
		//	static member class 안에 있는 static field, method는 객체 생성없이 직접 사용가능
		A.C.field2 = 3;
		A.C.method2();
		
		//	로컬 클래스 객체 생성을 위한 메소드 호출
		a.method();
	}

}
