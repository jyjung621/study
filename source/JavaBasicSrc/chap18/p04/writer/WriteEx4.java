package p04.writer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;

public class WriteEx4 {
	public static void main(String[] args) throws Exception {
		Writer writer = new FileWriter("C:/temp/test.txt");
		
		char[] data = "홍길동's 만세".toCharArray();

		writer.write(data, 1, 2);
		writer.flush();
		writer.close();
	}
}
