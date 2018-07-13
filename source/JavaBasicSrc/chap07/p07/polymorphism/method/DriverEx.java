package p07.polymorphism.method;

public class DriverEx {

	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		// drive method에 bus 자식객체를 Vehicle 부모타입으로 자동형변환
		driver.drive(bus);
		// drive method에 taxi 자식객체를 Vehicle 부모타입으로 자동형변환
		driver.drive(taxi);
	}

}
