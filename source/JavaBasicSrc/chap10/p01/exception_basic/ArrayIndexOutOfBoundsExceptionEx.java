package p01.exception_basic;

public class ArrayIndexOutOfBoundsExceptionEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length == 2)
		{
			String data1 = args[0];
			String data2 = args[1];
		
			System.out.println("args[0] : " + data1);
			System.out.println("args[1] : " + data2);
		}
		else
		{
			System.out.println("실행 방법");
			System.out.println("java ArrayIndexOutOfBoundException");
			System.out.println("값1 값2");
		}
			
	}

}
