package p01.io_inputstream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadEx1_hangul {
	public static void main(String[] args) throws IOException {
		

		InputStream is = new FileInputStream("src/p01/io_inputstream/test.txt");
		//InputStream is = new FileInputStream("C:\\DevEnv\\JavaSpace\\chap18_io\\bin\\p01\\io\\inputstream\\test.txt");
				
		InputStreamReader ir = new InputStreamReader(is, "utf-8");
		BufferedReader br = new BufferedReader(ir);
		
		int readByte;
		while (true) {
			// read 메소드는 읽어오는 값은 byte 단위로 읽어옴
			//readByte = is.read();
			readByte = br.read();
			if (readByte == -1) {
				break;
			}
			System.out.print(" " + (char) readByte);
		}
	}
}
