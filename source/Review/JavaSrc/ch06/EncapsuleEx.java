package ch06;

class H1 {
	private String name;
	private int age;

	
	public H1(String n, int a) {
		name = n;
		age = a;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age < 0) {
			System.out.println("���� �Է� ���� !!");
		} else {
			this.age = age;
		}
	}
}

public class EncapsuleEx {
	public static void main(String[] args) {
//		H1 h1 = new H1();
		H1 h1 = new H1("���ؼ�", -10);
//		h1.name = "���ؼ�";
		System.out.println("�̸� : " + h1.getName());
		System.out.println("���� : " + h1.getAge());
		h1.setName("���ؼ�");
		h1.setAge(-10);
		System.out.println("�̸� : " + h1.getName());
		System.out.println("���� : " + h1.getAge());
	}
}
