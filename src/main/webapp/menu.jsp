<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="menu">
	<ul>
		<c:choose>
		<c:when test="${sessionScope.uid != null }">
		<li><a href="${pageContext.request.contextPath}/MainPage.jsp">메인페이지</a></li>
		<li><a href="${pageContext.request.contextPath}/BoardList">게시판</a></li>
		<!-- 내 회원 정보 + 내가 작성한 글 / (댓글 보기)  -->
		<li><a href="${pageContext.request.contextPath}/MemberInfo">내정보 보기</a></li>
		<li><a href="${pageContext.request.contextPath}/MemberLogout">로그아웃</a></li>
		</c:when>
		<c:otherwise>
		<li><a href="${pageContext.request.contextPath}/MainPage.jsp">메인페이지</a></li>
		<li><a href="${pageContext.request.contextPath}/BoardList">게시판</a></li>
		<li><a href="${pageContext.request.contextPath}/Member/MemberLogin.jsp">로그인</a></li>
		<li><a href="${pageContext.request.contextPath}/Member/MemberJoin.jsp">회원가입</a></li>
		</c:otherwise>
		</c:choose>
	</ul>
</div>
    