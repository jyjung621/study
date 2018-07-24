package p04.hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetEx01 {
	public static void main(String[] args) {

		Set<String> set = new HashSet<>();

		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");
		set.add("iBATIS");

		int size = set.size();
		System.out.println("총 객체수 : " + size);

		//	iterator 객체에는 add한 전체 원소들이 포함되어 있음
		Iterator<String> iterator = set.iterator();
		//	hasNext() : 원소가 존재하는지 여부를 boolean 값으로 표현
		while (iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
		}

		
		//	set에서는 중복된 원소를 갖지 못하므로, 원소로 삭제 가능함
		set.remove("JDBC");
		set.remove("iBATIS");

		System.out.println("총 객체수 : " + set.size());

		iterator = set.iterator();
		while (iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
		}

		set.clear();
		if (set.isEmpty()) {
			System.out.println("비어 있음");
		}
	}
}
