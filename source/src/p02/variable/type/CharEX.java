package p02.variable.type;

public class CharEX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char c1 = 'A';		// 문자 A를 변수에 직접 저장하는 방식
		char c2 = 65;		// 문자 A를 변수에 10진수로 저장하는 방식
		char c3 = '\u0041';	// 문자 A를 변수에 16진수로 저장하는 방식
		
		char c4 = '가';		// 문자 '가'를 변수에 직접 저장하는 방식
		char c5 = 44032;	// 문자 '가'를 10진수로 저장하는 방식
		char c6 = '\uac00';	// 문자 '가'를 16진수로 저장하는 방식
		
		int uniCode = c1; 	// c1의 unicode값을 할당
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
		System.out.println(uniCode);
		
	}

}
