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
		list.add("����");
		list.add("���");
		list.add("�ٳ���");
		list.add("����");
		list.add("����");
		list.add("�ٳ���");
		System.out.println("���� : " + list.size());
		print(list);
		//	1���ڸ��� ���� �ֱ� ����
		list.add(1, "Ű��");
		print(list);
		//	�ش� index�� ����� ��ü
		list.set(4, "������");
		print(list);
		list.remove(0);
		print(list);
		
		System.out.println("3�� �ε��� -> " + list.get(3));
		System.out.println("�ٳ��� ���� 1 : " + list.contains("�ٳ���"));
		//	indexOf -> ���� �տ� �ִ°� ã��
		System.out.println("�ٳ��� ���� 2 : " + list.indexOf("�ٳ���"));
		//	lastindexOf -> ���� �ڿ��� ���� ã��
		System.out.println("�ٳ��� ���� 3 : " + list.lastIndexOf("�ٳ���"));
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals("�ٳ���")) {
				list.set(i, "����");
			}
		}
		print(list);
	}
}
