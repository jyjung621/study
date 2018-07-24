package p04.hashset;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx02 {
	public static void main(String[] args) {
		Set<Member> set = new HashSet<>();
		
		set.add(new Member("홍길동", 30));
		//	Member의 equals와 hashCode 메소드 실행결과
		//	동일한 원소라고 판단하여 2번째 add할 때 Set에 저장 안함
		set.add(new Member("홍길동", 30));
		
		System.out.println("총 객체수 : " + set.size());
	
	}
}
