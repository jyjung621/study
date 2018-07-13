package p16.constructor._access.pack1;

public class A {

	//	Field 선언
	A a1 = new A(true);		//	A에서 public생성자를 사용하여 인스턴스 생성가능
	A a2 = new A(1);		//	A에서 default생성자를 사용하여 인스턴스 생성가능
	A a3 = new A("문자열");	//	A에서 private생성자를 사용하여 인스턴스 생성가능
	
	//	Constructor
	
	//	1. public 생성자
	public A (boolean b)
	{
		
	}
	
	//	2. default 생성자
	A (int b)
	{
		
	}
	
	//	3. private 생성자
	private A (String s)
	{
		
	}
}
