package p01.basic;

public class Lambda_Test2 {
	public static void main(String[] args) {
		//	1. 익명 구현 객체
		MyInterface2 mi = new MyInterface2() {
			
			@Override
			public void calculate(int x, int y) {
				System.out.println("result = " + (x*y));
			}
		};
		mi.calculate(20, 30);
		
		//	2. Lambda Expression
		MyInterface2 mi2 = (x,y) -> { System.out.println("result(lambda) = " + (x*y)); };
		mi2.calculate(5, 8);
		
	}
}
