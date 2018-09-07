package ch11;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetEx {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<>();
		hs.add("����2");
		hs.add("������");
		hs.add("�߿���");
		hs.add("����2");
		hs.add("������");
		hs.add("�۸���");
		for(String str : hs) {
			System.out.println(str);
		}
		System.out.println("==================");
		
		Iterator<String> it = hs.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
