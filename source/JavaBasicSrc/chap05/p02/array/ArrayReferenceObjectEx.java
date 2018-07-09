package p02.array;

public class ArrayReferenceObjectEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] strArray = new String[3];
		/**********************************************
		 *  strArray[0] == strArray[1] 은 같은 주소(객체)를 사용
		 *  strArray[2] ==> new로 인하여 새로운 주소(객체) 생성
		 **********************************************/
		strArray[0] = "JAVA";
		strArray[1] = "JAVA";
		strArray[2] = new String("JAVA");

		System.out.println(strArray[0] == strArray[1] );		// true
		System.out.println(strArray[0] == strArray[2] );		// false
		System.out.println(strArray[0].equals(strArray[2]));	// true
	}
}
