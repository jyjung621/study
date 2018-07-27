package p13.objectstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializableWriter {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("C:/temp/object.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		ClassA classA = new ClassA();
		classA.filed1 = 1;
		classA.filed2.filed1 = 2;
		classA.filed3 = 3;
		classA.filed4 = 4;
		oos.writeObject(classA);
		oos.flush(); oos.close(); fos.close();
	}
}
