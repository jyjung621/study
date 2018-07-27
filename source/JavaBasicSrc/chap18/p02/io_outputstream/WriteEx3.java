package p02.io_outputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteEx3 {
	public static void main(String[] args) throws Exception {
		OutputStream os = new FileOutputStream("C:/temp/test.txt");
		
		byte[] data = "ABC1".getBytes();

		os.write(data);
		os.flush();
		os.close();
	}
}
