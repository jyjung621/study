<%@page import="och12.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="Error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ConfirmID Process</title>
<%
	String id = request.getParameter("id");
%>
	<script type="text/javascript">
		function wincl() {
			opener.document.frm.id.value="<%=id%>";
			window.close();
		}
	</script>
</head>
<body>
	<%
		MemberDao md = MemberDao.getInstance();
		int result = md.confirm(id);
		if(result == 0) {
	%>
		<%-- 
			EL표기법 사용방법
			
			1. Attribute 형식
				<%=cnt+1%> ==> ${cnt+1}
			2. Parameter형식
				${param.abc}
				
			[ attribute란? : 메소드를 통해 저장되고 관리되는 데이터 ]

			PageContext / Request에서 사용될때
			setAttribute("key", value) → 값을 넣는다.
			getAttribute("key") → 값을 가져온다.
			removeAttribue("key") → 값을 지운다.
			
			session에서 사용될때
			set / get / remove 동일하고 추가로++
			invalidate( ) → 값을 전부 지운다.
				
			출처: https://hunit.tistory.com/203 [Ara Blog]
				
		 --%>
		<p>${param.id }는 사용할수 있습니다.</p>
		<input type="button" value="닫기" onclick="wincl()">
	<%
		} else {
	%>
		<p><%=id %>는 이미 있는 아이디 입니다. 다른 것을 입력하세요.</p>
		<form action="">
			<p>아이디 : <input type="text" name="id"></p>
			<input type="submit" value="확인">
		</form>
	<%
		}
	%>

</body>
</html>