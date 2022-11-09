<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	let loginCheck = '${sessionScope.uid}';
/* alert(loginCheck.length)  */;
	if(loginCheck.length == 0){
		alert('로그인 후 이용 가능 합니다.');
		location.href ="${pageContext.request.contextPath}/Member/MemberLogin.jsp";
	}
</script>
<style type="text/css">
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/MainStyle.css">
</head>
<body>
	<div class="header">
		<h1>BoardWrite</h1>
		<c:if test="${sessionScope.uid != null}">
			<p>${sessionScope.uid}님 반갑습니다.</p>
		</c:if>
	</div>
	<%@include file="/menu.jsp"%>

	<div class="contents">
		<h3 style="text-align:center;"> 글 작성</h3>
		<form action="${pageContext.request.contextPath}/BoardWrite" method="post">
			<table>
				<tr>
					<th>글제목</th>
					<td><input type="text" name="btitle"></td>
					<td><input type="hidden" name="bwriter" value="${sessionScope.uid}">
				</tr>
				<tr>
					<th>글내용</th>
					<td><textarea rows="" cols="" name="bcontent"></textarea></td>
				</tr>
				<tr>
					<th colspan="2">
						<input type="submit" value="글 작성">
						<input type="reset" value="다시 입력">
					</th>
				</tr>
			</table>
		</form>
	</div>
	<div class="footer">
		<h2>회원제 게시판</h2>
	</div>
</body>
</html>