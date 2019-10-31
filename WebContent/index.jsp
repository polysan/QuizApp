<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>トップ画面</title>
<meta charset="UTF-8">
<%@include file="WEB-INF/html/head.html" %>
</head>

<body>
<div id="home" class="big-bg">
	<%@include file="WEB-INF/html/header.html" %>
	<div class="home-content wrapper">
		<h2 class="page-title">養豚検定</h2>
		<p>養豚検定は養豚に関する知識をクイズで試すことができます</p>
		<section class="buttons">
			<a class="button" href="/Quiz/Login">ログイン</a><br>
			<a class="button" href="/Quiz/Register">ユーザー登録</a><br>
			<a class="button" href="/">ログインせずに<br>クイズに進む</a><br>
		</section>
		<p>※ログインすると検定結果を記録することができます</p>
	</div><!-- home-content -->
</div><!-- home -->
</body>
</html>