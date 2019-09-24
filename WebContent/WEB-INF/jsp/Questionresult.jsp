<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Quiz_count" %>
<%
Quiz_count quizcount = (Quiz_count)session.getAttribute("QUIZCOUNT");
int quescount = quizcount.getQues_count();
quescount--;
int kaitocount = quizcount.getKaito_count();
session.removeAttribute("QUIZCOUNT");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>クイズ結果</title>
</head>
<body>
<h1>結果</h1>
<p><%= quescount %>問中,<%= kaitocount %>問正解！</p>
<a href="/Quiz/Main">メイン画面に戻る</a>
</body>
</html>