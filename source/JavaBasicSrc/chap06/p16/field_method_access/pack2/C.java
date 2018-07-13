package p16.field_method_access.pack2;

import p16.field_method_access.pack1.A;

public class C {

	//	생성자
	public C()
	{
		A a = new A();
		
		a.field1 = 1;
		//	A class의 filed2가 default선언되어 있어서 사용불가
		//a.field2 = 2;
		//	A class의 filed3가 private선언되어 있어서 사용불가
		//a.field3 = 1;
		
		a.method1();
		//	A class의 method2,3가 default,private선언되어 있어서 사용불가		
		//a.method2();
		//a.method3();
	}
}
