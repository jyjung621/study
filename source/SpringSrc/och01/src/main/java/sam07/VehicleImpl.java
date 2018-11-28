package sam07;

public class VehicleImpl implements Vehicle {
	private String name;
	private String rider;
	private int speed;

	public VehicleImpl(String name) {
		this.name = name;
	}

//	public void setName(String name) {
//		this.name = name;
//	}

	public void setRider(String rider) {
		this.rider = rider;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public void ride() {
		System.out.println(name + "님은(는)" + rider + "을 이용 " + speed + "km 속도로 탄다.");

	}

}
