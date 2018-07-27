package p04.writer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;

public class WriteEx1 {
	public static void main(String[] args) throws Exception {
		Writer writer = new FileWriter("C:/temp/test.txt");
		
		char[] data = "홍길동".toCharArray();
		for(int i=0; i<data.length; i++)
		{
			writer.write(data[i]);
		}
		writer.flush();
		writer.close();
	}
}
