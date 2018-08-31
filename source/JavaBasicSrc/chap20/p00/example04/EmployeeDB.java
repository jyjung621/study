package p00.example04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDB {
	Connection con;

	public EmployeeDB() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String userid = "scott";
		String passwd = "scott";

		try {
			Class.forName(driver);
		} catch (Exception e) {
			System.out.println("driver load failure!");
		}

		try {
			System.out.println("before connection");
			con = DriverManager.getConnection(url, userid, passwd);
			System.out.println("success connection");
		} catch (SQLException e) {
			System.out.println("Oracle database connection failure");
		}
	}

	// (1) 사원의 이름과 직위를 출력하시오.
	public void employeeNameJob() {

		try {
			String query = "SELECT ename, job FROM emp";

			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			System.out.println("\t사원이름 \t사원직위");
			while (rs.next()) {
				System.out.print("\t" + rs.getString(1));
				System.out.print("\t" + rs.getString(2));
				System.out.println();
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("employeeNameJob search error");
		}
	}
	
	//	(3) 사원 번호와 이름, 현재 급여와 10% 인상된 급여(열 이름은 ‘인상된 급여’)를 출력하시오. 
	//	단, 사원 번호순으로 출력한다. 증가된 급여분에 대한 열 이름은 ‘증가액’으로 한다.
	public void employeeSal(double increase) {

		try {
			String query = "SELECT empno, ename, sal, sal*?  FROM emp";

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setDouble(1, increase);
			ResultSet rs = pstmt.executeQuery();

			System.out.println("\t사원번호 \t사원이름 \t현재급여 \t인상된급여 \t증가액");
			while (rs.next()) {
				System.out.print("\t" + rs.getString(1));
				System.out.print("\t" + rs.getString(2));
				System.out.println();
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("employeeNameJob search error");
		}
	}

}
