package p05.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapex02 {
	public static void main(String[] args) {
		
		Map<Student, Integer> map = new HashMap<>();
		
		map.put(new Student(1, "홍길동"), 95);
		map.put(new Student(1, "홍길동"), 95);
		
		System.out.println("총 Entry 수 : " + map.size());
	}
}
