package p05.console.system_in;

import java.io.InputStream;

public class SystemInEx2 {
	public static void main(String[] args) throws Exception {
		
		InputStream is = System.in;
		byte[] datas = new byte[100];
		
		System.out.print("이름 : ");
		int  nameBytes = is.read(datas);
		//	nameBytes-2 의미 : enter key(CR LF) 2byte를 제거
		String name = new String(datas, 0, nameBytes-2);
		
		System.out.print("하고 싶은말 : ");
		int commentBytes = is.read(datas);
		String comment = new String(datas, 0, commentBytes-2);
		
		System.out.println("입력한 이름 : " + name);
		System.out.println("입력한 하고 싶은말 : " + comment);
	}
}
