package ch19;

import java.sql.*;
import java.util.Scanner;

public class OraProc1 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("부서번호 입력?");
		String deptno = sc.nextLine();
		System.out.println("부서명 입력?");
		String dname = sc.nextLine();
		System.out.println("위치 입력?");
		String loc = sc.nextLine();

		Connection conn = null;
		CallableStatement cs = null; 
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String sql = "{call Dept_Insert(?, ?, ?)}";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			//	prepareCall : 저장프로시저 실행을 위한 Method
			cs = conn.prepareCall(sql);
			//	각 인자의 인덱스와 내용을 세팅
			cs.setString(1, deptno);
			cs.setString(2, dname);
			cs.setString(3, loc);
			
			int result = cs.executeUpdate();
			if(result > 0) {
				System.out.println("Oracle CallableStatement 입력 성공 ^^");
			} else {
				System.out.println("Oracle CallableStatement 입력 실패 ㅠㅠ");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			if(cs != null) { cs.close(); }
			if(conn != null) { conn.close(); }
		}
		sc.close();
	}
}
