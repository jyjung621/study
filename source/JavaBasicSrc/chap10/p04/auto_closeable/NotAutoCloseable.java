package p04.auto_closeable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;

public class NotAutoCloseable {
	public static void main(String[] args) {
//		FileInputStream fis = null;
//		try {
//			fis = new FileInputStream("file.txt");
//			//	fis를 file open, read, write
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} finally {
//			if(fis != null)
//			{
//				try {
//					fis.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
		
		try(FileInputStream fis = new FileInputStream("file.txt"))
		{
			int data = fis.read();
			while(data != -1)
			{
				System.out.println((char) data);
				data = fis.read();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
