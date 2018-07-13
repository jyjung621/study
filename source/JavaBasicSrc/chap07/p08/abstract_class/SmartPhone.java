package p08.abstract_class;

// abstract class인 Phone을 부모클래스로 해서 자식클래스 있음
public class SmartPhone extends Phone {
	// constructor
	public SmartPhone(String owner) {
		// abstract class인 Phone의 생성자 호출
		super(owner);
	}

	// method
	public void internetSearch() {
		System.out.println("인터넷 검색을 합니다.");
	}

}
