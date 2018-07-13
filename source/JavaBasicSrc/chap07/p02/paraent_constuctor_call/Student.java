package p02.paraent_constuctor_call;

public class Student extends People {

	public int studentNo;

	public Student(String name, String ssn, int studentNo) {
		//	super는 부모 생성자를 호출하는 메소드 (가장 먼저 사용되어야함)
		super(name, ssn);
		//super.name = name;
		System.out.println("자식인 Student 생성자 시작");
		this.studentNo = studentNo;
	}
}
