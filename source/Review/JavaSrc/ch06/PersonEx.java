package ch06;

public class PersonEx {
	public static void main(String[] args) {
		Student st1 = new Student();
		st1.setName("����");
		st1.setAge(21);
		st1.setSno("1111");
		
		Teacher th1 = new Teacher();
		th1.setName("�浿");
		th1.setAge(35);
		th1.setSubject("Java");
		
		Manager mg1 = new Manager();
		mg1.setName("����");
		mg1.setAge(19);
		mg1.setPart("û��");
		
		st1.printAll();
		System.out.println("�̸� " + st1.getName() + " , ���� " + st1.getAge() + " , �й� " + st1.getSno());
		
		th1.printAll();
		mg1.printAll();
	}
}
