package p06.method_return;

public class Car {
	// Field
	int gas;
	
	// 생성자
	
	// 메소드
	
	void setGas(int gas)
	{
		this.gas = gas;
		A();
	}
	
	boolean isLeftGas()
	{
		if(gas == 0)
		{
			System.out.println("gas가 없습니다.");
			return false;
		}
		
		System.out.println("gas가 있습니다.");
		return true;
	}
	
	void run()
	{
		while(true)
		{
			if(gas > 0)
			{
				System.out.println("달립니다.(gas잔량 : " + gas + ")");
				gas -= 1;
			}
			else
			{
				System.out.println("멈춥니다.(gas잔량 : " + gas + ")");
				return;
			}
		}
	}
	
	void A()
	{
		System.out.println("A method 호출");
		// 하나의 class내의 한 메소드에서 다른 모소드를 호출할 경우에는
		// new를 통해 하지 않고, 직접 메소드를 호출할 수 있음
		B();
	}
	void B()
	{
		System.out.println("B method 호출");
	}
	void C()
	{
		System.out.println("C method 호출");
	}
}
