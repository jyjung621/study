package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao {
	private Connection getConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return conn;
	}

	public int insert(MemberDto member) throws SQLException {
		Connection conn = null;
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into member1 values ( ?,?,?,sysdate)";
		try {
			conn = getConnection(); // 기존에 연결된 DBCP 이용
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

		return result;
	}

	public int check(String id, String password) throws SQLException {
		Connection conn = null;
		int result = 0;
		ResultSet rs = null;
		Statement stmt = null;
		String sql = String.format("select id, password from member1 where id='%s'", id);
		try {
			conn = getConnection();
			stmt = conn.createStatement();
//			System.out.println("check id ->  " + id );
//			System.out.println("check pw ->  " + password );
			rs = stmt.executeQuery(sql);
//			System.out.println("sql -> " + sql);

			if (rs.next()) { // id가 일치할 경우... db에서 rs로 넘어옴
//				String dbID = rs.getString(1);
				String dbPassword = rs.getString(2);
//				System.out.println("dbID -> " + dbID);
//				System.out.println("dbPassword -> " + dbPassword);
				// password 일치할 경우 result = 1;
				if (dbPassword.equals(password)) {
					result = 1;
				// password 일치x result=0;
				} else {
					result = 0;
				}
			} else { // id가 일치하지 않을 경우
				result = -1;
			}

		} catch (Exception e) {
			System.out.println("이거뜨는거임? -> " + e.getMessage());
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

		return result;
	}

}
