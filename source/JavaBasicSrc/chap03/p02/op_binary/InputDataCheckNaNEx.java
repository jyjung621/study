package p02.op_binary;

public class InputDataCheckNaNEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String userInput = "NaN";
		double val = Double.valueOf(userInput);
		
		double currentBalance = 10000.0;
		
		// NaN check logic
		if(Double.isNaN(val))
		{
			System.out.println("NaN이 입력되어 처리할 수 없음");
			val = 0.0;	// NaN이면 입력값을 0.0으로 초기화 처리함
		}
		
		currentBalance += val;
		System.out.println(currentBalance);
	}

}
