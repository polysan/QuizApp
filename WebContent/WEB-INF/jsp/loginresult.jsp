<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
 <%
 User loginUser = (User) session.getAttribute("USER");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン成功画面</title>
</head>
<body>
<h1><%= loginUser.getName() %>さんがログインしました</h1>
<a href="/Quiz/Main">マイページへ</a>
</body>
</html>