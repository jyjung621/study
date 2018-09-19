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
		String deptno = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, "scott", "tiger");

		//	보안에 취약함
		String sql = String.format("insert into dept values (%s, '%s', '%s')", deptno, dname, loc);
		System.out.println("sql->"+sql);
		
		
		Statement stmt = conn.createStatement();

		int result = stmt.executeUpdate(sql);
		if (result > 0) {
			out.println("입력성공 ^^");
		} else {
			out.println("입력실패 ㅜㅜ");
		}
		
		stmt.close(); conn.close();
	%>
</body>
</html>