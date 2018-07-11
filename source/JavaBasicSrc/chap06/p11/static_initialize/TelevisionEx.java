package p11.static_initialize;

public class TelevisionEx {
	
	//	main은 자바시스템에서 자동적으로 main method를 호출
	//	이때 instance생성하지 ㅇ낳은 상태에서 main method 호출
	public static void main(String[] args) {
		System.out.println(Television.info);
		
		// static인 main method에서 instance method 호출 불가
		//hello();
		//	해결방법 1:  본인 클래스 내에서 본인 인스턴스를 만들어서 사용
		TelevisionEx tv1 = new TelevisionEx();
		tv1.hello();
		//	해결방법 2: hello를 static method로 변경
		// hello();
	}
	
	public void hello()
	{
		System.out.println("Hello, ....");
	}
	/*	해결방법 2:
	public static void hello()
	{
		System.out.println("Hello, ....");
	}*/
}
