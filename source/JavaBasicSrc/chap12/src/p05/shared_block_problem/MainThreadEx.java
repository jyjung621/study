package p05.shared_block_problem;

public class MainThreadEx {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		
		User1 user1 = new User1();
		user1.setCalculator(calculator);
		//	start method를 호출하면 User1 class의 run 메소드 실행
		user1.start();

		User2 user2 = new User2();
		user2.setCalculator(calculator);
		user2.start();
	}
}
