package ch05;

class Sonata {
	Sonata() {
		System.out.println("�� �⺻ ");
	}
	Sonata(int a) {
		System.out.println("���� ���� : " + a);
	}
	Sonata(String str) {
		System.out.println("�ɼ� : " + str);
	}
}

public class ConstrEx1 {
	public static void main(String[] args) {
		Sonata s1 = new Sonata();
		Sonata s2 = new Sonata(4);
		Sonata s3 = new Sonata("�����");
	}

}
