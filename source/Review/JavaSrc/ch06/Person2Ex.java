package ch06;

public class Person2Ex {
	public static void main(String[] args) {
		Person2[] ps = new Person2[5];
		ps[0] = new Student2("������", 23, "1203667");
		ps[1] = new Student2("������", 53, "1386889");
		ps[2] = new Teacher2("������", 48, "Java");
		ps[3] = new Student2("�����", 28, "û��");
		ps[4] = new Student2("������", 40, "��");
		
		for(Person2 p : ps) {
			p.print();
			if(p instanceof Manager2) {
//				Manager2 m = (Manager2) p;
//				System.out.println("�߰� : " + m.getPart());
				System.out.println("2��° ��� : " + ((Manager2)p).getPart());
			}
		}
	}
}
