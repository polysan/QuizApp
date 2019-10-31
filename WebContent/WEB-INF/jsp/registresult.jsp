<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
boolean resultregist = (boolean)request.getAttribute("CANNEWREGIST");
%>
<!DOCTYPE html>
<html>
<head>
<title>新規登録結果画面</title>
<%@include file="../html/head.html" %>
</head>
<body>
<div id="home" class="big-bg">
	<%@include file="../html/header.html" %>
	<div class="register-content">
		 <%if(resultregist == true){%>
		<p>登録に成功しました</p>
		<%}else{%>
		<p>登録できませんでした</p>
		<%}%>
		<div class="registresult-button">
			<a href="/Quiz/Login">ログイン画面へ</a>
		</div>
	</div>
</div>
</body>
</html>