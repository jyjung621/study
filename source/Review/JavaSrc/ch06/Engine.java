package ch06;

public class Engine {
	String type;
	int cc;

	public Engine(String type, int cc) {
		super();
		this.type = type;
		this.cc = cc;
	}

	void print() {
		System.out.println("Ÿ�� : " + type);
		System.out.println("��ⷮ : " + cc);
	}
}
