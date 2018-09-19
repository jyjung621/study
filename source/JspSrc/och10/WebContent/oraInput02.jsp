<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="och10.Dept"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String sql = "insert into dept values (?,?,?)";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, "scott", "tiger");

		//	보안에 더욱 강력한 방법
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, deptno);
		pstmt.setString(2, dname);
		pstmt.setString(3, loc);

		int result = pstmt.executeUpdate();
		if (result > 0) {
			System.out.println("입력성공 ^^");
		} else {
			System.out.println("입력실패 ㅜㅜ");
		}
		
		pstmt.close(); conn.close();
	%>
</body>
</html>