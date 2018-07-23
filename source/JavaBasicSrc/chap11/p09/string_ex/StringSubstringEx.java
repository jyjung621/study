package p09.string_ex;

public class StringSubstringEx {
	public static void main(String[] args) {
		String ssn = "880815-1234567";
		
		//	substring(start, end) => start ~ (end-1)
		String firsNum = ssn.substring(0, 6);
		System.out.println(firsNum);
		
		//	substring(start) => start ~ 문자열 끝까지
		String secondNum = ssn.substring(7);
		System.out.println(secondNum);
		
	}
}
