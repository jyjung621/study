package ch19;
import  java.sql.*;
import java.util.Scanner;

import javax.print.attribute.standard.Finishings;
public class OraPrepare {
   public static void main(String[] args) throws SQLException {
	   Scanner sc = new Scanner(System.in);
	   System.out.println("부서번호 입력?");	       String deptno = sc.nextLine();
	   System.out.println("부서명 입력?");  	   String dname  = sc.nextLine();
	   System.out.println("위치 입력 ?");  	       String loc    = sc.nextLine();
	   
	   Connection conn = null;
	   PreparedStatement  pstmt = null;
	   String driver = "oracle.jdbc.driver.OracleDriver";
		// Localhost -> 127.0.0.1; , Port 번호:1521  , xe(orcl)-> Service ID(Sid)
	   String url    = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	   String sql    = "Insert Into dept values(?, ?, ?)";
//	   String sql    = "Insert Into dept values("+ deptno+",'"+dname+"','"+loc+"')"; ���� ���� �ǹ� 
	   
	   try {
		   Class.forName(driver);
		   conn = DriverManager.getConnection(url,"scott","tiger");
		   pstmt = conn.prepareStatement(sql);   // sql
		   pstmt.setString(1, deptno);
		   pstmt.setString(2, dname);
		   pstmt.setString(3, loc);
		   //  
		   int result = pstmt.executeUpdate(); //Insert -> executeUpdate
		   if (result > 0 ) System.out.println("OraPrepare 성공 ^^");
		   else             System.out.println("OraPrepare 실패 T.T");
	   } catch(Exception e) {
		   System.out.println(e.getMessage());
	   }finally {
		   if (pstmt != null) pstmt.close();
		   if (conn != null) conn.close();
	  }
	  sc.close();
   }
}