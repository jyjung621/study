package p01.io_inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ReadEx3 {
	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("C:/temp/test.txt");

		int readByteNo;
		byte[] readbytes = new byte[8];

		readByteNo = is.read(readbytes, 2, 3);
		for (int i = 0; i < readbytes.length; i++) {
			System.out.println(readbytes[i]);
		}

	}
}
