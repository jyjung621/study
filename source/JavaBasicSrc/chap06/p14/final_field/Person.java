package p14.final_field;

public class Person {
	
	/**************************************************
	 * 	final의 의미
	 * 		--> 초기화할 때 값이 결정되고, 나중에 변수 값을 변경 불가
	 * 	
	 * 	final 변수인 경우 초기화할수 있는 방법(2가지)
	 * 		1) 변수 선언할 때 초기화하는 방법
	 * 		2) 생성자를 부를 때 초기화하는 방법
	 **************************************************/
	final String nation = "Korea";
	final String ssn;
	String name;
	
	public Person(String ssn, String name)
	{
		this.ssn = ssn;
		this.name = name;
	}
}
