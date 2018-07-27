package p03.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class ReadEx1 {
	public static void main(String[] args) throws IOException {
		
		Reader reader = new FileReader("C:/temp/test.txt");
				
		int readData;
		while (true) {

			readData = reader.read();
			if (readData == -1) {
				break;
			}
			System.out.print(" " + (char) readData);
		}
	}
}
