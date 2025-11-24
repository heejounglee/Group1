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
      <h1>내계좌 정보</h1>
      <input type="button" value="계좌 등록" onclick="location.href='accountWrite.do'">
      <br>
      <table>
         <tr>
            <th>계좌번호</th>
            <th>계좌별명</th>
            <th>휴대폰</th>
            <th>계좌상태</th>
            <th>수정</th>
            <th>입출금</th>
            <th>거래내역</th>
         </tr>
         <c:forEach var="account" items="${accountList}">
		 <tr class="record">
			<td  align="center">${account.account}</td>
            <td  align="center">${account.alias}</td>
            <td  align="center">${account.phone}</td>
            <td  align="center">${account.status}</td>
            <td  align="center"><input type="button" value="수정" onclick="location.href='accountUpdate.do?account=${account.account}'"></td>
            <td  align="center"><input type="button" value="실행" onclick="location.href='depositUpdate.do?account=${account.account}'"></td>
            <td  align="center"><input type="button" value="조회" onclick="location.href='depositList.do?account=${account.account}'"></td>
		</tr>
		 </c:forEach>
      </table>
      <br><br>
   </div>
</body>
</html>