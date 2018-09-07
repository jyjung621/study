package ch19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class OraDelete {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
        // 부서코드 입력 받아서 해당Row를 삭제한다 
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 부서코드 입력");
		int deptno = sc.nextInt();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String sql = "DELETE FROM dept WHERE deptno = ?";
		
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			// result set
			pstmt.setInt(1, deptno);
			
			int result = pstmt.executeUpdate();
			
			if (result>0){
				System.out.println("OraDelete success deleting " + deptno);
			}
			else 
				System.out.println("OraDelete fail deleting " + deptno);
			conn.close();
		} catch(Exception e){
			System.out.println(e.getMessage());
		} finally {
			if(pstmt !=null) pstmt.close();
			if(conn !=null) conn.close();
		}
		sc.close();

	}

}
