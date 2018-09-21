package ajax;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao {
	//	싱글톤 생성
	private static MemberDao instance;
	
	private MemberDao() {}
	
	public static MemberDao getInstance() {
		if(instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	
	private Connection getConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public int confirm(String id) throws SQLException {
		Connection conn = null;
		int result = 1;
		ResultSet rs = null;
		Statement stmt = null;
		String sql = String.format("select id from member1 where id='%s'", id);
		//System.out.println("sql -> " + sql);
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				result = 1;
			} else {
				result = 0;
			}
			
		} catch (Exception e) {
			System.out.println("confirm Error -> " + e.getMessage());
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
