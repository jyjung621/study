package p17.getter_setter;

public class CarEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car myCar = new Car();
		
		/*
		 * 	문법은 맞지만, 실제 코딩 내용은 틀림
		 * 	==> 자동차의 speed가 음수가 될 수 없음
		 * 
		 * 	Car를 사용하는 사용자가 올바르지 않은 field값을 설정할 수 있는 문제 발생
		 */
		myCar.setSpeed(-100);
		//myCar.speed = -100;
	}

}
