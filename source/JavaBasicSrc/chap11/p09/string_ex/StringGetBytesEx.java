package p09.string_ex;

import java.io.UnsupportedEncodingException;

public class StringGetBytesEx {
	public static void main(String[] args) {
		String str = "안녕하세요.";
		
		byte[] bytes1 = str.getBytes();
		System.out.println("bytes1.length : " + bytes1.length);
		String str1 = new String(bytes1);
		System.out.println("bytes1 -> String : " + str1);
		
		try {
			//	EUC-KR로 encoding
			byte[] bytes2 = str.getBytes("EUC-KR");
			System.out.println("bytes.length : " + bytes2.length);
			//	EUC-KR로 decoding(byte를 다른 데이터타입으로 변환)
			String str2 = new String(bytes2, "EUC-KR");
			System.out.println("bytes1 -> String : " + str2);
			
			byte[] bytes3 = str.getBytes("UTF-8");
			System.out.println("bytes1.length : " + bytes3.length);
			String str3 = new String(bytes3, "UTF-8");
			System.out.println("bytes1 -> String : " + str3);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
