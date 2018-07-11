package p05.method_basic;

public class Computer {
	
	int sum1(int[] values)
	{
		int sum = 0;
		for(int i=0; i<values.length; i++)
		{
			sum += values[i];
		}
		
		return sum;
	}
	
	// ... 으로 받으면  데이터 타입의 배열로 인식하여 처리함
	int sum2(int ... values)
	{
		int sum = 0;
		for(int i=0; i<values.length; i++)
		{
			sum += values[i];
		}
		
		return sum;
	}
}
