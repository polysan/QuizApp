<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.SelectQuizResultDao" %>
<%@ page import="model.User" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
<%
List <Integer> anscount = new ArrayList <Integer>();
List <Integer> quescount = new ArrayList <Integer>();

User loginUser = (User) session.getAttribute("USER");
selectQuizResultdao aa = new selectQuizResultdao();
Map<List <Integer>,List <Integer>> qizresultmap = aa.selectQuizResult(loginUser);
if(qizresultmap != null){
	for (Map.Entry<List <Integer>,List <Integer>> bar : qizresultmap.entrySet()) {
		anscount = bar.getKey();
		quescount = bar.getValue();
	}
}
%>
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ</title>
</head>
<body>
<h1>${USER.name}さんがログイン中</h1>
<%-- <%if(qizresultmap != null){ %>
<p>${USER.name}さんの過去の成績</p><br>
<p><%= anscount.get(0) %>/<%= quescount.get(0) %></p>
<p><%= anscount.get(1) %>/<%= quescount.get(1) %></p>
<p><%= anscount.get(2) %>/<%= quescount.get(2) %></p>
<%}%> --%>
<a href="/Quiz/Question">クイズへ進む</a><br>
<a href="/Quiz/Logout">ログアウト</a>
</body>
</html>