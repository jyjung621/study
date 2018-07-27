package p13.objectstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class NonSerializalbeParentEx {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("C:/temp/Object.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Child chid = new Child();
		chid.field1 = "홍길동";
		chid.field2 = "홍삼원";
		oos.writeObject(chid);
		oos.flush(); oos.close(); fos.close();
		
		
		FileInputStream fis = new FileInputStream("C:/temp/Object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Child v = (Child) ois.readObject();
		System.out.println("field1 : " + v.field1);
		System.out.println("field2 : " + v.field2);
		ois.close(); fis.close();
		
		
	}
}
