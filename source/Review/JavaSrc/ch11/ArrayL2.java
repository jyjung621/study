package ch11;

import java.util.ArrayList;

public class ArrayL2 {
	public static void print(ArrayList<String> list) {
		for(String str : list) {
			System.out.print(str + "\t");
		}
		System.out.println("\n--------------------------------------------------");
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("수박");
		list.add("사과");
		list.add("바나나");
		list.add("수박");
		list.add("대추");
		list.add("바나나");
		System.out.println("갯수 : " + list.size());
		print(list);
		//	1번자리에 끼워 넣기 가능
		list.add(1, "키위");
		print(list);
		//	해당 index의 내용과 교체
		list.set(4, "복숭아");
		print(list);
		list.remove(0);
		print(list);
		
		System.out.println("3번 인덱스 -> " + list.get(3));
		System.out.println("바나나 문의 1 : " + list.contains("바나나"));
		//	indexOf -> 가장 앞에 있는걸 찾음
		System.out.println("바나나 문의 2 : " + list.indexOf("바나나"));
		//	lastindexOf -> 가장 뒤에서 부터 찾음
		System.out.println("바나나 문의 3 : " + list.lastIndexOf("바나나"));
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals("바나나")) {
				list.set(i, "딸기");
			}
		}
		print(list);
	}
}
