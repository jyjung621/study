package p03.generic_method1;

public class BoxingMethodEx {
	public static void main(String[] args) {
		//	generic method 사용할 때는 메소드 앞에 <data type>을 붙여 사용
		//	(강제사항 아님)
		Box<Integer> box1 = Util.<Integer>boxing(100);
		int intValue = box1.get();
		
		Box<String> box2 = Util.boxing("홍길동");
		String strValue = box2.get();
		
	}
}
