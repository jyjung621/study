package p13.objectstream;

import java.io.Serializable;

public class ClassC implements Serializable {
	/*
	 * 	serialVersionUID는 instance를 쓰고, 읽을 때 체크하는 아이디로
	 * 	읽고, 쓸때 해당 클래스의 serialVersionUID가 동일하지 않으면 Exception 에러발생
	 */
	int field1;
	// Object.dat 파일을 쓰고 난 후에, ClassC를 수정 (field2 추가)
	int field2;
	
}
