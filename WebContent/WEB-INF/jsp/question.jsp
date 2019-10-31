<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.QuizCount" %>

<%
	Map<String,List<String>> QAMAP = (Map<String,List<String>>)session.getAttribute("QAMAP");
	QuizCount quizcount = (QuizCount)session.getAttribute("QUIZCOUNT");
	String errorMsg = (String)request.getAttribute("errorMsg");

String key = "";
List<String> answer = new ArrayList<String>();
for (Map.Entry<String,List<String>> bar : QAMAP.entrySet()) {
	key = bar.getKey();
	answer = bar.getValue();
}
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
		<p>問<%=quizcount.getQuesCount()%>.<%= key %></p>
		<%if(errorMsg != null){%>
		<p><%= errorMsg %></p>
		<%}%>
		<form action="/Quiz/Question" method="get">
		<input type="radio" name="ques" value='good' id="kaito-1"><label for="kaito-1"><%=answer.get(0) %></label><br>
		<input type="radio" name="ques" value='bad' id="kaito-2"><label for="kaito-2"><%=answer.get(1) %></label><br>
		<input type="radio" name="ques" value='bad' id="kaito-3"><label for="kaito-3"><%=answer.get(2) %></label><br>
		<input type="radio" name="ques" value='bad' id="kaito-4"><label for="kaito-4"><%=answer.get(3) %></label><br>
		<!-- 隠しパラメーター -->
		<input type="hidden" name="action" value="kaitotyu">
		<!-- 隠しパラメーター -->
		<input type="submit" value="進む">
	</div>
</div>
</form>
</body>
</html>