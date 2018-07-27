package p08.file_inputoutput;

import java.io.FileInputStream;

public class FileInputStreamEx {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("C:\\DevEnv\\JavaSpace\\chap18_io\\src\\p07\\file_class\\FileEx.java");
			
			int data;
			while((data = fis.read()) != -1)
			{
				System.out.write(data);
			}
			fis.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
