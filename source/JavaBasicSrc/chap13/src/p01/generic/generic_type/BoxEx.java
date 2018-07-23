package p01.generic.generic_type;

public class BoxEx {
	public static void main(String[] args) {
		Box<String> box = new Box<String>();
		//	Box<String>은 Box generic class에게 T대신에 
		//	String으로 바꿔달라고 요청하는 의미
		box.set("홍길동");
		//	get 할 때는 casting 할 필요가 없음
		String name = box.get();
		
		Box<Apple> box1 = new Box<Apple>();
		box1.set(new Apple());	
		Apple apple = box1.get();
	}
}
