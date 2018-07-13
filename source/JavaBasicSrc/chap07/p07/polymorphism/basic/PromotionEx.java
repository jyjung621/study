package p07.polymorphism.basic;

public class PromotionEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();
		


		b.method1();	//	b의 부모 메소드
		b.method2();	//	b 자신의 메소드 호출
		
		/************************************************
		 * 	A의 자식인 B 클래스 인스턴스를 부모인 A로 할당
		 * 	( 자동 형변환의 개념 )  ==> 자식객체를 부모 클래스에 할당 가능
		 * 	즉, b를 부모클래스의 변수 a1에 할당한다는 의미는 
		 * 		a1이 부모의 필드와 메소드만 사용가능하게 형변환했다는 의미임
		 ************************************************/
		A a1 = b;
		//	a1의 클래스의 메소드만 사용가능, 자식인  B클래스의 메소드 사용불가
		a1.method1();	
		//a1.method2();
		

		
		
	}

}
