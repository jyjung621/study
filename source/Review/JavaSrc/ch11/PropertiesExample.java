package ch11;

import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;

public class PropertiesExample {
	public static void main(String[] args) throws IOException {
		
		Properties pt = new Properties();
		String path = PropertiesExample.class.getResource("database.properties").getPath();
		System.out.println("1 path : " + path);
		
		path = URLDecoder.decode(path, "utf-8");
		pt.load(new FileReader(path));
		
		String driver = pt.getProperty("driver");
		String url = pt.getProperty("url");
		String userName = pt.getProperty("username");
		String password = pt.getProperty("password");
		
		System.out.println("2 path : " + path);
		System.out.println("드라이버 : " + driver);
		System.out.println("url : " + url);
		System.out.println("username : " + userName);
		System.out.println("password : " + password);
		
	}
}
