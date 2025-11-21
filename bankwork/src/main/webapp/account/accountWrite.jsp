<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bank.css">
<script type="text/javascript" src="script/bank.js"></script>
</head>
<body>
	<div id="wrap" align="center">
		<h1>계좌 등록</h1>
		<form action="accountWrite.do" method="post" >
			<table>
				<tr>
					<th>계좌번호</th>
					<td><input type="text" name="account" size="80"></td>
				</tr>
				<tr>
					<th>예금주명</th>
					<td><input type="text" name="name" size="80"></td>
				</tr>
				<tr>
					<th>계좌별명</th>
					<td><input type="text" name="alias" size="80"></td>
				</tr>
				<tr>
					<th>휴대폰번호</th>
					<td><input type="text" name="phone" size="80"></td>
				</tr>
				<tr>
					<th>입금액</th>
					<td><input type="text" name="balance"> 원</td>
				</tr>
			</table>
			<input type="hidden" name="status" size="80" readonly value="정상">
			<br> 
			<input type="submit" value="등록" onclick="return accountCheck()"> 
            <input type="reset" 	value="다시작성"> 
            <input type="button" value="목록" onclick="location.href='accountList.do'">
		</form>
	</div>
</body>
</html>