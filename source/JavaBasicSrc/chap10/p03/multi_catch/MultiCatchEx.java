package p03.multi_catch;

public class MultiCatchEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String data1 = args[0];
			String data2 = args[1];
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			System.out.println(data1 + " + " + data2 + " = " + result);
		//	1. multi-catch 작성시, 구체적인 Exception case를 먼저 작성할 것
		//		(마지막 catch에는 Exception(최상위 부모)으로 처리함)
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.out.println("실행 매개값의 수가 부족하거나 숫자로 변환할 수 없습니다.");
		} catch (Exception e) {
			System.out.println("알수 없는 예외 발생");
		} finally {
			System.out.println("다시 실행하세요.");
		}
	}

}
