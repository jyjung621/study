package ch11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapEx2 {
	public static void main(String[] args) {

		//	HashMap< Key, Value >
		HashMap<String, String> hm = new HashMap<>();

		hm.put("ÀÌ½Â¿ì", "010-2222-3333");
		hm.put("¼ÕÈï¹Î", "010-3333-4444");
		hm.put("ÀüÁöÇö", "010-4444-5555");
		
		System.out.println("ÀÌ½Â¿ì TEL: " + hm.get("ÀÌ½Â¿ì"));
		System.out.println("¼ÕÈï¹Î TEL: " + hm.get("¼ÕÈï¹Î"));
		System.out.println("ÀüÁöÇö TEL: " + hm.get("ÀüÁöÇö"));
		
		Set<String> st = hm.keySet();
		for(String str : st) {
			System.out.println(str + "ÀÇ ÀüÈ­[Set] --> " + hm.get(str));
		}
		
		Iterator<String> it = hm.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key + "ÀÇ ÀüÈ­ " + hm.get(key));
		}
	}
}
