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
		<h1>mainPage</h1>
	</div>

	<%@include file="/menu.jsp"%>

	<div class="contents">
		<form action="${pageContext.request.contextPath}/MemberJoin"
			method="post" onsubmit="return joinFormCheck(this)")>
			<table>
				<tr>
					<th colspan="2">회원가입</th>
				</tr>
				<tr>
					<th>아이디</th>
					<td>
					<!-- onfocusout="idCheck(this.value)" -->
					<input type="text" name="mid" id ="inputId" onchange="idCheck = false;">
					<button type="button" onclick="idCheckBtn()">중복확인</button>
					<p style="margin-top:2px; margin-bottom: 10px; font-size: 10px;" id="checkText"> 중복확인 메시지 </p>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="mpw"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="mname"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="date" name="mbirth"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="meid" style="width: 100px;">
						@ <input type="text" name="mdomain" id="userDom"
						style="width: 100px;"> <select
						onchange="selDomain(this.value)">
							<option value="">직접선택</option>
							<option value="gmail.com">구글</option>
							<option value="naver.com">네이버</option>
							<option value="daum.com">다음</option>
					</select></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="maddr"></td>
				</tr>
				<tr>
					<th colspan="3"><button>가입하기</button></th>
				</tr>

			</table>
		</form>
	</div>
	<div class="footer">
		<h2>회원제 게시판</h2>

	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			console.log("Jquery");
		});
	</script>
	<script>
	function selDomain(domain){
		let domainObj =document.getElementById('userDom'); 
		domainObj.value = domain;
		console.log(domain.length);
		
		if(domain.length > 1){
		domainObj.setAttribute('readonly', "readonly");
		}
	}
	
	const joinFormCheck = (formObj) => {
		let mid = formObj.mid;
		let mpw = formObj.mpw;
		let mname = formObj.mname;
		let mbirth = formObj.mbirth;
		let memail = formObj.meid;
		let mdom = formObj.mdomain;
		
		if(validCheck(mid, "아이디")){
			return false;
		}else if(validCheck(mpw, "비밀번호")){
			return false;
		}else if(validCheck(mname, "이름")){
			return false;
		}else if(validCheck(mbirth, "생년월일")){
			return false;
		}else if(validCheck(memail, "이메일")){
			return false;
		}else if(validCheck(mdom, "도메인")){
			return false;
		}else if(!idCheck){
			mid.focus();
			return false;
		}else{
			return true;
		}
	}
	
	function validCheck(obj, msg){
		if(obj.value.length == 0){
			alert(msg + "를 입력해주세요.");
			obj.focus();
			return true;
		}
	}
	
	/* function idCheck(idVal){
		console.log("idVal : " + idVal);
		
		
	} */
	let idCheck = false;
	
	function idCheckBtn(){
		// jQuery => let idVal = $('#inputId').val();
		let idVal = document.getElementById('inputId').value;
		$.ajax({
			type: "get",
			url: "${pageContext.request.contextPath}/MemberIdCheck",
			data: {"inputId": idVal},
			dataType: "text",
			async: false,
			success: function(result){
				console.log("확인 결과 : " + result);
				if(result == "ok"){
					$('#checkText').text('사용가능한 아이디').css('color', 'green');
					idCheck = true;
				} else{
					$('#checkText').text('이미 사용중인 아이디').css('color', 'red');
					idCheck = false;
				}
			},
			error: function() {
				console.log("중복확인 실패!");
			}
		});
		
	}
	
</script>
</body>
</html>