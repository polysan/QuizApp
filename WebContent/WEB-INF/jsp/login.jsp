<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%
ArrayList<String> error = (ArrayList<String>) request.getAttribute("error");
String errorMsg = (String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<title>ログイン画面</title>
<%@include file="../html/head.html" %>
</head>
<body>
<div id="home" class="big-bg">

	<%@include file="../html/header.html" %>

	<div class="login-content">
		<%if(error.size() > 0){%>
		  <%for(int i = 0; i < error.size() ; i++){%>
		<p><%= error.get(i)%></p>
		<%}}%>
		<%if(errorMsg != null){%>
		<p><%= errorMsg %></p>
		<%}%>
		<form action="/Quiz/Login" method="post">
		<input type="text" placeholder="ログイン ID" name="name"><br>
		<input type="password" placeholder="パスワード" name="pass"><br>
		<input type="submit" value="ログイン"><br>
		</form>
		<a href="/Quiz/">戻る</a>
	</div>
</div>
</body>
</html>