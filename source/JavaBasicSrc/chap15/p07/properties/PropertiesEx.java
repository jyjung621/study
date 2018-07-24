package p07.properties;

import java.io.FileReader;
import java.net.URLDecoder;
import java.util.Properties;

public class PropertiesEx {
	public static void main(String[] args) throws Exception {
		//	Properties는 HashTable의 자식 클래스로,
		//	Key, Value의 data type이 모두 String으로
		//	HashTable의 특별한 class임
		Properties properties = new Properties();
		//	path에는 database.properties의 directory path정보를 가지고 있음
		String path = PropertiesEx.class.getResource("database.properties").getPath();
		System.out.println("Path = " + path);
		//	database.properties의 문자들이 utf-8로 인코딩 되어있어서,
		//	이것을 다시 utf-8로 디코딩하여 읽어야 함
		//	path 경로에 한글이 있을수 있으므로, 디코딩 필요하기에... 사용
		path = URLDecoder.decode(path, "utf-8");
		//	load : file을 하드디스크에서 읽어 메모리에 올려놓는 것을 말함
		properties.load(new FileReader(path));
		
		//	getProperty 메소드에 key값을 인자로 넘겨 value를 가져옴
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String info = properties.getProperty("info");
		
		System.out.println("driver : " + driver);
		System.out.println("url : " + url);
		System.out.println("username : " + username);
		System.out.println("password : " + password);
		System.out.println("info : " + info);
		
	}
}
