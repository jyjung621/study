package p03.object_toString;

import java.util.Date;

import org.omg.CORBA.DATA_CONVERSION;

public class ToStringEx {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Date obj2 = new Date();
		String str = "홍길동";
		
		//	obj1은 Object class
		System.out.println(obj1);
		//	Date class에서 toString을 override한 결과를 println에서 출력함
		System.out.println(obj2);
		//	String class에서 toString메소드를 override
		System.out.println(str);
		System.out.println();
		
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		
	}
}
