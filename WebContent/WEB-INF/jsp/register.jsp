<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String errorMsg = (String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録画面</title>
</head>
<body>
<%if(errorMsg != null){%>
<p><%= errorMsg %></p>
<%}%>
<form action="/Quiz/Register" method="post">
ID：<input type="text" name="name"><br>
パスワード：<input type="password" name="pass"><br>
<input type="submit" value="確認">
</form>
<a href="/Quiz/">戻る</a>
</body>
</html>