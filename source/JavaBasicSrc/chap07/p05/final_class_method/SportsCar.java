package p05.final_class_method;

public class SportsCar extends Car {

	@Override
	public void speedUp() {
		speed += 10;
		
	}
	/*
	 * 	부모의 method를 final로 선언하면 
	 * 	자식 클래스에서 override 못함
	 */
//	public void stop()
//	{
//		
//	}
}
