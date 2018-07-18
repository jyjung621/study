package p10.default_method.basic;

public class DefaultMethodEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyInterface mi1 = new MyClassA();
		mi1.method1();
		mi1.method2();
		
		MyInterface mi2 = new MyClassB();
		mi2.method1();
		mi2.method2();
	}

}
