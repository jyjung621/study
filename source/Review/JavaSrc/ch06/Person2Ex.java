package ch06;

public class Person2Ex {
	public static void main(String[] args) {
		Person2[] ps = new Person2[5];
		ps[0] = new Student2("옥주현", 23, "1203667");
		ps[1] = new Student2("김유신", 53, "1386889");
		ps[2] = new Teacher2("대조영", 48, "Java");
		ps[3] = new Student2("김소현", 28, "청소");
		ps[4] = new Student2("전현무", 40, "비데");
		
		for(Person2 p : ps) {
			p.print();
			if(p instanceof Manager2) {
//				Manager2 m = (Manager2) p;
//				System.out.println("추가 : " + m.getPart());
				System.out.println("2번째 방법 : " + ((Manager2)p).getPart());
			}
		}
	}
}
