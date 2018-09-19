<%@page import="och10.Emp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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

		//		실무에서 많이 쓰이는 방식
		ArrayList<Emp> al = new ArrayList<Emp>();
		String sql = "select * from emp";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		if (rs.next()) {
			//	여러개의 Row가 넘어온다면 반복문으로 처리 할 것
			do {
				Emp emp = new Emp();	//	DTO
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setSal(rs.getInt(6));
				
				al.add(emp);
			} while(rs.next());
			
			request.setAttribute("al", al);
			
			rs.close();	stmt.close(); conn.close();

			RequestDispatcher rd = request.getRequestDispatcher("ora05Result.jsp");
			rd.forward(request, response);
			/* RequestDispatcher rd = request.getRequestDispatcher("ora05Result2.jsp");
			rd.forward(request, response); */
			
		} else {
			out.println("그게 무슨 부서야 없는데...");
			stmt.close(); conn.close();
		}
	%>
</body>
</html>