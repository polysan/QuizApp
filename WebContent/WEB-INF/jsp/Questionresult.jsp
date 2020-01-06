<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.QuizCount" %>
<%
	QuizCount quizcount = (QuizCount)session.getAttribute("QUIZCOUNT");
int quescount = quizcount.getQuesCount();
quescount--;
int kaitocount = quizcount.getCorrectAnswerCount();
session.removeAttribute("QUIZCOUNT");
%>

<!DOCTYPE html>
<html>
<head>
<title>クイズ結果</title>
<%@include file="../html/head.html" %>
</head>
<body>
<div id="home" class="big-bg">
	<%@include file="../html/header.html" %>
	<div class="quiz-result wrapper">
		<h1><%= quescount %>問中,<%= kaitocount %>問正解！</h1>
		<div class="quiz-result-button">
			<a href="/Quiz/Question">もう一度クイズに挑戦する</a>
			<a href="/Quiz/Main">MyPageに戻る</a>
		</div>
	</div>
</div>
</body>
</html>