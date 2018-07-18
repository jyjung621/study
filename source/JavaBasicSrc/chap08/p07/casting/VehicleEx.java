package p07.casting;

public class VehicleEx {
	public static void main(String[] args) {
		
		Vehicle vehicle = new Bus();
		
		vehicle.run();
		//	Vehicle 인터페이스에는 checkFare()가 없음
		//vehicle.checkFare();
		
		//	강제 타입 변환
		Bus bus = (Bus) vehicle;
		
		bus.run();
		//	Bus클래스에는 checkFare가 있음
		bus.checkFare();
	}
}
