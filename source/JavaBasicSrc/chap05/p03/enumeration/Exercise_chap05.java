package p03.enumeration;

import java.util.Scanner;

public class Exercise_chap05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//exercise07();
		//exercise08();
		exercise09();

	}
	
	public static void exercise07()
	{
		/****************************************
		 *  주어진 배열의 항목에서 최대값을 구하라(for문 이용)
		 *  출력 ->  max : 8
		 ****************************************/
		int max = 0;
		int[] array = {1,5,3,8,2};
		
		for(int tmp : array)	// 각 배열 값을 max값과 비교하여 크다면 max변수에 넣음
		{
			if(tmp > max)
				max = tmp;
		}
		
		System.out.println("max : " + max);
	}
	

	public static void exercise08()
	{
		/***********************************************
		 *  주어진 배열의 전체 항목의 합과 평균값을 구하라(중첩 for문 이용)
		 *  출력 : sum : 881
		 *  	 avg : 88.1
		 ***********************************************/
		int[][] array = {	// 2차원 배열
				{95,86},
				{83,92,96},
				{78,83,93,87,88}
		};
		
		int sum = 0;
		double avg = 0.0;
		int cnt = 0;	// 배열의 전체 갯수 파악을 위한 변수
		
		/*********************************************************
		 *  향상된 for문 2차원배열 사용방법
		 *  array[raw][col]
		 *  raw에 대한 임시 배열을 for문으로 만든뒤, col에 대하여 중첩 for문으로 실행
		 *  ps.말이 이상한대... 그냥 code 보고 이해하자!
		 *********************************************************/		
		for(int[] tmp : array)
		{
			for(int tmp1 : tmp)
			{
				sum += tmp1;	// 총합 구하기
				cnt++;			// 전체 배열 갯수 check
			}
		}
		avg = (double) sum / cnt;
		
		System.out.println("sum : " + sum);
		System.out.println("avg : " + avg);
	}
	
	
	public static void exercise09()
	{
		/**********************************************************
		 *  키보드로부터 각 학생수와 각 학생들의 점수를 입력받아, 최고점수 및 평균점수를 구하라
		 *  ps. 책보고 하자....(이것이 자바다 chap05 p.183)
		 **********************************************************/
		boolean run = true;		// 각 변수에 대해서 초기화
		int studentNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);	// 키보드 입력 객체 생성
		
		while(run)
		{
			System.out.println("-------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("-------------------------------------------");
			System.out.print("선택> ");
			
			// scanner.nextInt() -> 키보드로 정수를 입력받는 메소드
			int selectNo = scanner.nextInt();
			
			if(selectNo == 1)
			{
				System.out.print("학생수> ");
				selectNo = scanner.nextInt();	// 학생수 입력 받음
				studentNum += selectNo;			// studentNum으로 넘겨줌
				scores = new int[studentNum];	// 학생 수 만큼 scores배열 생성
			}
			else if(selectNo == 2)
			{
				for(int i=0; i<studentNum; i++)
				{
					System.out.print("scores[" + i + "]> ");
					scores[i] = scanner.nextInt();	// 각 학생별 점수 입력 받음
				}
			}
			else if(selectNo == 3)
			{
				// 전체 학생들 점수 출력
				for(int i=0; i<studentNum; i++)
				{
					System.out.println("scores[" + i + "]> " + scores[i]);
				}
			}
			else if(selectNo == 4)
			{
				int max = 0;		// 최대값 
				int sum = 0;		// 총합
				double avg = 0.0;	// 평균
				
				for(int tmp : scores)	// 생성된 배열의 전체 for문
				{
					sum += tmp;			// 총합구하기
					if(tmp > max)		// 최대값 구하기 (두 값을 비교하여 max보다 크면 대입)
						max = tmp;		
				}
				avg = (double) sum / studentNum;
				
				System.out.println("최고 점수 : " + max);
				System.out.println("평균 점수 : " + avg);
			}
			else if(selectNo == 5)
			{
				run = false;
			}
		}
	
		System.out.println("프로그램 종료");
	}
}
