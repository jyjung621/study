package p13.objectstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerialVersionUIDEx1 {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("C:/temp/Object.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		ClassC classC = new ClassC();
		classC.field1 = 1;
		oos.writeObject(classC);
		oos.flush(); oos.close(); fos.close();
	}
}
