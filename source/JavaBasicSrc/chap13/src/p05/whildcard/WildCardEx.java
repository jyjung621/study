package p05.whildcard;

import java.util.Arrays;

public class WildCardEx {
	
	//	? : wildcard로 모든 데이터 타입이 올 수 있다는 의미
	public static void registerCourse( Course<?> course) {
		System.out.println(course.getName() + " 수강생 :  " + Arrays.toString(course.getStudents()));
	}
	
	//	extends : Student의 자식까지 가능 (Student, HighStudent)
	public static void registerCourseStudent( Course<? extends Student> course) {
		System.out.println(course.getName() + " 수강생 :  " + Arrays.toString(course.getStudents()));
	}
	
	//	super : Worker의 부모까지 가능 (Worker, Person)
	public static void registerCourseWorker( Course<? super Worker> course) {
		System.out.println(course.getName() + " 수강생 :  " + Arrays.toString(course.getStudents()));
	}
	
	public static void main(String[] args) {
		Course<Person> personCourse = new Course<Person>("일반인과정", 5);
		personCourse.add(new Person("일반인"));
		personCourse.add(new Worker("직장인"));
		personCourse.add(new Student("학생"));
		personCourse.add(new HighStudent("고등학생"));
		
		Course<Worker> workerCourse = new Course<Worker>("직장인과정", 5);
		workerCourse.add(new Worker("직장인"));
		
		Course<Student> studentCourse = new Course<Student>("학생과정", 5);
		studentCourse.add(new Student("학생"));
		
		Course<HighStudent> highstudentCourse = new Course<HighStudent>("고등학생과정", 5);
		highstudentCourse.add(new HighStudent("고등학생"));
		
		registerCourse(personCourse);
		registerCourse(workerCourse);
		registerCourse(studentCourse);
		registerCourse(highstudentCourse);
		System.out.println();
		
		//registerCourseStudent(personCourse);
		//registerCourseStudent(workerCourse);
		registerCourseStudent(studentCourse);
		registerCourseStudent(highstudentCourse);
		System.out.println();
		
		registerCourseWorker(personCourse);
		registerCourseWorker(workerCourse);
		//registerCourseWorker(studentCourse);
		//registerCourseWorker(highstudentCourse);
	}
}
