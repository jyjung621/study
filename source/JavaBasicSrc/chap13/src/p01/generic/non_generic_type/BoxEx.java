package p01.generic.non_generic_type;

public class BoxEx {
	public static void main(String[] args) {
		Box box = new Box();
		//	String -> Object (자동 타입 변환)
		box.setObject("홍길동");
		//	Object -> String (강제 타입 변환)
		String name = (String) box.getObject();
		
		//	Apple -> Object (자동 타입 변환)
		box.setObject(new Apple());
		//	Object -> Apple (강제 타입 변환)
		Apple apple = (Apple) box.getObject();
	}
}
