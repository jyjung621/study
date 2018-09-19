<%@page import="och10.Emp"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../DBError.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String empno = request.getParameter("empno");
		String sql = "Select empno, ename, sal, hiredate from emp where empno=" + empno;

		// context.xml 을 이용하여 자동으로 DB연결 해줌  
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		Connection conn = ds.getConnection();

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		Emp emp = new Emp();
		if (rs.next()) {
			emp.setEmpno(rs.getInt(1));
			emp.setEname(rs.getString(2));
			emp.setSal(rs.getInt(3));
			emp.setHiredate(rs.getDate(4));
			request.setAttribute("emp", emp);
		}
		rs.close();
		stmt.close();
		conn.close();
		RequestDispatcher rd = request.getRequestDispatcher("oraResult.jsp");
		rd.forward(request, response);
	%>
</body>
</html>