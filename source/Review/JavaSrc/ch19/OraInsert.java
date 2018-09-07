package ch19;

import java.sql.*;
import java.util.Scanner;

public class OraInsert {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.println("부서번호 입력?");
		String deptno = sc.nextLine();
		System.out.println("부서명 입력?");
		String dname = sc.nextLine();
		System.out.println("위치 입력?");
		String loc = sc.nextLine();

		Connection conn = null;
		Statement stmt = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String sql = String.format("INSERT INTO dept values(%s, '%s', '%s')", deptno, dname, loc);
		
		System.out.println("sql->" + sql);
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			// result set
			int result = stmt.executeUpdate(sql);
			if (result > 0) {
				System.out.println("입력성공 ^^");
			} else {
				System.out.println("입력실패 ㅜㅜ");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		sc.close();

	}
}
