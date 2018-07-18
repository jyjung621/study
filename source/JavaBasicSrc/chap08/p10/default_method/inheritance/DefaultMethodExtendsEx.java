package p10.default_method.inheritance;

public class DefaultMethodExtendsEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChildInterface1 ci1 = new ChildInterface1() {

			@Override
			public void method1() {
				System.out.println("ci1 - method1 실행");
			}

			@Override
			public void method3() {
				System.out.println("ci1 - method3 실행");
			}
		};
		
		ci1.method1();
		//	ParentInterface의 method2() 호출 (default method 실행)
		ci1.method2();
		ci1.method3();
		
		//-------------------------------------//
		
		ChildInterface2 ci2 = new ChildInterface2() {
			
			@Override
			public void method1() {
				System.out.println("ci2 - method1 실행");
			}
			
			@Override
			public void method3() {
				System.out.println("ci2 - method3 실행");
			}
		};
		
		ci2.method1();
		//	ChildInterface2의 method2() 호출
		ci2.method2();
		ci2.method3();
		
		//-------------------------------------//
		
		ChildInterface3 ci3 = new ChildInterface3() {
			
			@Override
			public void method1() {
				System.out.println("ci3 - method1 실행");
			}
			
			@Override
			public void method3() {
				System.out.println("ci3 - method3 실행");
			}
			
			@Override
			public void method2() {
				System.out.println("ci3 - method2 실행");
			}
		};
		
		ci3.method1();
		//	ChildInterface3 구현 객체의 method2()호출
		ci3.method2();
		ci3.method3();
	}

}
