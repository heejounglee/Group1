<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bank.css">
<script type="text/javascript" src="script/bank.js"></script>
</head>
<body>
	<div id="wrap" align="center">
		<h1>입금/출금</h1>

		<form action="depositUpdate.do" method="post">
		<table>
		<tr>
		<th>계좌번호</th>
		<td><input type= "text" name="account" size="80" style="background-color: lightgray; border:none; padding: 4px;" value='${account}' readonly></td>
		</tr>

		<tr>
		<th>예금주명</th>
		<td><input type="text" name="name" size="80" style="background-color: lightgray; border:none; padding: 4px;" value='${name}' readonly></td>
		</tr>

		<tr>
		<th>입출금구분</th>
		<td>
		<select name="flag">
        <option value="입금">입금</option>
		<option value="출금">출금</option>
        </select>
		</td>
		</tr>
				
		<tr>
		<th>금액</th>
		<td><input type="number" name="money" required></td>
		</tr>
				
			</table>

			<br> <input type="submit" value="거래실행"> <input
				type="button" value="목록" onclick="location.href='accountList.do'">
		</form>
	</div>
</body>
</html>
