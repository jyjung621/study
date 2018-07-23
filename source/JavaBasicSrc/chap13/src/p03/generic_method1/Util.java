package p03.generic_method1;

public class Util {
	//	특정 메소드에 대해서만 generic type 사용하여 선언 가능
	//	generic type + return type + method_name(parameter)
	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<T>();	//	local 변수 선언
		box.set(t);
		
		return box;
	}
}
