package p01.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx {
	public static void main(String[] args) {
		// List Interface type으로 list 변수 선언
		// List<E> generic type인데, List 원소 data type을
		// Spring으로 선언
		List<String> list = new ArrayList<>();

		// add : 원소를 list 객체 끝에 추가
		list.add("Java"); // index 0에 "Java"
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "Database"); // index 2에 "Database" 넣음
		list.add("iBATIS");

		int size = list.size();
		System.out.println("총 객체수 : " + size);
		System.out.println();

		String skill = list.get(2);
		System.out.println("2 : " + skill);
		System.out.println();

		/*
		 * for (int i = 0; i < list.size(); i++) { String str = list.get(i);
		 * System.out.println(i + " : " + str); }
		 */
		int index = 0;
		for (String str : list) {
			System.out.println(index++ + "str = " + str);
		}
		System.out.println();

		list.remove(2);
		list.remove(2);
		list.remove("iBATIS");

		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + " : " + str);
		}

	}
}
