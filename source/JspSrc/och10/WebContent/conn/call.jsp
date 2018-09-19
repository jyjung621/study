<%@page import="java.sql.Types"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 프로시저 호출 -->
	<%
		Context cxt = new InitialContext();
		DataSource ds = (DataSource)cxt.lookup("java:comp/env/jdbc/OracleDB");
		Connection conn = ds.getConnection();
		
		String sql = "{call Emp_Info3(?,?)}";
		CallableStatement cs = conn.prepareCall(sql);
		//	.registerOutParameter => 파라미터 값 가져옮
		cs.registerOutParameter(2, Types.DOUBLE);
		//	.setInt => 파라미터 값 세팅
		cs.setInt(1, 7521);
		cs.execute();
		
		out.println("급여 : " + cs.getDouble(2));
		cs.close();
		conn.close();
	%>
</body>
</html>