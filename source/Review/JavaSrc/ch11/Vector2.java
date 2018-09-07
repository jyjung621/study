package ch11;

import java.util.Vector;

public class Vector2 {
	public static void print(Vector<String> vc) {
		for(String str : vc) {
			System.out.print(str + "\t");
		}
		System.out.println("\n--------------------------------------------------");
	}
	
	public static void main(String[] args) {
		Vector<String> vc = new Vector<>();
		vc.add("����");
		vc.add("����");
		vc.add("����");
		vc.add("����");
		vc.add("����");
		System.out.println("���� : " + vc.size());
		print(vc);
		//	1���ڸ��� ���� �ֱ� ����
		vc.add(1, "Ű��");
		print(vc);
		//	�ش� index�� ����� ��ü
		vc.set(4, "������");
		print(vc);
		vc.remove(0);
		print(vc);
		
		System.out.println("2�� �ε��� -> " + vc.get(2));
		System.out.println("���� ���� 1 : " + vc.contains("����"));
		//	indexOf -> ���� �տ� �ִ°� ã��
		System.out.println("���� ���� 2 : " + vc.indexOf("����"));
		//	lastindexOf -> ���� �ڿ��� ���� ã��
		System.out.println("���� ���� 3 : " + vc.lastIndexOf("����"));
		for(int i=0; i<vc.size(); i++) {
			if(vc.get(i).equals("����")) {
				vc.set(i, "����");
			}
		}
		print(vc);
	}
}
