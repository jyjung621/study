package p11.static_initialize;

public class Television {
	static String company = "Samsun";
	static String model = "LCD";
	static String info;
	
	int field1;
	static int field2;
	
	
	/***********************************
	 *  main 메소드가 처음 실행될대 자동적으로 불려짐
	 *  (new로 통해서 불려지는 것 x)
	 ***********************************/
	static 
	{
		info = company + "-" + model;
		//field1 = 10;	// instance field를 static block에서 사용불가
		//method1();	// instance method를 static block에서 사용불가
		field2 = 10;
		method2();
	}
	
	void method1()
	{
		
	}
	
	static void method2()
	{
		//method1();	// static method에서 instance method 사용 불가
	}
	
	// instance에서 불려질 때 사용됨
	{
		System.out.println("instance block 사용");
		field1 = 10;
		method1();
		field2 = 20;
		method2();
	}
}
