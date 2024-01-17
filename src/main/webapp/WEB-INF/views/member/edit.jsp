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
<form action="/member/update" method="post">
<input type="hidden" name="id" value="${id }">
    <div>
        <label for="email">이메일</label>
        <input type="text" name="email" id="email" value="${member.email}">
    </div>
    <div>
        <label for="password">비밀번호</label>
        <input type="text" name="password" id="password" value="${member.password}">
    </div>
    <input type="submit" value="수정">
    <a href="/member/${id }">회원</a>
    
</form>
</body>
</html>