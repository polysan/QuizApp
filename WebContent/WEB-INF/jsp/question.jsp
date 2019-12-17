<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.QuizCount" %>
<%@ page import="model.QuizOneSet" %>

<%
	/*Map<String,List<String>> QAMAP = (Map<String,List<String>>)session.getAttribute("QAMAP");  */
	QuizOneSet[] questionlist = (QuizOneSet[])session.getAttribute("QUESTIONLIST");
	QuizCount quizcount = (QuizCount)session.getAttribute("QUIZCOUNT");
	String errorMsg = (String)request.getAttribute("errorMsg");

	int qesnum = quizcount.getQuesCount();
	QuizOneSet qesset  = questionlist[qesnum--];
	String aa = qesset.getQuestion();
	String[] bb = qesset.getAnswers();
/*String key = "";
List<String> answer = new ArrayList<String>();
for (Map.Entry<String,List<String>> bar : QAMAP.entrySet()) {
	key = bar.getKey();
	answer = bar.getValue();
} */
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
		<p>問<%=qesnum%>.<%= aa %></p>
		<%if(errorMsg != null){%>
		<p><%= errorMsg %></p>
		<%}%>
		<form action="/Quiz/Question" method="get">
		<input type="radio" name="ques" value='good' id="kaito-1"><label for="kaito-1"><%=bb[0] %></label><br>
		<input type="radio" name="ques" value='bad' id="kaito-2"><label for="kaito-2"><%=bb[1] %></label><br>
		<input type="radio" name="ques" value='bad' id="kaito-3"><label for="kaito-3"><%=bb[2] %></label><br>
		<input type="radio" name="ques" value='bad' id="kaito-4"><label for="kaito-4"><%=bb[3] %></label><br>

		<!-- 隠しパラメーター -->
		<input type="hidden" name="action" value="kaitotyu">

		<input type="submit" value="進む">
	</div>
</div>
</form>
</body>
</html>