package sam02;

public class Ex01 {

	public static void main(String[] args) {
		MessageBean mb = new MessageBeanEn();
		mb.sayHello("eng");
		mb = new MessageBeanKo();
		mb.sayHello("kor");
	}

}
