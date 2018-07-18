package p10.default_method.inheritance;

public interface ChildInterface2 extends ParentInterface {
	
	//	ParentInterface의 default method를 override(재정의)
	@Override
	public default void method2()
	{
		//	실행문
		System.out.println("default method -- 재정의");
	}
	
	//	새로운 abstract method 선언
	public void method3();
}
