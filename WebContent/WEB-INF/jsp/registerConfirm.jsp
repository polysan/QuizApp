<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>登録確認</title>
<%@include file="../html/head.html" %>
</head>
<body>
<div id="home" class="big-bg">
	<%@include file="../html/header.html" %>
	<div class="register-content">
		<h3>ID : ${REGISTUSER.name}</h3><br>
		<p>上記のIDで登録でします。<br>よろしいですか？</p>
		<div class="register-button">
			<a href="/Quiz/Register?action=done">登録</a>
		</div>
		<a href="/Quiz/Register">戻る</a>
	</div>
</div>
</body>
</html>