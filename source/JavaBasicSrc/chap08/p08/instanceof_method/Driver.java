package p08.instanceof_method;

public class Driver {
	public void drive(Vehicle vehicle)
	{
		if(vehicle instanceof Bus)
		{
			Bus bus = (Bus) vehicle;
			bus.checkFare();
		}
		else if(vehicle instanceof Taxi)
		{
			Taxi taxi = (Taxi) vehicle;
			taxi.checkFare1();
		}
		
		vehicle.run();
	}
}
