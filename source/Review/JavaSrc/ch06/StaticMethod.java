package ch06;

class StaticM {
	int num = 0;
	
	void display() {
		num++;
		System.out.println("zzz num->" + num);
	}
	
	static void print(String str) {
//		num++;
		System.out.println("��� �ݿ��� " + str);
	}
}

public class StaticMethod {
	public static void main(String[] args) {
		StaticM.print("�ν��Ͻ� ��");
		StaticM sm = new StaticM();
		
		sm.display();
		sm.display();
		sm.display();
		sm.print("�ν��Ͻ� ��");
	}
}
