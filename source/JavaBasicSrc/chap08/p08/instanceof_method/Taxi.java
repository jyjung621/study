package p08.instanceof_method;

public class Taxi implements Vehicle {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("택시가 달립니다.");
	}
	
	public void checkFare1()
	{
		System.out.println("택시 승차요금을 체크합니다.");
	}

}
