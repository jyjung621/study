package ch11;

import java.util.Stack;

public class StackEx {
	public static void main(String[] args) {
		String[] pet = {"������", "������", "�۸���", "�߿���"};
		Stack<String> st = new Stack<>();
		for(String str : pet) {
			System.out.println("PUSH --> " + str);
			st.push(str);
		}
		System.out.println("--------------------------");
		
		while(!st.isEmpty()) {
			System.out.println("POP -> " + st.pop());
		}
	}
}
