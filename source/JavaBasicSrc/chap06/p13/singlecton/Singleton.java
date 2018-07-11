package p13.singlecton;

public class Singleton {
	/******************************************************
	 * 	singleton 변수 : static, singleton() 객체 주소를 가지고 있음
	 * 	private ??? => 접근 제한자
	 * 		--> 다른 class에서 이 변수를 사용 못함
	 *			(singleton 객체에서만 사용가능!) 
	 *****************************************************/
	private static Singleton singleton = new Singleton();
	
	private Singleton() {}
		
	public static Singleton getInstance()
	{
		return singleton;
	}
}
