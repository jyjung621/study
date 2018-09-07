package ch11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapEx2 {
	public static void main(String[] args) {

		//	HashMap< Key, Value >
		HashMap<String, String> hm = new HashMap<>();

		hm.put("�̽¿�", "010-2222-3333");
		hm.put("�����", "010-3333-4444");
		hm.put("������", "010-4444-5555");
		
		System.out.println("�̽¿� TEL: " + hm.get("�̽¿�"));
		System.out.println("����� TEL: " + hm.get("�����"));
		System.out.println("������ TEL: " + hm.get("������"));
		
		Set<String> st = hm.keySet();
		for(String str : st) {
			System.out.println(str + "�� ��ȭ[Set] --> " + hm.get(str));
		}
		
		Iterator<String> it = hm.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key + "�� ��ȭ " + hm.get(key));
		}
	}
}
