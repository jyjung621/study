package p03.reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;

public class ReadEx2 {
	public static void main(String[] args) throws Exception {
		Reader reader = new FileReader("C:/temp/test.txt");
		
		int readCharNo;
		char[] cbuf = new char[2];
		String data = "";
				
		while(true)
		{
			readCharNo = reader.read(cbuf);
			if(readCharNo == -1)
				break;
			
			data += new String(cbuf, 0, readCharNo);
		}
		System.out.println(data);
		reader.close();
	}
}
