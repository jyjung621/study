package p02.io_outputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteEx1 {
	public static void main(String[] args) throws Exception {
		OutputStream os = new FileOutputStream("C:/temp/test.txt");
		
		//	"ABC" 문자열 => byte 배열로 변환
		byte[] data = "ABC".getBytes();
		//	file write : 기존에 같은 파일이 존재한다면, 기존 내용이
		//	 			전체 삭제되고, 새로운 내용으로 채워짐
		//				기존의 같은 파일이 없으면, 새로운 파일 생성
		for(int i=0; i<data.length; i++)
		{
			os.write(data[i]);
		}
		//	flush : write에 존재하는 메소드
		//	- 출력 buffer에 있는 내용을 실제 하드디스크상의 파일에 write하라는 의미임
		os.flush();
		os.close();
	}
}
