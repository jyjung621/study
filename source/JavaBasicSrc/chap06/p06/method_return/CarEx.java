package p06.method_return;

public class CarEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car myCar = new Car();
		
		System.out.println("setGas method 호출 전");
		myCar.setGas(5);
		System.out.println("setGas method 호출 후");
		
		// CarEx class에서 다른 class인 Car의 메소드를 호출할려면
		// 기본적으로 new를 통해 인스턴스 생성을 해줘야함
		boolean gasState = myCar.isLeftGas();
		if(gasState)
		{
			System.out.println("출발합니다.");
			myCar.run();
		}

		if(myCar.isLeftGas())
		{
			System.out.println("gas를 주입할 필요가 없습니다.");
		}
		else
		{
			System.out.println("가스를 주입하세요");
		}
	}
}
