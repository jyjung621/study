package p13.objectstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableReader {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("C:/temp/object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		ClassA v = (ClassA) ois.readObject();
		System.out.println("field1 : " + v.filed1);
		System.out.println("field2.field1 : " + v.filed2.filed1);
		System.out.println("field3 : " + v.filed3);
		System.out.println("field4 : " + v.filed4);
		
		
	}
}
