<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page session="false"%>

<script>

var result = '${savedName}';

console.log('여기도착!! -> ' + result);

parent.addFilePath(result);



</script>

