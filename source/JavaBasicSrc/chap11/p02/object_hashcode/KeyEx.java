package p02.object_hashcode;

import java.util.HashMap;

public class KeyEx {

	public static void main(String[] args) {
		//	Key 객체를 식별키로 사용해서 String 값을 저장하는 HashMap 객체 생성
		HashMap<Key, String> hashMap = new HashMap<Key, String>();
		
		//	식별키 "new Key(1)"로 "홍길동"을 저장함
		hashMap.put(new Key(1), "홍길동");
		
		//	식별키 "new Key(1)"로 "홍길동"을 읽어옴
		String value = hashMap.get(new Key(1));
		System.out.println(value);

		Object obj = new Object();
		//	println할 때 참조객체를 출력하는 내용은 기본적으로 Object class의 
		//	toString 메소드를 부르고,, toString 메소드는 내부적으로 패키지명 + @+ hashcode를
		//	문자열ㄹ로 만들어서 출력함
		System.out.println(obj);
		//	hashcode메소드는 Object class의 메소드
		System.out.println(obj.hashCode());
	}

}
