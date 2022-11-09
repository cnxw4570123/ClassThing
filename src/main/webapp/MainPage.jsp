<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/MainStyle.css">
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

</div>
<div class="footer">
	<h2>회원제 게시판</h2>
</div>
</body>
</html>