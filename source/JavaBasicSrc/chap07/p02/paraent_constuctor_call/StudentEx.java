package p02.paraent_constuctor_call;

public class StudentEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/***********************************************
		 * 	new를 통해 자식인 Student 인스턴스를 생성하도록 요청했지만,
		 * 	자식뿐만 아니라 부모인 People 인스턴스도 자동으로 같이 생성됨
		 ***********************************************/
		Student student = new Student("홍길동", "123456-1234567", 1);
		System.out.println("name : " + student.name);
		System.out.println("ssn : " + student.ssn);
		System.out.println("studentNo : " + student.studentNo);
	}

}
