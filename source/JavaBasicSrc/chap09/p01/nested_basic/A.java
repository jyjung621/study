package p01.nested_basic;

public class A {
	//	instance field
	B field1 = new B();
	C field2 = new C();
	
	//	static field
	//static B field3 = new B();
	static C field4 = new C();
	
	//	instance method
	void method1()
	{
		B var1 = new B();	//	local instance 변수 선언
		C var2 = new C();	//	local static 변수 선언
	}
	
	//	static method
	static void method2()
	{
		//	static method에 인스턴스 local 변수 선언 불가
		//B var1 = new B();
		C var2 = new C();
	}
	
	//	constructor
	A() {
		System.out.println("A 객체가 생성됨");
	}

	/** 인스턴스 멤버 클래스 **/
	class B {
		// field 선언
		int field1;	//	field1 ==> instance filed
		// instance member class 안에 static field 선언 불가
		// static int field2;

		// constructor 선언
		B() {
			System.out.println("B 객체가 생성됨");
		}

		// method 선언 (instance 메소드 선언 가능)
		void method1() {
			System.out.println("field1 = " + field1);
		}
		//	static method는 인스턴스 멤버 클래스에서 선언 불가
		// static method2() {}
	}

	/** 정적 멤버 클래스 **/
	//	정적멤버 클래스 안에 field나 method를 실행하려면
	//	반드시 먼저 instance가 생성되어야 함
	static class C {
		// field 선언
		int filed1;
		static int field2;

		// constructor 선언
		C() {
			System.out.println("C 객체가 생성됨");
		}

		// method 선언
		void method1() {
		}

		static void method2() {
		}
	}

	// Class A의 instance method 선언
	void method() {
		/** 로컬 클래스 **/
		class D {
			// field 선언
			int field1;
			// static int field2;

			//	constructor
			D() {
				System.out.println("D 객체가 생성됨");
			}

			void method1() {
				System.out.println("local class field1 = " + field1);
			}
			// static void method2() {}
		}
		
		//	field 선언
		//	로컬 클래스의 인스턴스를 생성시, 반드시 
		//	로컬 클래스가 먼저 선언되어 있어야 함
		D d = new D();
		d.field1 = 3;
		d.method1();
	}
}
