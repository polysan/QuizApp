<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String errorMsg = (String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<title>新規登録画面</title>
<%@include file="../html/head.html" %>
</head>
<body>
<div id="home" class="big-bg">

	<%@include file="../html/header.html" %>

	<div class="login-content">
		<%if(errorMsg != null){%>
	<p><%= errorMsg %></p>
	<%}%>
		<form action="/Quiz/Register" method="post">
		<input type="text" placeholder="登録ID" name="name"><br>
		<input type="password" placeholder="登録パスワード" name="pass"><br>
		<input type="submit" value="　確認　">
		</form>
	<a href="/Quiz/">戻る</a>
	</div>
</div>
</body>
</html>