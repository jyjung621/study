package p16.field_method_access.pack1;

public class A {

	//	field 선언
	public int field1;	//	public 접근 제한자
	int field2;			//	default 접근 제한자
	private int field3;	
	
	
	//	생성자
	public A()
	{
		field1 = 1;
		field2 = 1;
		field3 = 1;
		
		method1();
		method2();
		method3();
	}
	
	//	method
	public void method1() {}	//	public 접근 제한자
			
	void method2() {}			//	default 접근 제한자
	
	private void method3() {}	//	private 접근 제한자
}
