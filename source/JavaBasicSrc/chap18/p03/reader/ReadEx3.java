package p03.reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;

public class ReadEx3 {
	public static void main(String[] args) throws Exception {
		Reader reader = new FileReader("C:/temp/test.txt");

		int readCharNo;
		char[] cbuf = new char[4];

		readCharNo = reader.read(cbuf, 1, 2);
		for (int i = 0; i < cbuf.length; i++) {
			System.out.println(cbuf[i]);
		}
		reader.close();

	}
}
