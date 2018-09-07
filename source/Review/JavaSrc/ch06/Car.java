package ch06;

public class Car {
	String kind;
	Engine eg;

	public Car(String kind, Engine eg) {
		super();
		this.kind = kind;
		this.eg = eg;
	}

	void print() {
		System.out.println("증류 : " + kind);
		eg.print();
		System.out.println("=========================");
	}

	public static void main(String[] args) {
		Engine eg1 = new Engine("알파엔진", 2000);
		Engine eg2 = new Engine("베타엔진", 3000);

//		Car c1 = new Car("소나타", eg1);
//		c1.print();
//		Car c2 = new Car("모닝", eg1);
//		c2.print();
//		Car c3 = new Car("벤츠", eg2);
//		c3.print();
//		

		Car[] c = new Car[3];
		c[0] = new Car("소나타", eg1);
		c[1] = new Car("모닝", eg1);
		c[2] = new Car("벤츠", eg2);

		for (Car c1 : c) {
			c1.print();
		}
	}
}
