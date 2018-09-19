<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="och10.Dept"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="DBError.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, "scott", "tiger");
		
		ArrayList<Dept> al = new ArrayList<>();
		
		String sql = "select * from dept order by deptno";
		/* String sql = "select * from dept where deptno=1 order by deptno"; */
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next()) {
			do {
				Dept dept = new Dept();
				dept.setDeptno(rs.getInt(1));
				dept.setDname(rs.getString(2));
				dept.setLoc(rs.getString(3));
				
				al.add(dept);
			} while(rs.next());
			
			request.setAttribute("al", al);
			
			rs.close(); stmt.close(); conn.close();
			
			RequestDispatcher rd = request.getRequestDispatcher("oraDresult.jsp");
			rd.forward(request, response);
			
		} else {
			out.println("뭔가... 잘못된듯 하다...\n 일단 종료하자..");
			stmt.close(); conn.close();
		}
	%>
</body>
</html>