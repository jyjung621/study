package p13.objectstream;

import java.io.Serializable;

public class ClassA implements Serializable {
	int filed1;
	ClassB filed2 = new ClassB();
	//	static filed는 제외
	static int filed3;
	//	transient : 임시라는 의미로, 데이터 전송시 제외
	transient int filed4;
}
