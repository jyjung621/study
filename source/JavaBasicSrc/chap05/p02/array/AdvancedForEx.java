package p02.array;

public class AdvancedForEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] scores = {95, 71, 84, 93, 87};
		int sum = 0;
		
		// 전통적인 for문을 사용한 합계 계산 방식
		for(int i=0; i<scores.length; i++)
		{
			sum += scores[i];
		}
		System.out.println("점수 총합(Old) = " + sum);
		
		
		sum = 0;
		/*******************************************************
		 *  향상된 for문을 사용한 방식 ( JAVA 5부터 시행됨)  [초기화x, 길이x, 증감식x]
		 *  선언된 scores 배열에서 변수를 하나씩 꺼내와서 전달
		 *  배열 마지막까지 계속 반복하고 끝냄
		 *******************************************************/
		for(int score : scores)		
		{							
			sum += score;
		}
		System.out.println("점수 총합(New) = " + sum);
		
	}

}
