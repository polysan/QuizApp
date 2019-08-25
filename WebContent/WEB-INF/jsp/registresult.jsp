<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
boolean resultregist = (boolean)request.getAttribute("CANNEWREGIST");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録結果画面</title>
</head>
<body>
 <%if(resultregist == true){%>
<p>登録に成功しました</p>
<%}else{%>
<p>登録できませんでした</p>
<%}%>
<a href="/Quiz/login">ログイン画面へ</a>
</body>
</html>