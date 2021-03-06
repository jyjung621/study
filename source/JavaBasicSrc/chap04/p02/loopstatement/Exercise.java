package p02.loopstatement;

import java.util.Scanner;

public class Exercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		exercise03();
//		exercise04();
//		exercise05();
//		exercise06();
		exercise07();
	}
	
	public static void exercise03()
	{
		/********************************************
		 *  for문을 이용, 1~100까지 정수 중, 3의 배수의 총합을 구하라
		 *  output ==>  3의 배수의 합 : 1683
		 ********************************************/
		System.out.println("** 3번문제 **");
		
		int sum = 0;
		
		for(int i=1; i<=100; i++)
		{
			if((i%3) == 0)
				sum += i;
		}
		
		System.out.println("3의 배수의 합 : " + sum);
		
	}
	
	public static void exercise04()
	{
		/***********************************************************
		 *  while문과 Math.random() 메소드를 이용, 두 개의 주사위를 던졌을때 나오는 눈을 
		 *  (a, b) 형태로 출력하고, 두 눈의 합이 5가 아니면 계속 반복, 5이면 실행을 멈추게 하라
		 ***********************************************************/
		System.out.println("** 4번문제 **");
		
		int a, b;		// 주사위 a, b
		int sum = 0;	// 두 눈의 합
		
		while(true)
		{
			a = (int) (Math.random()*6) + 1;		// a 주사위
			b = (int) (Math.random()*6) + 1;		// b 주사위
			System.out.println("(" + a + ", " + b + ")");
			
			if ((a+b) == 5)		// 두 눈의 합이 5일경우, 반복 종료
				break;
		}
	}
	
	public static void exercise05()
	{
		/*******************************************
		 *  for문 중첩을 이용하여 4x + 5y = 60의 모든해를 구해서
		 *  (x, y) 형태로 출력하시오.  [ 단, x, y는 10 이하 자연수]
		 *******************************************/
		System.out.println("** 5번문제 **");
		
		int x, y;		// 방정식의 두 해
		
		for(x=0; x<=10; x++)	// x, y 10이하 자연수
		{
			for(y=0; y<=10; y++)
			{
				if((4*x + 5*y) == 60)	// 해가 맞을 경우, 출력
					System.out.println("(" + x + ", " + y + ")");
			}
		}
	}
	
	public static void exercise06()
	{
		/***********************************
		 *  star 출력하기
		 *  *
		 *  **
		 *  ***
		 *  ****
		 *  *****
		 *  ********************************/
		System.out.println("** 6번문제 **");
		
		for(int i=0; i<5; i++)
		{
			for(int j=0; j<=i; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void exercise07()
	{
		/************************************************************
		 * while문과 Scanner를 이용, 키보드로부터 입력된 데이터로 예금, 출금, 조회, 종료 기능을
		 * Control하는 프로그램을 작성하여라.
		 * ouput :  ... 미안하지만 책참조하자 (이것이자바다 chap04 p.136)
		 ************************************************************/
		System.out.println("** 7번문제 **");
		
		boolean run = true;
		int balance = 0;
		
		Scanner scanner = new Scanner(System.in);
		String inputString;
		
		while(run)
		{
			System.out.println("-------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-------------------------");
			System.out.println("선택 > ");
			
			inputString = scanner.nextLine();	// 입력 받아옮
			
			//System.out.println("scanner = " + inputString);
			switch(inputString)
			{
				case "1":
					System.out.println("예금액> ");
					// 입력 받은 값을 가져옮
					inputString = scanner.nextLine();
					// String -> int 변환하여 balance에 연산함
					balance += Integer.parseInt(inputString);
					break;
				case "2":
					System.out.println("출금액> ");
					inputString = scanner.nextLine();
					balance -= Integer.parseInt(inputString);
					break;
				case "3":
					System.out.println("잔고> " + balance);
					break;
				case "4":
					run = false;
					break;
				default:
					break;
			}
		}
		System.out.println("프로그램 종료");
	}
	
}
