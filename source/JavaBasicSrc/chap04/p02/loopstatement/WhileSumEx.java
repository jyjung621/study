package p02.loopstatement;

public class WhileSumEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum = 0;
		int i = 1;
		
		while(i<=100)
		{
			sum += 1;
			i++;
		}
		
		System.out.println("1~" + (i-1) + " 합 : " + sum);
	}

}
