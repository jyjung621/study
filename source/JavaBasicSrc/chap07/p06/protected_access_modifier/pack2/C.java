package p06.protected_access_modifier.pack2;

import p06.protected_access_modifier.pack1.A;

public class C {
	public void method() {

		/*******************************************************
		 * 	다른 package에 선언된 class의 protected constructor, 생성자,
		 * 	field, method를 호출 불가
		 *******************************************************/
//		A a = new A();
//		a.field = "value";
//		a.method();

	}
}
