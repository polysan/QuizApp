<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録確認</title>
</head>
<body>
<p>ID:${REGISTUSER.name}</p><br>
<p>上記のIDで登録でします。<br>よろしいですか？</p>
<a href="/Quiz/Register?action=done">登録</a><br>
<a href="/Quiz/Register">戻る</a>
</body>
</html>