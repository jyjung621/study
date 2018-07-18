package p01.exception_basic;

public class NumberFormatExceptionEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String data1 = "100";
		String data2 = "a100";
		
		//	parseInt 메소드 : String을 입력으로 받아, int(숫자)로 변환
		int value1 = Integer.parseInt(data1);
		//	data2가  "a100"인데, 숫자로 변환할 수 없어
		//	parseInt method 실행중에 NumberFormatException 발생
		int value2 = Integer.parseInt(data2);
		System.out.println("value1 = " + value1);
		System.out.println("value2 = " + value2);

		int result = value1 + value2;
		System.out.println(data1 + " + " + data2 + " = " + result); 
		
	}

}
