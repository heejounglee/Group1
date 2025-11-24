<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bank.css">
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>
   <div id="wrap" align="center">
      <h1>계좌 등록 완료</h1>
      <table>
         <tr>
            <th>계좌번호</th>
            <td>${account.account}</td>
         </tr>
         <tr>
            <th>예금주명</th>
            <td>${account.name}</td>
         </tr>
         <tr>
            <th>계좌별명</th>
            <td>${account.alias}</td>
         </tr>
         <tr>
            <th>휴대폰</th>
            <td>${account.phone}</td>
         </tr>
         <tr>
            <th>입금</th>
            <td>${account.balance}</td>
         </tr>
         <tr>
            <th>계좌상태</th>
            <td colspan="3">${account.status}</td>
         </tr>
      </table>
      <br> <br> 
      <input type="button" value="내계좌 정보" onclick="location.href='accountList.do'">
   </div>
</body>
</html>