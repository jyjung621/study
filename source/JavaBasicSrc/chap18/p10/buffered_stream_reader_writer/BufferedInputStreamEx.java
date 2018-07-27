package p10.buffered_stream_reader_writer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamEx {
	public static void main(String[] args) throws Exception {
		long start = 0;
		long end =0;
		
		//	Buffered를 적용안한 상태에서의 속도
		FileInputStream fis1 = new FileInputStream("C:\\DevEnv\\JavaSpace\\chap18_io\\src\\p10\\buffered_stream_reader_writer\\forest.jpg");
		start = System.currentTimeMillis();
		while(fis1.read() != -1) {}
		end = System.currentTimeMillis();
		System.out.println("사용하지 않았을 때: " + (end - start) + "ms");
		fis1.close();
		
		//	BufferedInputStream을 적용 한 상태에서의 속도
		FileInputStream fis2 = new FileInputStream("C:\\DevEnv\\JavaSpace\\chap18_io\\src\\p10\\buffered_stream_reader_writer\\forest.jpg");
		BufferedInputStream bis = new BufferedInputStream(fis2);
		start = System.currentTimeMillis();
		while(bis.read() != -1) {}
		end = System.currentTimeMillis();
		System.out.println("사용하지 않았을 때: " + (end - start) + "ms");
		bis.close();
		fis2.close();		
	}
}
