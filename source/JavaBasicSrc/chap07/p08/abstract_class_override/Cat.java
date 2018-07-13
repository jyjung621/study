package p08.abstract_class_override;

public class Cat extends Animal {
	public Cat() {
		this.kind = "포유류";
	}

	@Override
	// 부모가 abstract class인 경우에는 부모의 abstract method는
	// 반드시 자식클래스에서 구현이 되어야 함
	// 즉, 부모 메소드를 override하는 효과를 발생시킴
	public void sound() {
		System.out.println("야옹");

	}

}
