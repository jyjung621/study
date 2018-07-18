package p10.default_method.inheritance;

public interface ChildInterface3 extends ParentInterface {

	@Override
	//	ParentInterface의 default method를 abstract method로 재선언
	public void method2();	//	추상 메소드로 재선언
	
	//	새로운 abstract method
	public void method3();
}
