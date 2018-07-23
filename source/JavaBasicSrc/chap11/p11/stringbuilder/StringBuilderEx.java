package p11.stringbuilder;

public class StringBuilderEx {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		//	append() :  문자열 끝에 붙이는 메소드
		sb.append("Java ");
		sb.append("Program Study");
		System.out.println(sb.toString());
		
		//	insert() : 문자열 중간에 삽입하는 메소드
		sb.insert(4, "2");
		System.out.println(sb.toString());
		
		sb.setCharAt(4, '6');
		System.out.println(sb.toString());
		
		sb.replace(6, 13, "Book");
		System.out.println(sb.toString());
		
		sb.delete(4, 5);
		System.out.println(sb.toString());
		
		int length = sb.length();
		System.out.println("총문자수 : " + length);
		
		String result = sb.toString();
		System.out.println(result);
	}
}
