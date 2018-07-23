package p14.wrapper;

public class BoxingUnBoxingEx {
	public static void main(String[] args) {
		//	Boxing(primitive data type ==> class type(wrapper)으로 변환)
		Integer obj1 = new Integer(100);
		Integer obj2 = new Integer("200");
		Integer obj3 = Integer.valueOf("300");
		
		//	UnBoxing (Wrapper => primitive data type변환)
		int value1 = obj1.intValue();
		int value2 = obj2.intValue();
		int value3 = obj3.intValue();
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
	}
}
