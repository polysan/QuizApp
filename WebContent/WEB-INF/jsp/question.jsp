<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Quiz_count" %>

<%
 Map<String,List<String>> QAMAP = (Map<String,List<String>>)session.getAttribute("QAMAP");
	Quiz_count quizcount = (Quiz_count)session.getAttribute("QUIZCOUNT");
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
<meta charset="UTF-8">
<title>問題</title>
</head>
<body>
<p>問<%= quizcount.getQues_count() %>.<%= key %></p>
<%if(errorMsg != null){%>
<p><%= errorMsg %></p>
<%}%>
<form action="/Quiz/Question" method="get">
<input type="radio" name="ques" value='good'><%=answer.get(0) %><br>
<input type="radio" name="ques" value='bad'><%=answer.get(1) %><br>
<input type="radio" name="ques" value='bad'><%=answer.get(2) %><br>
<input type="radio" name="ques" value='bad'><%=answer.get(3) %><br>
<input type="hidden" name="action" value="kaitotyu">
<input type="submit" value="進む">
</form>
</body>
</html>