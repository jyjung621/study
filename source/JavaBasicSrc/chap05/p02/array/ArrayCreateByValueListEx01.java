package p02.array;

public class ArrayCreateByValueListEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*********************************************** 
		 * 배열 변수에 초기값을 주는 방법은 {val1, val2, val3, ...}
		 * 배열은 초기값으로 원소 갯수가 정해진 상태에서 원소 갯수를 변경할 수 없음
		 * 원소값은 수정 가능함
		************************************************/
		int[] scores = {83, 90, 87};
		
		// 배열 시작원소의 index는 0부터 시작
		System.out.println("scores[0] : " + scores[0]);
		System.out.println("scores[1] : " + scores[1]);
		System.out.println("scores[2] : " + scores[2]);
		
		int sum = 0;
		for(int i=0; i<3; i++)
		{
			sum += scores[i];
		}
		System.out.println("총합 : " + sum);
		
		double avg = (double) sum / 3;
		System.out.println("평균 : " + avg);		
	}

}
