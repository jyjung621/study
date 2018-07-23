package p13.arrays_sort;

import java.util.Arrays;

public class SortEx {
	public static void main(String[] args) {
		int[] scores = {99, 97, 98};
		//	Arrays의 sort메소드는 무조건 Ascending(오름차순) sorting
		//	Arrays sort를 쓸려면 기본적으로 Comparable 인터페이스를
		//	implemention 해야만 함
		Arrays.sort(scores);
		for(int i=0; i<scores.length; i++)
		{
			System.out.println("scores[" + i + "] = " + scores[i]);
		}
		System.out.println();
		
		String[] names = {"홍길동", "박동수", "김민수"};
		Arrays.sort(names);
		for(int i=0; i<names.length; i++)
		{
			System.out.println("names[" + i + "] = " + names[i]);
		}
		System.out.println();
		
		Member m1 = new Member("홍길동");
		Member m2 = new Member("박동수");
		Member m3 = new Member("김민수");
		Member[] members = {m1, m2, m3};
		Arrays.sort(members);
		for(int i=0; i<members.length; i++)
		{
			System.out.println("members[" + i + "] = " + members[i]);
		}
		
	}
}
