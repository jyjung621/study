package p01.class_basic;

public class StudentEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/***************************************
		 *  Student class가 data type이고
		 *  Student 변수는 Student Class 데이터 타입
		 ***************************************/
		Student student = new Student();
		System.out.println("Student 인스턴스 주소 = " +  student);
		
		Student student1 = new Student();
		System.out.println("Student1 인스턴스 주소 = " +  student1);
	}

}
