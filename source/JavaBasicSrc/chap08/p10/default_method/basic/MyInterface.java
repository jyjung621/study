package p10.default_method.basic;

public interface MyInterface {
	
	//	Abstract method
	public void method1();
	
	//	Default method
	public default void method2()
	{
		System.out.println("MyInterface-method2 실행");
	}
}
