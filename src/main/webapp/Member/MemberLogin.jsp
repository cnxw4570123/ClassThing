<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/MainStyle.css">
</head>
<body>
	<div class="header">
		<h1>MemberLogin</h1>
	</div>
	<%@include file="../menu.jsp"%>
	<div class="contents">
		<h3>로그인 양식</h3>
		<form action="${pageContext.request.contextPath}/MemberLogin" method="post">
			<table>
			<tr>
			<th colspan="2">
			로그인
			</th>
			</tr>
				<tr>
					<th>아이디 :</th>
					<td><input type="text" name="mid"></td>
				</tr>
				<tr>
					<th>비밀번호 :</th>
					<td><input type="password" name="mpw"></td>
				</tr>
				<tr>
				<th colspan="2"><input type="submit" value="로그인"></th>
				</tr>
			</table>
		</form>

		<br>
		<br>
		<br>
	</div>
	<div class="footer">
		<h2>회원제 게시판</h2>
	</div>
</body>
</html>