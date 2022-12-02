<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>MemberBoard - Main</title>

<!-- Custom fonts for this template-->
<link
	href="${pageContext.request.contextPath }/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link
	href="${pageContext.request.contextPath }/resources/css/sb-admin-2.min.css"
	rel="stylesheet">

<style>
.d-none{display:none;}
</style>
</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->

		<!-- Sidebar - Brand -->
		<%@ include file="/WEB-INF/views/includes/sideBars.jsp"%>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<%@ include file="/WEB-INF/views/includes/topBar.jsp"%>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">Main.jsp</h1>
					</div>

					<!-- Content Row -->
					<h2>컨텐츠 영역</h2>
					<div class="row" style="border: 1px solid black;">
						<div class="col-lg-12">
							<div class="pt-1 px-5 pb-1">
								<div class="text-center">
									<h1 class="h4 text-gray-900 mb-4">글 작성</h1>
								</div>
								<div class="form-group row">
									<div class="col-sm-4 mb-3 mb-sm-0">
										<label for="inputContent" class="font-weight-bold">작성자</label>
										<input type="text" class="form-control form-control-user" readonly="readonly"
											value="${requestScope.board.bwriter}">
									</div>
									<div class="col-sm-4 mb-3 mb-sm-0">
										<label for="inputContent" class="font-weight-bold">작성일</label>
										<input type="text" class="form-control form-control-user" readonly="readonly"
											value="${requestScope.board.bdate}">
									</div>
									<div class="col-sm-4 mb-3 mb-sm-0">
										<label for="inputContent" class="font-weight-bold">조회수</label>
										<input type="text" class="form-control form-control-user" readonly="readonly"
											value="${requestScope.board.bhits}">
									</div>
								</div>
								<%--display:none방식 --%>
									<form class="user" action="${pageContext.request.contextPath}/BoardRevise" method="post"
									enctype="multipart/form-data">
									<div class="form-group">
									<input type="hidden" name="rbno" value="${requestScope.board.bno}">
									
										<label for="revTitle" class="font-weight-bold">글제목</label> <input
											type="text" class="form-control form-control-user"
											id="revTitle" readonly="readonly" name="rtitle"
											value="${requestScope.board.btitle}">
									</div>
									<div class="form-group">
										<label for="revContent" class="font-weight-bold">글내용</label>
										<textarea class="form-control" id="revContent"
											readonly="readonly" name="rcontent" rows="10">${requestScope.board.bcontent}</textarea>
									</div>
									<div class="form-group">
										<img
											src="${pageContext.request.contextPath}/resources/BoardUpload/${requestScope.board.bfilename}"
											alt="업로드 파일" style="width:100px; height:100px;">
										<!-- <input type="file" class="form-control form-control-user"
											style="padding-top: 11px; height: 48px;" name="bfile"> -->
									</div>
									<div>
										<c:choose>
											<c:when test="${sessionScope.loginID == board.bwriter}">
												<div class="form-group row">
													<div class="col-sm-6 mb-3 mb-sm-0">
														<button type="button"
															class="btn btn-primary btn-user btn-block"
															onclick="location.href='${pageContext.request.contextPath}/BoardList';">글목록</button>
													</div>
													<%-- 수정 버튼 display:none 방법 --%>
													<div class="col-sm-6 mb-3 mb-sm-0">
														<button type="button"
															class="btn btn-primary btn-user btn-block modifyCol" onclick="toggleModForm('open')">글 수정</button>
													</div>
													<div class="col-sm-3 mb-3 mb-sm-0">
														<button type="submit"
															class="btn btn-primary btn-user btn-block modifyCol d-none">수정하기</button>
													</div>
													<div class="col-sm-3 mb-3 mb-sm-0">
														<button type="button"
															class="btn btn-primary btn-user btn-block modifyCol d-none" onclick="toggleModForm('close')">취소하기</button>
													</div>
												</div>
											</c:when>
											<c:otherwise>
												<div class="form-group">
													<button type="submit"
														class="btn btn-primary btn-user btn-block"
														onclick="location.href='${pageContext.request.contextPath}/BoardList';">글목록</button>
												</div>
											</c:otherwise>
										</c:choose>
										<hr>
										
									</div>
								</form>
								<div class="row">
											<div
												class="col-lg-7 ml-auto mr-auto align-items-center text-center pb-3"
												style="background-color: white">
												<button class="btn border-primary text-primary"
													onclick="boardLike('0')">
													<i class="p-0 far fa-thumbs-up">추천</i><span id="likeCounts"></span>
												</button>
												<button class="btn border-primary text-primary"
													onclick="boardLike('1')">
													<i class="p-0 far fa-thumbs-down">비추천</i><span id="hateCounts"></span>
												</button>
											</div>
										</div>
											<hr>
								<!-- 댓글 출력 -->
								<div id="replyListArea">
								
								</div>
									<hr>
								<!-- 댓글 작성 -->
								<c:if test="${sessionScope.loginID != null }">
									<div class="row">
										<div class="col-lg-12 ml-auto mr-auto bg-white">
											<div class="p-12">
												<form class="user" enctype="multipart/form-data"
													method="post" onsubmit="return replyWrite(this)">
													<div class="form-group row">
														<div class="col-sm-1 mb-3 mb-sm-0">
														<img class="img-prfile rounded-circle" src="${pageContext.request.contextPath }/resources/MemberProfile/${sessionScope.loginProfile}"
														style="width:30px; height:30px;" alt="">
														</div>
														<div class="col-sm-2 mb-3 mb-sm-0">
															<input type="hidden" value="${requestScope.board.bno }" name="cbno">
															<input type="text" class="form-control" name="cwriter"
																readonly="readonly" style="height: 50px;"
																value="${sessionScope.loginID}"> <%-- 댓글 작성자 --%>
														</div>
														<div class="col-sm-6">
															<textarea class="form-control" name="ccontent"
																id="content" style="height: 50px;"></textarea>
														</div>
														<div class="col-sm-3">
															<button class="btn btn-primary btn-block"
																style="height: 50px;">작성하기</button>
														</div>
													</div>
												</form>
											</div>
										</div>
									</div>
								</c:if>
							</div>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2021</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<%@ include file="/WEB-INF/views/includes/logoutModal.jsp"%>

	<!-- Bootstrap core JavaScript-->
	<script
		src="${pageContext.request.contextPath }/resources/vendor/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="${pageContext.request.contextPath }/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script
		src="${pageContext.request.contextPath }/resources/js/sb-badmin-2.min.js"></script>
	<script>
		let msg = '${requestScope.msg}';
		if(msg > 0){
			alert(msg);
		}
	</script>
	<script>
	const undoTitle = $('#revTitle').val();
	const undoContent = $('#revContent').val();
	
	function toggleModForm(btnType){
		console.log('수정버튼클릭');
		$('.modifyCol').toggleClass("d-none");
		
		if(btnType === 'open'){
			$('#revTitle').removeAttr('readonly');
			$('#revContent').removeAttr('readonly');	
		} else{
			$('#revTitle').val(undoTitle);
			$('#revContent').val(undoContent);
			$('#revTitle').attr('readonly','readonly');
			$('#revContent').attr('readonly','readonly');	
		}
	}
	
	function replyWrite(formObj){
		let cbno = formObj.cbno;
		let cwriter = formObj.cwriter;
		let ccontent = formObj.ccontent;
		console.log('cwriter :' + cwriter.value);
		console.log('cbno :' + cbno.value);
		console.log('ccontent :' + ccontent.value);
		

		$.ajax({
			type : "post",
			url: "${pageContext.request.contextPath }/CommentWrite",
			data: {"cbno" : cbno.value,
					"cwriter" : cwriter.value,
					"ccontent": ccontent.value,
				  },
			success : function(checkResult){
				console.log("결과 : " + checkResult);
				if(checkResult == "OK"){ // 댓글 작성에 성공하면
					alert('댓글 작성에 성공했습니다.')
					location.href="${pageContext.request.contextPath}/BoardContent?bno=${board.bno}";
				} else{ // 댓글 작성에 실패하면
					alert('댓글 작성에 실패했습니다.');
				}
			}
		});
		return true;
	}
    </script>
    <script type="text/javascript">
    //전역 변수 cbno : 현재 보고 있는 글 번호
    const cbno = '${board.bno}';
    let loginID = '${sessionScope.loginID}';
    $(document).ready(function(){
    	replyList(cbno);
    	stateCount(cbno);
    });
    
 	// 추천수 조회
    //좋아요와 싫어요 개수 count하는 기능
    function stateCount(cbno){
    	$.ajax({
    		type:"get",
    		url:"${pageContext.request.contextPath}/BoardStateCount",
    		data:{"lbno": cbno},
    		dataType:"json", //두가지 정보 받아올 것. 추천과 비추천
    		success: function(selectRs){
    			if(selectRs != null){ //좋아요와 싫어요 출력
    				console.log(selectRs);
    				let hate = "";
    				let like = "";
    				for(board of selectRs){
    					console.log(board.lstate);
						if(board.lstate == '0'){
							like = board;
						}else{
							hate = board;
						}
    				}
    				if(like.lstate != null){
    				$("#likeCounts").text(like.lcount); //좋아요 개수
    				}
    				if(hate.lstate != null){
    				$("#hateCounts").text(hate.lcount); //싫어요 개수
    				}
    			}
    		}
    	});
    }
    
    //댓글 목록 받아오는 기능 
	function replyList(cbno){
		console.log('댓글 목록 조회 replyList(cbno)');
		$.ajax({
			type : "get",
			url: "${pageContext.request.contextPath }/CommentList",
			data: {"cbno" : cbno},
			dataType: "json", // controller를 통해 받아오는 데이터 형식
			async: false, // 동기로 진행, true시 비동기
			success : function(comList){
				let output = "";
				for(let i = 0; i < comList.length; i++){
					console.log(comList[i].cwriter + " : " + comList[i].ccontent);
			output +='<div class="card border-left-primary shadow h-100 py-2">'+
						'<div class="card-body">'+
							'<div class="row no-gutters align-items-center">'+
								'<div class="col mr-2">'+
									'<div class="text-xs font-weight-bold">'+
										'<img class="mr-2" height="25" src="${pageContext.request.contextPath}/resources/img/undraw_profile.svg" alt="">'+
										'<span class="text-primary">'+comList[i].cwriter+'</span>'+
										'<span class="text-uppercase pl-2">'+comList[i].cdate+'</span>'+
					 				'</div>'+
					 				'<button type="button" class="btn border-primary text-primary" onclick="comLike('+comList[i].cno+', \'0\')">'+ // 클릭하면 추천수 업!
										'<i class="p-0 far fa-thumbs-up">추천</i><span id="likeCount'+comList[i].cno +'"></span>'+
									'</button>'+
					 				'<hr class="my-1">'+
					 				'<input type="hidden" name="revCno" value="'+comList[i].cno +'">'+
					 				'<textarea name="revCcom" id="rcomment'+comList[i].cno+'" readonly="readonly" class="retext mb-2 border-0 font-weight-bold text-gray-800 w-100">'+ 
									comList[i].ccontent +'</textarea></div>'+
									'<div class="col-auto">';
									if(loginID == comList[i].cwriter){
										output +='<button type="button" class="btn btn-sm btn-success btn-user" onclick="revCom('+comList[i].cno+')">수정</button>'+
												 '<button type="button" class="btn btn-sm btn-danger btn-user" onclick="delCom('+ comList[i].cno +')">삭제</btton>';	
									}
									output+= '</div></div></div></div>';
				}
				$("#replyListArea").html(output);
				comRevCk = false;
				getLikeCount(cbno);
			}
		});
	}
    //ajax를 사용하는 방법
    function delCom(cno){
    	$.ajax({
    		type:"post",
    		url:"${pageContext.request.contextPath}/CommentDelete",
    		data:{"cno" : cno},
    		async:false,
    		success: function(delResult) {
    			console.log("결과 : " + delResult);
    			if(delResult == "done"){
    				replyList(cbno);
    				alert('삭제가 완료되었습니다.');
    			} else{
    				alert('삭제에 실패했습니다.');
    			}
    		}
    	});	
    }
    let comRevCk = false;
    function revCom(cno){
    	let revcomment = $("#rcomment"+cno);
    	if(!comRevCk){
    		revcomment.removeAttr("readonly"); //해당 textArea의 readonly속성 지워서 삭제 가능하게 함
    		revcomment.focus();
    		comRevCk = true;
    	} else{
        	$.ajax({
        		type:"post",
        		url:"${pageContext.request.contextPath}/CommentRevise",
        		data:{"cno" : cno,
        			  "ccontent" : revcomment.val(),
        			 },
        		async:false,
        		success : function(updateRs){
        			console.log("결과 : " + updateRs);
        			if(updateRs === "done"){
        				replyList(cbno);
        				alert('수정에 성공했습니다.');
        			} else{
        				alert('수정에 실패했습니다.');
        			}
        		}
        	});
        	replyList(cbno); //여기서 comRevCk 다시 false로 바꿈
    	}
    }
    
    function boardLike(lstate){
    	if(loginID.length > 0){
    		$.ajax({
    			type:"get",
    			url:"${pageContext.request.contextPath}/BoardLike",
    			data:{
    				"lbno": cbno,
    				"lmid": '${sessionScope.loginID}',
    				"lstate": lstate
   				},
   				success:function(insertRs){
   					//결과
  					if(insertRs !=null){
  						if(insertRs == -1){
  	  						alert("이미 추천/비추천하신 글입니다.")
  						} else{
	   					console.log(insertRs);
	   					stateCount(cbno);
  						}
  					} else{
  						alert(insertRs+"에 실패했습니다.");			
  					}
				} 
   				// 추천 입력
    		});
    	} else{
    		alert("로그인 후 이용가능합니다.");
    	}
    }
    
    //댓글 좋아요 개수 출력
    function getLikeCount(cbno){ // 해당페이지에 작성된 댓글
    	$.ajax({
    		type:"get",
    		url:"${pageContext.request.contextPath}/ComLikeCount",
    		data:{"cbno" : cbno},
    		dataType:"json",
    		async:false,
    		success:function(result){
    			console.log('댓글 좋아요 기능 출력')
    			console.log(result);
    			for(comLikes of result){
   				console.log(comLikes == null);
    			let spanId = "#likeCount"+comLikes.likecno;
    			console.log("spanId : "+spanId);
	  			$(spanId).text(" "+comLikes.likecount);
    			}
    		}
    	});
    }
    
    
     function comLike(cno, likestate){
    	$.ajax({
    		type:"post",
    		url:"${pageContext.request.contextPath}/ComLike",
    		data: {
    			"likemid" : '${sessionScope.loginID}',
    			"likecno" : cno,
    			"likestate" : likestate
    			  },
    		async:false,
    		success: function(insRs){
    			console.log("댓글 추천 기능 수행결과 : " + insRs);
				switch(insRs){
				case "YEPP":
					alert("댓글 추천에 성공했습니다.");
					break;
				case "YOUDID":
					alert("이미 추천하신 댓글입니다.");
					break;
				case "NOPE":
					alert("댓글 추천에 실패했습니다.");
					break;
				}
				replyList(cbno);
    		}
    	});  
    }
    </script>
</body>

</html>