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
	th{
	border-right:2px solid teal;
	}
	td, th{
		border-bottom: 2px solid teal;	
	}
	button{
		margin : 0 30px;
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
<c:if test="${requestScope.content != null }">
	<table>
		<tr>
			<th>제목 </th>
			<td>${requestScope.content.bTitle}</td>
		</tr>
		<tr>
			<th>작성자 </th>
			<td>${requestScope.content.bWriter}</td>
		</tr>
			<th>작성일 </th>
			<td>${requestScope.content.bDate }</td>
		<tr>
		<th> 내용 </th>
		<td>${requestScope.content.bContent}</td>
		</tr>
		<tr>
		<th> 조회수 </th>
		<td>${requestScope.content.bHits}</td>
		</tr>
		<c:if test="${sessionScope.uid == requestScope.content.bWriter}">
		<tr>
		<th colspan="2">
		<button type="button" onclick="updateBoard()">수정</button>
		<button type="button" onclick="deleteBoard()">삭제</button>
		</th>
		</tr>
		</c:if>
	</table>
</c:if>
</div>
<div class="footer">
	<h2>회원제 게시판</h2>
</div>
<script>
	function updateBoard(){
		location.href = "${pageContext.request.contextPath}/BoardModify?bno=${requestScope.content.bNo}";
	}
	function deleteBoard(){
		location.href = "${pageContext.request.contextPath}/BoardDelete?bno=${requestScope.content.bNo}";
	}
</script>
</body>
</html>