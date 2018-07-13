package p06.protected_access_modifier.pack2;

import p06.protected_access_modifier.pack1.A;

/*
 * 	D는 다른 package에 있는 A의 자식 클래스
 */
public class D extends A {

	// D(자식)의 생성자
	public D() {
		super(); // A(부모)의 생성자 호출
		this.field = "value";
		this.method();

	}
}
