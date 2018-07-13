package p07.polymorphism.basic_override;

public class SecondChild extends Parent {
	
	@Override
	public void method2() {
		System.out.println("SecondChild-method2()");
	}
	
	public void method4()
	{
		System.out.println("SecondChild-method4()");
	}
}
