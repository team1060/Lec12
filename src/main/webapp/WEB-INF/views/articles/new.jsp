<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/articles/create" method="post">
    <div>
        <label for="title">제목</label>
        <input type="text" name="title" id="title">
    </div>
    <div>
        <label for="content">내용</label>
        <input type="text" name="content" id="content">
    </div>
    <input type="submit" value="글자입력">
    <a href="/articles">글보기</a>
</form>
</body>
</html>