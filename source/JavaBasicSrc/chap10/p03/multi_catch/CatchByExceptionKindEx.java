package p03.multi_catch;

public class CatchByExceptionKindEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			String data1 = args[0];
			String data2 = args[1];
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			System.out.println(data1 + " + " + data2 + " = " + result);
			/*****************************************************
			 * 	1. multi catch에서 첫번째 Exception에 대한 catch를, 
			 * 		수행하면 나머지 catch에 대해서는 실행하지 않고 skip함
			 * 	2. multi catch인 경우 catch순서가 중요함
			 *****************************************************/
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("실행 매개값의 수가 부족합니다.");
			System.out.println("[실행 방법]");
			System.out.println("java TryCatchFinallyRuntimeExceptionEx num1 num2");
			return;
		} catch (NumberFormatException e) {
			System.out.println("숫자로 변환할 수 없습니다.");
		} finally {
			System.out.println("다시 실행하세요.");
		}
	}

}
