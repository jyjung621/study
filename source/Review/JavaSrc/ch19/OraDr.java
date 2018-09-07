package ch19;

import java.sql.*;

public class OraDr {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.20.109:1521:orcl";
//		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
//		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("Start!");
			if(conn != null) {
				System.out.println("Sucess 연결성공");
			} else {
				System.out.println("Fail...");
			}
			conn.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error!");
		}
			
	}
}
