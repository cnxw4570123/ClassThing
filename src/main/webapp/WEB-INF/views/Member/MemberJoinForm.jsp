<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>MemberBoard - Main</title>

    <!-- Custom fonts for this template-->
    <link href="${pageContext.request.contextPath }/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath }/resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->

            <!-- Sidebar - Brand -->
            <%@ include file="/WEB-INF/views/includes/sideBars.jsp" %>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <%@ include file="/WEB-INF/views/includes/topBar.jsp" %>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">MemberJoinForm.jsp</h1>
                    </div>

                    <!-- Content Row -->
					<h2>컨텐츠 영역</h2>
					<div class="row">
                    <div class="col-lg-7 ml-auto mr-auto bg-white">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">회원가입</h1>
                            </div>
                            <form class="user" action="${pageContext.request.contextPath}/MemberJoin"
                            enctype="multipart/form-data" method="post" onsubmit="return joinFormCheck(this)"> <!-- 파일 업로드 시에는 post로 해야함 -->
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" name="mid" id="jId"
                                            placeholder="아이디" onfocusout="joinIdCheck(this.value)">
                                            <p class="pl-3 m-0 text-xs" id="idCheckMsg">중복확인 메시지</p>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user" name="mpw" id="jPw"
                                            placeholder="비밀번호">
                                    </div>
                                </div>
                                <div class="form-group row">
	                                <div class="col-sm-6 mb-3 mb-sm-0">
	                                    <input type="text" class="form-control form-control-user" id="jName"
	                                        name="mname" placeholder="이름">
	                                </div>
	                                <div class="col-sm-6">
	                                	<input type="date" class="form-control form-control-user" name="mbirth" 
	                                		placeholder="생년월일">
	                                </div>
 	                             </div>
                                <div class="form-group">
                                    <input type="email" class="form-control form-control-user" name="memail" 
                                        placeholder="이메일">
                                </div>
                                <div class="form-group">
                                	<input type="text" class="form-control form-control-user" name="maddr"
                                		placeholder="주소">
                                </div>
                                <div class="form-group">
                                	<input type="file" class="form-control form-control-user" name="mfile"
                                		placeholder="주소">
                                </div>
                                <button class="btn btn-primary btn-user btn-block">회원가입</button> <!-- 추후 카카오로 바꿀 것 -->
                            </form>
                            <!-- <div class="text-center">
                                <a class="small" href="forgot-password.html">Forgot Password?</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="login.html">Already have an account? Login!</a>
                            </div> -->
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
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <%@ include file = "/WEB-INF/views/includes/logoutModal.jsp" %>

    <!-- Bootstrap core JavaScript-->
    <script src="${pageContext.request.contextPath }/resources/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="${pageContext.request.contextPath }/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="${pageContext.request.contextPath }/resources/js/sb-admin-2.min.js"></script>
    <script>
    	/* $(document).ready(function(){
    		console.log('확인');
    	}) */
    	let idCheck = false;
    	
    	const joinIdCheck = (idVal)=> {
    		/* console.log("입력한 아이디 : " + idVal); */
			idCheck = false;
    		if(idVal.length == 0){
    			$('#idCheckMsg').text("아이디를 입력해주세요.").css("color", 'red');
    		} else{
    			$.ajax({
    				type : "get", //get으로 호출
    				url: "${pageContext.request.contextPath }/MemberIdCheck",
    				data: {"inputID" : idVal},
    				//dataType도 지정할 수 있지만 문자열 하나기 때문에 작성하지 않음
    				success : function(checkResult){
    					console.log("결과 : " + checkResult);
    					if(checkResult.length == 0){ // 중복이 없으면
    						$('#idCheckMsg').text('사용가능한 아이디입니다').css('color', 'green');
    						idCheck = true;
    					} else{ // 없는 아이디이면
    						$('#idCheckMsg').text('이미 사용중인 아이디입니다').css('color', 'red');
    					}
    				}
    			});
    		}
    	}
    	
    	function joinFormCheck(formObj){
    		let id = formObj.jId;
    		let pw = formObj.jPw;
    		let name = formObj.jName;
    		
    		if(id.value.length == 0){ //아이디 미입력 시에는 submit 막기
    			alert('아이디를 입력하세요!');
    			id.focus();
    			return false;
    		}
    		
    		if(idCheck == false){ // 중복체크 통과 하지 못하면 가입 불가
    			alert('사용 불가능한 아이디입니다!');
    			id.focus();
    			return false;
    		}
    		
    		if(pw.value.length == 0){ //비밀번호 미입력 시에는 submit 막기
    			alert('비밀번호를 입력하세요!');
    			pw.focus();
	    		return false;
    		}
    		
    		if(name.value.length == 0){ //이름 미입력 시에는 submit 막기
    			alert('이름를 입력하세요!');
    			name.focus();
	    		return false;
    		}
    		
			return true;    		
    	}
    </script>

</body>

</html>