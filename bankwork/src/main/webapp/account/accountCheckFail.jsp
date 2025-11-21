<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류 발생</title>
</head>
<body>
    <h2>오류 발생</h2>
    <p>
        ${requestScope.message} 
    </p>
    <a href="index.jsp">홈으로 돌아가기</a>
</body>
</html>