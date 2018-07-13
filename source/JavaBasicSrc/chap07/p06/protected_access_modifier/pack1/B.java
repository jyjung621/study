package p06.protected_access_modifier.pack1;

public class B {

	public void method() {
		
		A a = new A();		//	A의 protected로 선언된 생성자를 호출 (ok)
		a.field = "value";	//	A의 protected로 선언된 field 변수값을 변경 (ok)
		a.method();			// 	A의 protected로 선언된 method를 호출 (ok)
	}
}
