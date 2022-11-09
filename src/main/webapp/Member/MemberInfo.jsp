<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/MainStyle.css">
<style>
	table{
		display:inline;
	}
</style>
</head>
<body>
<div class="header">
<h1>mainPage</h1>
<c:if test="${sessionScope.uid != null}">
<p>${sessionScope.uid}님 반갑습니다.</p>
</c:if>
</div>
<%@include file="/menu.jsp" %>

<div class="contents">
<table>
	<tr>
		<th>아이디</th>
		<td>${requestScope.member.mid}</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td>${requestScope.member.mpw}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${requestScope.member.mname}</td>
	</tr>
	<tr>
		<th>생년월일</th>
		<td>${requestScope.member.mbirth}</td>
	</tr>
	<tr>
		<th>주소</th>
		<td>${requestScope.member.maddr}</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${requestScope.member.memail}</td>
	</tr>
</table>
<table>
	<tr>
		<th></th>
		<td></td>
	</tr>
</table>	
</div>
<div class="footer">
	<h2>회원제 게시판</h2>
</div>
</body>
</html>