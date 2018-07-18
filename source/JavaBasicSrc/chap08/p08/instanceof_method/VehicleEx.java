package p08.instanceof_method;

public class VehicleEx {
	public static void main(String[] args) {
		
		Vehicle vehicle = new Bus();
		Vehicle vehicle1 = new Taxi();
		
		vehicle.run();
		vehicle1.run();
		//	Vehicle 인터페이스에는 checkFare()가 없음
		//vehicle.checkFare();
		
		//	강제 타입 변환
		Bus bus = (Bus) vehicle;
		
		bus.run();
		//	Bus클래스에는 checkFare가 있음
		bus.checkFare();
		System.out.println();
		
		Taxi taxi = (Taxi) vehicle1;
		taxi.run();
		taxi.checkFare1();
		System.out.println();
		
		Driver driver = new Driver();
		driver.drive(vehicle);
		driver.drive(bus);
		System.out.println();
		driver.drive(vehicle1);
		driver.drive(taxi);
		
	}
}
