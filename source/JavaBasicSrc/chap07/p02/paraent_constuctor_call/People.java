package p02.paraent_constuctor_call;

public class People {

	public String name;
	public String ssn;

	//	name, ssn을 초기화하는 생성자(부모)
	public People(String name, String ssn) {
		System.out.println("People 생성자 호출");
		this.name = name;
		this.ssn = ssn;
	}
}
