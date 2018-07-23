package p06.objects_compare;

import java.util.Comparator;
import java.util.Objects;

public class CompareEx {
	public static void main(String[] args) {

		Student s1 = new Student(1);
		Student s2 = new Student(1);
		Student s3 = new Student(2);

		/*************************************************************
		 * 	StudentComparator stcom = new StudentComparator();
		 * 
		 * 	Objects 클래스의 compare method 
		 * 	- Comparator 인터페이스의 compare 메소드를 호출함
		 * 
		 * 	Objects.compare(s1, s2, new StudentComparator()); 
		 * 	--> stcom.comare(s1, s2);	: 같은 의미
		 *************************************************************/
		int result = Objects.compare(s1, s2, new StudentComparator());
		System.out.println(result);
		result = Objects.compare(s1, s3, new StudentComparator());
		System.out.println(result);
	}

	// 중첩 내부 클래스로 static class 선언
	static class Student {
		// 필드
		int sno;

		// 생성자
		public Student(int sno) {
			this.sno = sno;
		}
	}

	// 중첩 내부 클래스로 static class 선언
	static class StudentComparator implements Comparator<Student> {
		// Comparator 인터페이스의 static method 중 하나인
		// compare 메소드만 Override
		@Override
		public int compare(Student o1, Student o2) {
			
			/*  if(o1.sno < o2.sno) 
				  return -1; 
			  else if(o1.sno == o2.sno) 
				  return 0; 
			  else
				  return 1;*/
			 
			return Integer.compare(o1.sno, o2.sno);
		}

	}
}
