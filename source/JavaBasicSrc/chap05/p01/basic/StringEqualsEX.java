package p01.basic;

public class StringEqualsEX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String strVar1 = "신민철";		// 동일한 객체 참조  str1, str2 메모리 주소값 동일
		String strVar2 = "신민철";		// ex) var1 = 364,  var2 = 364
		
		String name;	// name의 데이터가 바뀌면 메모리 주소값도 바뀜, 같은주소에서 데이터 변경되는거 아님
		name = "신용권";	// ex) 신용권 = 365,  홍길동 = 366
		name = "홍길동";
		
		if(strVar1 == strVar2)
			System.out.println("strVar1과 strVar2는 참조(주소)가 같음");
		else
			System.out.println("strVar1과 strVar2는 참조(주소)가 다름");
		
		// equals의미 : 두개 string의 값이 같은지 비교 => 값이 같으면 true
		if(strVar1.equals(strVar2))
			System.out.println("strVar1과 strVar2는 문자열이 같음");
		
		
		String strVar3 = new String("신민철");		// 새로운 객체를 각각 생성하는 것  
		String strVar4 = new String("신민철");		// str3, str4의 주소값은 다름  
												// ex) str3 = 367, str4 = 368
		if(strVar3 == strVar4)
			System.out.println("strVar3과 strVar4는 참조(주소)가 같음");
		else
			System.out.println("strVar3과 strVar4는 참조(주소)가 다름");
		
		if(strVar3.equals(strVar4))
			System.out.println("strVar3과 strVar4는 문자열이 같음");
	}

}
