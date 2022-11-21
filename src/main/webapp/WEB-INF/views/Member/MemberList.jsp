<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table,th,td{
		border:1px solid rgb(22 116 80);
		width:400px;
	}
	.mBirth{
		width: 1000px;
	}
</style>
</head>
<body>
<h1>회원목록</h1>
<hr>
<br>
<table>
	<tr><th colspan="4">회원목록</th></tr>
	<tr>
	<th>아이디</th>
	<th>비밀번호</th>
	<th>이름</th>
	<th>생년월일</th>
	</tr>
	<c:forEach items="${requestScope.memberList}" var="member">
	<tr>
	<td>${member.testId}</td>
	<td>${member.testPw}</td>
	<td>${member.testName}</td>
	<td class="mBirth">${member.testBirth}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>