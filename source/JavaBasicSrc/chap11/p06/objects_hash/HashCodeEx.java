package p06.objects_hash;

import java.util.Objects;

public class HashCodeEx {
	public static void main(String[] args) {
		Student s1 = new Student(1, "홍길동","컴퓨터");
		Student s2 = new Student(1, "홍길동","컴퓨터");
			
		System.out.println(s1.hashCode());
		/*
		 * 	Objects 클래스의 hashCode 메소드는 내부적으로
		 * 	s2.hashCode()를 호출
		 * 	System.out.println(s2.hashCode());
		 */
		System.out.println(Objects.hash(s2));
		
	}
	
	//	중첩 내부 static class
	static class Student {
		int sno;
		String name;
		String dept;
		
		Student(int sno, String name, String dept)
		{
			this.name = name;
			this.sno = sno;
			this.dept = dept;
		}
		
		//	Object class의 hashCode 메소드를 Override
		@Override
		public int hashCode() {
			/********************************************
			 * 	Objects의 hash 메소드의 입력 parameter의 갯수의 
			 * 	제한이 없고, data type이 서로 달라도 됨
			 ********************************************/
			return Objects.hash(sno,name,dept);
		}
	}
}
