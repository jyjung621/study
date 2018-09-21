<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>파일 업로드</h2>
	<!-- enctype="multipart/form-data" ==> fileUpload를 위한 방법 -->
	<form action="upload.jsp" method="post" enctype="multipart/form-data">
		<p><label for="name">작성자</label> : <input type = "text" name="name" id="name" required="required"></p>
		<p>제목 : <input type="text" name="title" required="required"></p>
		<p>파일명 : <input type="file" name="uploadFile" required="required"></p>
		<input type="submit" value="확인">
	</form>
</body>
</html>