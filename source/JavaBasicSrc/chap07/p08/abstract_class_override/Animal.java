package p08.abstract_class_override;

public abstract class Animal {
	// field
	public String kind;
	// constructor
	
	// method(일반메소드)
	public void breathe() {
		System.out.println("숨을 쉽니다.");
	}
	
	// abstract method(추상 메소드)를 선언
	// 메소드 내용이 없음(메소드의 return type, 메소드 이름,
	// 메소드 매개변수만 선언되어 있음)
	public abstract void sound();

}
