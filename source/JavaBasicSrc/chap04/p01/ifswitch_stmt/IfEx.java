package p01.ifswitch_stmt;

public class IfEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int score = 85;
		
		if(score >= 90)
		{
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A 입니다.");
		}
		
		if(score < 90)		// {}(중괄호로 묶지 않으면 한줄 의도치 않은 실행이 발생
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B 입니다.");
		
	}

}
