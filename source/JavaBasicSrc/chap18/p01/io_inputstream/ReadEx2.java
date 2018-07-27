package p01.io_inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ReadEx2 {
	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("C:/temp/test.txt");
		
		int readByteNo;
		byte[] readbytes = new byte[3];
		String data = "";
		String data1 = "";
		
		while(true)
		{
			//	readBytes안에는 최대 3 byte 읽어오고,
			//	enter key(CR, LF 2byte)도 포함해서 읽어옴
			readByteNo = is.read(readbytes);
			//data1 = new String(readbytes, 0, readByteNo);
			//System.out.println("readbyte : " + data1);
			if(readByteNo == -1)
				break;
			
			data += new String(readbytes, 0, readByteNo);
		}
		System.out.println(data);
		is.close();
	}
}
