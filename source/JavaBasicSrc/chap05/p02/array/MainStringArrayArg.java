package p02.array;

public class MainStringArrayArg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length != 2)	// 변수의 갯수가 2가 아니면 error
		{
			System.out.println("프로그램 사용법");
			System.out.println("java MainStringArrayArgument num1 num2");
			System.exit(0);
		}
		
		// strNum1 에는 args[0]가 가리키는 객체의 주소값이 들어옴
		String strNum1 = args[0];
		String strNum2 = args[1];
		
		// Integer.parseInt  ->  strNum1(String) -> num1(int) 변환하는 메소드
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		
		int result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);
	}

}
