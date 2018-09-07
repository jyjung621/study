package ch06;

class StaticM {
	int num = 0;
	
	void display() {
		num++;
		System.out.println("zzz num->" + num);
	}
	
	static void print(String str) {
//		num++;
		System.out.println("대박 금요일 " + str);
	}
}

public class StaticMethod {
	public static void main(String[] args) {
		StaticM.print("인스턴스 전");
		StaticM sm = new StaticM();
		
		sm.display();
		sm.display();
		sm.display();
		sm.print("인스턴스 후");
	}
}
