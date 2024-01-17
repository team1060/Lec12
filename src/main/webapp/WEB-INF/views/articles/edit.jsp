<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/articles/update" method="post">
<input type="hidden" name="id" value="${id }">
    <div>
        <label for="title">제목</label>
        <input type="text" name="title" id="title" value="${article.title}">
    </div>
    <div>
        <label for="content">내용</label>
        <input type="text" name="content" id="content" value="${article.content}">
    </div>
    <input type="submit" value="글자입력">
    <a href="/articles/${id }">글보기</a>
    
</form>
</body>
</html>