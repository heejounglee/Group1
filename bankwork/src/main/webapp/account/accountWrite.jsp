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
		'*' 표시 항목은 필수 입력 항목입니다.
		<form action="accountWrite.do" method="post" name="frm">
			<table>
				<tr>
					<th>*계좌번호</th>
					<td><input type="text" name="acct1" size="15" placeholder="숫자3자리">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-</td>
					<td><input type="text" name="acct2" size="15" placeholder="숫자2자리">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-</td>
					<td><input type="text" name="acct3" size="15" placeholder="숫자3자리"></td>
				</tr>
				<tr>
					<th>*예금주명</th>
					<td colspan="3"><input type="text" name="name" size="80" style="background-color: lightgray;" value='${name}' readonly></td>
				</tr>
				<tr>
					<th>계좌별명</th>
					<td colspan="3"><input type="text" name="alias" size="80" placeholder="10자리이내"></td>
				</tr>
				<tr>
					<th>*휴대폰번호</th>
					<td colspan="3"><input type="text" name="phone" size="80" placeholder="-포함하여 입력해주세요."></td>
				</tr>
				<tr>
					<th>*입금액</th>
					<td colspan="3"><input type="number" name="balance"> 원</td>
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