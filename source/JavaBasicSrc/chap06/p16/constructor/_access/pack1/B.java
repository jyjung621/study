package p16.constructor._access.pack1;

public class B {

	//	Field 선언
	A a1 = new A(true);
	A a2 = new A(1);
	
	//	A의 문자열 생성자는 private으로 선언되어 있어 다른 class에서
	// 	생성자 사용 불가
	//A a3 = new A("문자열");
}
