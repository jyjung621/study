package p02.array;

public class ArrayLengthEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] scores = {83, 90, 87};
		int sum = 0;
		
		for(int i=0; i<scores.length; i++)	// scores.length -> 배열의 길이 반환
		{
			sum += scores[i];
		}
		System.out.println("총합 : " +sum);
		
		double avg = (double) sum / scores.length;
		System.out.println("평균 " + avg);
	}

}
