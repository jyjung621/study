package p13.arrays_sort;

public class Member {//implements Comparable<Member> {

	String name;
	
	Member(String name)
	{
		this.name = name;
	}
	//	Comparable의 추상메소드인 compareTo를 override
	/*@Override
	public int compareTo(Member o) {
		
		 * 	String의 compareTo의 return 값
		 * 	1) name < o.name	==> -1
		 * 	2) name == o.name	==> 0
		 * 	3) name > o.name	==> 1
		 * 	기본은 오름차순 sorting
		 
		return name.compareTo(o.name);
	};*/
}
