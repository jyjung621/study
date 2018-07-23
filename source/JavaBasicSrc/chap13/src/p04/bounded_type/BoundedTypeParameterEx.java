package p04.bounded_type;

public class BoundedTypeParameterEx {
	public static void main(String[] args) {
		//	compare 인자로 String type을 사용할 수 없음
		//	왜냐하면 compare의 인자가 Number type까지만 허용하기 때문..
		//String str = Util.compare("a", "b");
		
		int result1 = Util.compare(10, 20);
		System.out.println(result1);
		
		int result2 = Util.compare(4.5, 3);
		System.out.println(result2);
		
	}
}
