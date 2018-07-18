package p10.default_method.basic;

public class MyClassB implements MyInterface {

	//	method1 : abstract method
	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("myClassB-method1() 실행");
	}
	
	//	method2 : default method
	@Override
	public void method2()
	{
		System.out.println("MyClassB-method2() 실행");
	}

}
