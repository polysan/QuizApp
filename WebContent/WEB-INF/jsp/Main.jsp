<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>メインです</h1>
<p>${USER.name}さんがログイン中</p>
<a href="/Quiz/logout">ログアウト</a><br>
<!-- <a href="/Quiz/Question1">クイズへ進む</a> -->
<a href="/Quiz/Question">クイズへ進む</a>
</body>
</html>