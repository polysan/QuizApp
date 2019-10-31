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
<title>マイページ</title>
<%@include file="../html/head.html" %>
</head>
<body>
<div id="home" class="big-bg">
	<%@include file="../html/header.html" %>
	<main class="wrapper">
		<div class="mypage-top" >
			<h1>MyPage</h1>
			<p>${USER.name}さんがログイン中</p>
		</div>
		<div class="mypage-middle" >
			<p>過去の成績</p>
			<table>
				<tr>
					<th>得点</th>
					<th>正解数</th>
					<th>問題数</th>
				</tr>
				<tr>
					<td>10</td>
					<td>1</td>
					<td>10</td>
				</tr>
				<tr>
					<td>20</td>
					<td>2</td>
					<td>10</td>
				</tr>
				<tr>
					<td>30</td>
					<td>3</td>
					<td>10</td>
				</tr>
				<%-- <%if(qizresultmap != null){ %>
				<p>${USER.name}さんの過去の成績</p><br>
				<p><%= anscount.get(0) %>/<%= quescount.get(0) %></p>
				<p><%= anscount.get(1) %>/<%= quescount.get(1) %></p>
				<p><%= anscount.get(2) %>/<%= quescount.get(2) %></p>
				<%}%> --%>
			</table>
		</div>
		<div class="mypage-bottom">
			<a href="/Quiz/Question">クイズへ進む</a><br>
			<a href="/Quiz/Logout" >ログアウト</a>
		</div>
	</main>
</div>
</body>
</html>