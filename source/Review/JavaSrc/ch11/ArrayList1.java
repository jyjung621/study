package ch11;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayList1 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("���");
		list.add("�ٳ���");
		list.add("��");
		list.add("������");
		list.add("�ٳ���");
		System.out.println("����� ���� -> " + list.size());
		System.out.println(">> Iterator ��ü�� ��� ��� <<");
		Iterator elements = list.iterator();
		while(elements.hasNext()) {
			System.out.print(elements.next() + "\t");
		}
		System.out.println("\n");
		System.out.println(">> get �޼ҵ�� ��� ��� <<");
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + "\t");
		}
		System.out.println();
	}
}
