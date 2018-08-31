package p01_dbquery_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookListEx2 {
	Connection con;
	
	public BookListEx2() {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String userid = "madang";
		String pwd = "madang";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver is loaded successfully");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver load failure!");
		}
		
		try {
			System.out.println("connection ");
			con = DriverManager.getConnection(url, userid, pwd);
		} catch (SQLException e) {
			System.out.println("database connection failure");
		}
	}
	
	
	private void sqlRun() {
		Statement stmt = null;
		
		String query = "SELECT"
				+ " bookname, publisher, price FROM book where bookname like '축구의 역사'";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println(" NAME\t\tPRICE\t\tMAKER");
			System.out.println("----------------------------------------------------");
			while (rs.next()) {
				System.out.print(rs.getString(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t" + rs.getInt(3));
				System.out.println();
			}
		} catch (SQLException e) {
			
		} finally {
			try {
				stmt.close();
			} catch (SQLException e1) {
				
			}
			
			try {
				con.close();
			} catch (SQLException e) {
				
			}

		}
		
	}
	
	public static void main(String[] args) {
		BookListEx2 so = new BookListEx2();
		
		so.sqlRun();
		
	}

}
