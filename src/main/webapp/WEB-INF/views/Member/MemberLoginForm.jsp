<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
	border: 1px solid black;
	padding: 5px;
}
</style>
</head>
<body>
	<h1 style="font-size: 75px; color: blue;">MemberLogin</h1>
	<form action="${pageContext.request.contextPath}/MemberLogin" method="get">
		<table>
			<tr>
				<th>아이디 :</th>
				<td><input type="text" name="testId"></td>
			</tr>
			<tr>
				<th>비밀번호 :</th>
				<td><input type="password" name="testPw"></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="로그인" style="background-color:white; width:100px; border: none; border-bottom: 2px solid teal;"></th>
			</tr>
		</table>
	</form>
	<script>
	let msg = '${requestScope.msg}';
		if(msg.length > 0){
			alert(msg);
		}
	</script>
</body>
</html>