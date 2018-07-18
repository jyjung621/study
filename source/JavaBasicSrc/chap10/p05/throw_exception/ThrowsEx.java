package p05.throw_exception;

public class ThrowsEx {
	public static void main(String[] args) {
		try {
			findClass();
		} catch (ClassNotFoundException e) {
			System.out.println("클래스가 존재하지 않습니다.");
		}
	}
	
	/*******************************************************************
	 * 	throws Exception ==> method내에서 exception 처리하는 것이 아니라,
	 * 		이 메소드를 부른 original method에 Exception 처리를 떠 넘길 경우 사용함
	 *******************************************************************/
	public static void findClass() throws ClassNotFoundException {
		Class clazz = Class.forName("java.lang.String2");
	}
}
