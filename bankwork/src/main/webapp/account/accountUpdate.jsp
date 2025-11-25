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
      <h1>계좌 정보 수정</h1>
      <form action="accountUpdate.do" method="post"> 
      <table>
         <tr>
            <th>계좌번호</th>
            <td style="background-color: lightgray; border:none; padding: 4px;">${accountOne.account}
            <input type="hidden" id="account" name="account" value="${accountOne.account}">
            </td>
         </tr>
         <tr>
            <th>계좌별명</th>
            <td><input type="text" id="alias" name="alias" value="${accountOne.alias}"></td>
         </tr>
         <tr>
	         <th>휴대폰번호</th>
	         <td><input type="text" id="phone" name="phone" value="${accountOne.phone}"></td>
         </tr>
	     <tr>
	        <th>계좌상태</th>
	        <td>
	            <select id="accountStatus" name="accountStatus">
	                <option value="정상" <c:if test="${accountOne.status == '정상'}">selected</c:if>>정상</option>
	                <option value="중지" <c:if test="${accountOne.status == '중지'}">selected</c:if>>중지</option>
	            </select>
	        </td>
	     </tr>
    
      </table>
      <br> <br> 
      <input type="submit" value="저장">
      <input type="button" value="계좌목록" onclick="location.href='accountList.do'">
	  </form>
   </div>
</body>
</html>