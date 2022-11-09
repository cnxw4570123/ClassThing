<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/MainStyle.css">
</head>
<style>
table, th, td {
	padding: 10px;
	border: 1px solid black;
	text-align: center;
}
th{
	font-weight: bold;
}
</style>
<body>
	<%-- String id = (String) session.getAttribute("uid");"); %> 
<p><%= id %>님 반갑습니다.</p> --%>

	<div class="header">
		<h1>mainPage</h1>
		<c:if test="${sessionScope.uid != null}">
			<p>${sessionScope.uid}님 반갑습니다.</p>
		</c:if>
	</div>
	<%@include file="/menu.jsp"%>

	<div class="contents">
		<h2>글목록페이지</h2>
		<!-- 글번호, 글제목, 글작성자, 작성일, 조회수 -->
		<table>
			<thead>
				<tr>
					<th>글번호</th>
					<th>글제목</th>
					<th>글작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
			<!-- 검색한 거랑 검색 전이랑 다르게 처리하기 -->
				<c:forEach items="${requestScope.boardList}" var="board" varStatus="status">
					<tr>
						<td>${board.bNo}</td>
						<td><a href="${pageContext.request.contextPath}/BoardInto?bno=${board.bNo}">${board.bTitle}</a></td>
						<td>${board.bWriter}</td>
						<td>${board.bDate}</td>
						<td>${board.bHits}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="5">
					<form action="${pageContext.request.contextPath}/BoardSearch" style="display: inline-block;">
					<select name="searchType">
							<option value="title">제목</option>
							<option value="content">내용</option>
							<option value="titleContent">제목/내용</option>
							<option value="writer">작성자</option>
					</select> 
					<input type="text" name="searchText" placeholder="검색어 입력">
					<input type="submit" value="검색">
					</form>
					<c:if test="${sessionScope.uid != null}">
					<button onclick="boardWrite()">글작성</button>
					</c:if>
					</th>
				</tr>
			</tfoot>
		</table>
	</div>
	<div class="footer">
		<h2>회원제 게시판</h2>
	</div>
	<script>
		let msg = '${param.msg}';
		if(msg.length != 0){
			alert(msg);
		}
		const boardWrite =() =>{
			location.href='${pageContext.request.contextPath}/Board/BoardWrite.jsp';
		}
		
	</script>
</body>
</html>