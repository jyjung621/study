package p01.basic;

public class Lambda_Test1 {
	public static void main(String[] args) {
		//	Interface 구현 객체
		MyInterfaceObject mo = new MyInterfaceObject();
		mo.sayHello();
		
		//	익명 구현 객체 : Interface, Class 둘다 사용 가능
		MyInterface mi = new MyInterface() {
			
			@Override
			public void sayHello() {
				System.out.println("Hello 111");
			}
		};
		mi.sayHello();
		
		//	3. Lambda Expression : Interface 익명구현객체 표현
		//		- 익명구현객체의 또 다른 표현으로, 익명구현객체 코딩 양을 줄여주는 효과
		//		- 익명구현객체에서 interface만 가능 (class와 무관)
		//		- Interface의 추상메소드가 반드시 1개여야만 함
		//		- mi3 :	(람다식을 실행한 결과는) 익명구현객체  
		MyInterface mi3 = () -> { System.out.println("Hello lambda"); };
		mi3.sayHello();
	}
}
