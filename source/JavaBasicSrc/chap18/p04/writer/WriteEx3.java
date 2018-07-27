package p04.writer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;

public class WriteEx3 {
	public static void main(String[] args) throws Exception {
		Writer writer = new FileWriter("C:/temp/test.txt");
		
		String data = "안녕하세요. 반삽습니다...";

		writer.write(data, 3, 2);
		writer.flush();
		writer.close();
	}
}
