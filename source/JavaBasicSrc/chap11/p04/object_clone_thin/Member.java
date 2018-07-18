package p04.object_clone_thin;

//	Cloneable 인터페이스를 implement한다는 의미는 ==> 
//	Object class의 clone 메소드를 사용하여 인스턴스를 복제해도 좋다는 서명의 의미
public class Member implements Cloneable {
	public String id;
	public String name;
	public String password;
	public int age;
	public boolean adult;

	public Member(String id, String name, String password, int age, boolean adult) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.adult = adult;
	}

	// getMember를 통해 복제 인스턴스를 생성하여 리턴함
	public Member getMember() {
		Member cloned = null;
		try {
			// clone() 메소드는 Object class의 메소드임
			cloned = (Member) clone();
			// Object class의 clone()메소드를 통해 복제 실패하면
			// CloneNotSupportedException Exception 발생
		} catch (CloneNotSupportedException e) {
		}

		return cloned;
	}
}
