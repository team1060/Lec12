<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/member/create" method="post">
    <div>
        <label for="password">이메일</label>
        <input type="text" name="email" id="email">
    </div>
    <div>
        <label for="password">패스워드</label>
        <input type="text" name="password" id="password">
    </div>
    <input type="submit" value="회원가입">
    <a href="/member">글보기</a>
</form>
</body>
</html>