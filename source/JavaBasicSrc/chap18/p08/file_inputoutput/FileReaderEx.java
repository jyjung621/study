package p08.file_inputoutput;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileReaderEx {
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("C:\\DevEnv\\JavaSpace\\chap18_io\\src\\p08\\file_inputoutput\\FileInputStreamEx.java");
		
		int readCharNo;
		char[] cbuf = new char[100];
		while((readCharNo = fr.read(cbuf)) != -1)
		{
			String data = new String(cbuf, 0, readCharNo);
			System.out.println(data);
		}
		fr.close();
	}
}
