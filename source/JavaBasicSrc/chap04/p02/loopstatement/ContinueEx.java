package p02.loopstatement;

public class ContinueEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=1; i<=10; i++)
		{
			if((i%2) != 0)	// 홀수일 경우 다시 돌아감
			{
				continue;
			}
			System.out.println(i);	// 짝수만 출력됨
		}
	}

}
