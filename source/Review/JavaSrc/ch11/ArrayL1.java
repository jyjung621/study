package ch11;

import java.util.ArrayList;

public class ArrayL1 {
	public static void main(String[] args) {
		ArrayList<String> a1 = new ArrayList<>();
		a1.add("±∏∑∑2");
		a1.add("∆»∑∑¿Ã");
		a1.add("±∏∑∑2");
		a1.add("±∏∑∑4");
		a1.add("±∏∑∑3");
		
		for(int i=0; i<a1.size(); i++) {
			System.out.println(a1.get(i));
		}
		System.out.println("===========================");
		
		for(String str : a1) {
			System.out.println(str);
		}
		
		int M = (int)Math.sqrt(40);
		System.out.println(M);
	}
}
