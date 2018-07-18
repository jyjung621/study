package p10.default_method.inheritance;

public interface ParentInterface {
	
	//	abstract method
	public void method1();
	
	//	default method
	public default void method2()
	{
		//	실행문
		System.out.println("Parent -- default method 선언");
	}
}
