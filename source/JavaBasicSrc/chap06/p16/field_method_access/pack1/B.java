package p16.field_method_access.pack1;

public class B {

	//	생성자
	public B()
	{
		A a = new A();
		a.field1 = 1;
		a.field2 = 1;
		//	A class의 field3가 private선언되어 사용불가
		//a.field3 = 1;
		
		a.method1();
		a.method2();
		//	A class의 method3가 private선언되어 사용불가
		//a.method3();
		
		
	}
}
