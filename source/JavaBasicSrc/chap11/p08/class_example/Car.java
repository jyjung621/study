package p08.class_example;

public class Car {
	String company;
	String color;

	public Car() {}
	
	public Car(String company, String color) {
		super();
		this.company = company;
		this.color = color;
	}

	public void run() {
		System.out.println("차가 움직입니다.");
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
