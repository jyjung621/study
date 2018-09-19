<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String sql = "delete from dept where deptno=?";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, "scott", "tiger");
		Statement stmt = conn.createStatement();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, deptno);

		int result = pstmt.executeUpdate();
		if (result > 0) {
			out.println("삭제성공 ^^");
		} else {
			out.println("삭제실패 ㅜㅜ");
	%>

	<script type="text/javascript">
		alert("없는부서잖아!!!");
		location.href = "deptDel.html";
	</script>
	<%
		}
	%>


</body>
</html>