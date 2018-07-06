package p02.loopstatement;

public class ForSumEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum = 0;
		
		for(int i=1; i<=100; i++)
		{
			sum += i;
		}
		
		System.out.println("1~100 합 : " + sum);
	}

}
