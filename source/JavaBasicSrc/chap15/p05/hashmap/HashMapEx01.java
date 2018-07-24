package p05.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx01 {
	public static void main(String[] args) {
		//	Map 컬렉션 생성
		Map<String, Integer> map = new HashMap<>();
		
		//	객체 저장
		map.put("신용권", 85);
		//	map에 새로운 key로 value를 저장할 때는 map에 (key, value)가 새로 생성됨
		map.put("홍길동", 90);
		map.put("동장군", 80);
		//	key가 기존 map에 이미 있다면, 해당 key의 value 값만 수정됨
		map.put("홍길동", 95);
		System.out.println("총 Entry 수 : " + map.size());
		
		//	객체 찾기
		System.out.println("\t홍길동 : " + map.get("홍길동"));
		System.out.println();
		
		//	객체를 하나씩 처리
		//	1) key 전체 set을 가져와야 됨(map.keySet())
		Set<String> keySet = map.keySet();
		//	2) keySet을 가지고 iterator를 통해 각 element의 key, value를 가져옴
		Iterator<String> keyIterator = keySet.iterator();
		while(keyIterator.hasNext())
		{
			String key = keyIterator.next();
			Integer value = map.get(key);
			System.out.println("\t" + key + " : " + value);
		}
		System.out.println();
		
		//	객체 삭제
		map.remove("홍길동");
		System.out.println("총 Entry 수 : " + map.size());
		
		//	객체를 하나씩 처리
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		
		while(entryIterator.hasNext())
		{
			Map.Entry<String, Integer> entry = entryIterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("\t" + key + " : " + value);
		}
		System.out.println();
		
		//	객체 전체 삭제
		map.clear();
		System.out.println("총 Entry 수 : " + map.size());
	}
}
