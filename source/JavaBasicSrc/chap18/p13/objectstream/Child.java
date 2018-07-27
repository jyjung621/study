package p13.objectstream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Child extends Parent implements Serializable {
	public String field2;
	
	//	부모의 class가 serializable을 포함하지 않았을 경우
	//	Child Class에서 writeObject, readObject 메소드를
	//	선언하면 부모 class도 serializable을 포함한 효과를 발생시킴
	//	1. readObject, writeObject 메소드 선언할 때, private 반드시 포함
	//	2.  다른 class에서 write/readObject 메소드 호출시, 여기서 선언된
	//		write/readObject 메소드 자동 호출됨
	private void writeObject(ObjectOutputStream out) throws IOException {
		//	부모의 class의 field값을 세팅
		out.writeUTF(field1);
		//	defaultWriteObject가 자식 class의 field를
		//	writeObject 메소드를 통해 세팅
		out.defaultWriteObject();
	}
	
	private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException { 
		field1 = in.readUTF();
		in.defaultReadObject();
	}
}
