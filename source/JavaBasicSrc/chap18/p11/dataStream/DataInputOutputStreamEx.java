package p11.dataStream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputStreamEx {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("C:/temp/primitive.dat");
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeUTF("홍길동");
		
	}
}
