<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bank.css">
</head>
<body>
    <div id="wrap" align="center">
		<h1>거래내역조회</h1>
		<table class="list">
			<tr>
				<th>계좌번호</th>
				<th>예금주</th>
				<th>거래일시</th>
				<th>구분</th>
				<th>거래금액</th>
				<th>잔고</th>
				<th>메모</th>
			</tr>
			<c:forEach var="deposit" items="${depositList}">
				<tr class="record">
					<td>${deposit.account}</td>
					<td>${deposit.name}</td>
					<td><fmt:formatDate value="${deposit.depositdate}" pattern="yyyy/MM/dd"/></td>
					<td>${deposit.flag}</td>
					<td>${deposit.money}원</td>
					<td>${deposit.balance}원</td>
					<td>${deposit.memo}</td>
				</tr>
			</c:forEach>
		</table>
		<br> <br> 
        <input type="button" value="내계좌 정보" onclick="location.href='accountList.do'">
        <br> <br> 
	</div>
</body>
</html>