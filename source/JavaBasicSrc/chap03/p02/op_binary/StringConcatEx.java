package p02.op_binary;

public class StringConcatEx {	// Concatenation (합침)
					
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/****************************************
		 *  String + 숫자  => 숫자를 String으로 변환
		 *  String에서 '+' 의미  ==> 문자열을 합쳐준다는 의미
		 ****************************************/
		String str1 = "JDK" + 6.0;
		String str2 = str1 + " 특징";
		System.out.println(str2);		// 출력 : "JDK6.0 특징"
		
		
		String str3 = "JDK" + 3 + 3.0;	// 1) "JDK" + 3   2) "JDK3" + 3.0
		String str4 = 3 + 3.0 + "JDK";	// 1) 3 + 3.0	  2) 6.0 + "JDK"
		System.out.println(str3);		// 출력 : "JDK33.0"
		System.out.println(str4);		// 출력 : "6.0JDK"
	}

}
