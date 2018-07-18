package p01.exception_basic;

public class NullPointerExceptionEx {
		public static void main(String[] args) {
			
			//	data에 null 주소를 지정
			String data = null;
			
			//System.out.println(data);	//	실행한 것과 동일
			//	println으로 출력하면 NullPointerException 발생
			System.out.println(data.toString());
		}

} 
