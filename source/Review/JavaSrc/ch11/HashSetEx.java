package ch11;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetEx {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<>();
		hs.add("备贩2");
		hs.add("绊剧捞");
		hs.add("具克捞");
		hs.add("备贩2");
		hs.add("柳档俺");
		hs.add("港港捞");
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
