package p05.console.system_out;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SystemOutEx1 {
	public static void main(String[] args) throws Exception {
		//	System.out에 대한 기본 데이터 타입은 OutputStream
		OutputStream os = System.out;
		
		//	48 => '0'
		for(byte b=48; b<58; b++)
		{
			os.write(b);
		}
		os.write(10);	//	10 => LF
		os.write(13);	//	13 => CR
		
		//	97 => 'a'
		for(byte b=97; b<123; b++)
		{
			os.write(b);
		}
		os.write(10);
		
		//	String : 한글 입력한 내용 전체를 comment로 받으면 한글이 깨지지 않음
		String hangul = "가나다라마바사아자차카타파하";
		byte[] hangulBytes = hangul.getBytes();
		os.write(hangulBytes);
		
		os.flush();
	}
}
