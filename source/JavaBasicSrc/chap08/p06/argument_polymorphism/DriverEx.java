package p06.argument_polymorphism;

public class DriverEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		driver.drive(bus);
		driver.drive(taxi);
		
	}

}
