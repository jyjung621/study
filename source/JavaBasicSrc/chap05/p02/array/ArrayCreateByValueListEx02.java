package p02.array;

public class ArrayCreateByValueListEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 배열 선언이후, 객체 생성하여 배열 초기화 
		int[] scores;
		scores = new int[] {83, 90, 87};
		
		int sum1 = 0;
		for(int i=0; i<3; i++)
		{
			sum1 += scores[i];
		}
		System.out.println("총합 : " + sum1);
		
		// add() 메소드 생성 후, 객체를 새로 만들어서 초기화하여 바로 넘겨줌
		int sum2 = add(new int[] {83, 90, 87});
		System.out.println("총합 : " + sum2);
		System.out.println();
	}

	private static int add(int[] scores) {
		// TODO Auto-generated method stub
		
		int sum = 0;
		for(int i=0; i<3; i++)
		{
			sum += scores[i];
		}
		
		return sum;
	}

}
