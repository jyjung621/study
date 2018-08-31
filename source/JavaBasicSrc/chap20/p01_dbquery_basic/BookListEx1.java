package p01_dbquery_basic;

//	추가한 oracle ojdbc6.jar 파일에 존재
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookListEx1 {
	Connection con;
	
	//	생성자
	//	DB 접속 & 연결
	public BookListEx1() {
		//	orcl : SID // 1521 : 포트 // localhost : 호스트이름
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String userid = "madang";
		String pwd = "madang";
		
		try {
			//	Class.forName() : OracleDriver의 클래스를 가져옴(메모리 탑재)
			//	oracle이용할 경우 변경사항 없음
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver is loaded successfully");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver load failure!");
		}
		
		try {
			//	DriverManager : Oracle DB와 연결 (DB 접속하기와 동일)
			System.out.println("before connection");
			con = DriverManager.getConnection(url, userid, pwd);
		} catch (SQLException e) {
			System.out.println("database connection failure");
		}
	}

	private void sqlRun() {
		String query = "SELECT * FROM Book";
		try {
			//	createStatement() : 만들 준비 작업
			Statement stmt = con.createStatement();
			//	executeQuery : select문 실행
			//	ResultSet : query를 실행한 결과가 전달
			ResultSet rs = stmt.executeQuery(query);
			System.out.println(" BOOK NO\tBOOK NAME\t\tPUBLISHER\tPRICE");
			while (rs.next()) {
				System.out.print("\t" + rs.getInt(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t\t" + rs.getString(3));
				System.out.print("\t" + rs.getInt(4));
				System.out.println();
			}
			con.close();
		} catch (SQLException e) {
			
		}
		
	}
	
	
	public static void main(String[] args) {
		//	생성자에서 DB 연결 작업까지 완료함
		BookListEx1 so = new BookListEx1();
		
		//	sql문 실행
		so.sqlRun();
	}
}
