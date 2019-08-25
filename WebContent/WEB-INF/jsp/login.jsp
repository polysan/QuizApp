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
<meta charset="UTF-8">
<title>トップ画面</title>
</head>
<body>
<h1>ようこそ</h1>
<%if(error.size() > 0){%>
  <%for(int i = 0; i < error.size() ; i++){%>
<p><%= error.get(i)%></p>
<%}}%>
<%if(errorMsg != null){%>
<p><%= errorMsg %></p>
<%}%>
<form action="/Quiz/login" method="post">
ログインID：<input type="text" name="name"><br>
パスワード：<input type="password" name="pass"><br>
<input type="submit" value="ログイン"><br>
</form>
<a href="/Quiz/">戻る</a>
</body>
</html>