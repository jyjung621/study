package ch19;

import java.sql.*;
import java.util.Scanner;

public class OraProc1 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("�μ���ȣ �Է�?");
		String deptno = sc.nextLine();
		System.out.println("�μ��� �Է�?");
		String dname = sc.nextLine();
		System.out.println("��ġ �Է�?");
		String loc = sc.nextLine();

		Connection conn = null;
		CallableStatement cs = null; 
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String sql = "{call Dept_Insert(?, ?, ?)}";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			//	prepareCall : �������ν��� ������ ���� Method
			cs = conn.prepareCall(sql);
			//	�� ������ �ε����� ������ ����
			cs.setString(1, deptno);
			cs.setString(2, dname);
			cs.setString(3, loc);
			
			int result = cs.executeUpdate();
			if(result > 0) {
				System.out.println("Oracle CallableStatement �Է� ���� ^^");
			} else {
				System.out.println("Oracle CallableStatement �Է� ���� �Ф�");
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
