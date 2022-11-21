<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<span style="color: bisque; font-size: 100px; font-weight: bold;">hi,
		${logId}</span>
	<br>
	<a href="${pageContext.request.contextPath}/MemberList">회원목록</a>
	<a href="${pageContext.request.contextPath}/MemberJoinForm">회원가입</a>
	<a href="${pageContext.request.contextPath}/MemberLoginForm">로그인</a>
	<script type="text/javascript">
		let msg = '${msg}';
		
		if(msg.length > 0){
			alert(msg);
		}
		
	</script>
</body>
</html>