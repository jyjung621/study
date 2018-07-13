package p05.final_class_method;

public class Car {
	
	//	field
	public int speed;
	
	//	method
	public void speedUp()
	{
		speed += 1;
	}
	
	//	final method
	public final void stop()
	{
		System.out.println("차를 멈춤");
		speed = 0;
	}
}
