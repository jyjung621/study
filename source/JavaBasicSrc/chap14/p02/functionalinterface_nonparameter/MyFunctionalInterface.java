package p02.functionalinterface_nonparameter;

//	@FunctionalInterface 선언의 의미
//		- 이 Interface가 람다식을 적용하는 functional interface 라는 의미
//		- functional interface는 추상메소드가 하나만 있어야함
@FunctionalInterface
public interface MyFunctionalInterface {
	
	//	 abstract method
	public void method();
	//public void otherMethod();
}
