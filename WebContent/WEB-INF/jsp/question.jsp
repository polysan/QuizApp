<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.QuizCount" %>
<%@ page import="model.QuizOneSet" %>

<%
	QuizOneSet[] questionlist = (QuizOneSet[])session.getAttribute("QUESTIONLIST");
	QuizCount quizcount = (QuizCount)session.getAttribute("QUIZCOUNT");
	String errorMsg = (String)request.getAttribute("errorMsg");

	int quesnum = quizcount.getQuesCount();
	QuizOneSet qesset  = questionlist[quesnum-1];
	String question = qesset.getQuestion();
	String[] answers = qesset.getAnswers();

%>
<!DOCTYPE html>
<html>
<head>
<title>問題</title>
<%@include file="../html/head.html" %>
</head>
<body>
<div id="home" class="big-bg">
	<%@include file="../html/header.html" %>
	<div class="quiz-content">
		<p>問<%=quesnum%>.<%= question %></p>
		<%if(errorMsg != null){%>
		<p><%= errorMsg %></p>
		<%}%>
		<form action="/Quiz/Question" method="get">
		<input type="radio" name="ques" value=<%=answers[0] %> id="kaito-1"><label for="kaito-1"><%=answers[0] %></label><br>
		<input type="radio" name="ques" value=<%=answers[1] %> id="kaito-2"><label for="kaito-2"><%=answers[1] %></label><br>
		<input type="radio" name="ques" value=<%=answers[2] %> id="kaito-3"><label for="kaito-3"><%=answers[2] %></label><br>
		<input type="radio" name="ques" value=<%=answers[3] %> id="kaito-4"><label for="kaito-4"><%=answers[3] %></label><br>

		<!-- 隠しパラメーター -->
		<input type="hidden" name="action" value="kaitotyu">

		<input type="submit" value="進む">
	</div>
</div>
</form>
</body>
</html>