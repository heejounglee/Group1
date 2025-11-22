<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 등록 실패</title>
</head>
<body>
    <h2>계좌 등록 실패</h2>
    <h3>${loginUser.name}(${loginUser.userid})님</h3>
    <form id='returnForm' action="login.do" method="post" name="frm">
    <input type="hidden" name="userid" value="${loginUser.userid}">
    <input type="hidden" name="pwd" value="${pwd}">
    <p>
       <%= request.getAttribute("errorMessage") %>
    </p>
    <a href="#" onclick="javascript: document.getElementById('returnForm').submit()">홈으로 돌아가기</a>
    
    </form>
</body>
</html>