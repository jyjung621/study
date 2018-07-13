package p03.method_override;

public class ComputerEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int r = 10;

		Calculator calculator = new Calculator();
		System.out.println("원면적 : " + calculator.areaCircle(r));
		System.out.println();
		
		/*********************************************
		 * 	computer.areaCircle은 부모클래스의 메소드가 아니라
		 * 	자식 클래스 재정의(override)된 메소드를 실행함
		 *********************************************/
		Computer computer = new Computer();
		System.out.println("원면적 : " + computer.areaCircle(r));
	}

}
