package ch05;

public class Car3 {
	String name;
	int inTime;
	int outTime;
	int fee;
	final int AMTPERTIME = 3000;
	
	Car3(String n, int inTime, int out) {
		name = n;
		this.inTime = inTime;
		outTime = out;
	}
	
	void print() {
		int fee = (outTime - inTime) * AMTPERTIME;
		System.out.println("�� �̸� : " + name);
		System.out.println("�԰�ð� : " + inTime);
		System.out.println("���ð� : " + outTime);
		System.out.println("������� : " + fee);
		System.out.println("----------------------------");
	}
}
