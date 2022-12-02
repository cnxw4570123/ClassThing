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
	<style>
	.d-none{
		display:none;
	}
	.tr_click:hover{
		color:blue;
		cursor:pointer;
	}
	</style>
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
                        <h1 class="h3 mb-0 text-gray-800">Main.jsp</h1>
                    </div>

                    <!-- Content Row -->
					<div class="">
						<table>
							<tr>
							<th><img height="100" alt="profile img" class="img-profile rounded-sm"
					 src="${pageContext.request.contextPath }/resources/MemberProfile/${requestScope.memberInfo.mprofile}"></th>
							</tr>
							<tr>
								<td>아이디: ${requestScope.memberInfo.mid}</td>
							</tr>
							<tr>
								<td>이름: ${requestScope.memberInfo.mname}</td>
							</tr>
							<tr>
								<td>생년월일: ${requestScope.memberInfo.mbirth}</td>
							</tr>
							<tr>
								<td>이메일: ${requestScope.memberInfo.memail}</td>
							</tr>
							<tr>
								<td>주소: ${requestScope.memberInfo.maddr}</td>
							</tr>
						</table>
					</div>
					<hr>
					<button onclick="displayBtn(mBoard)">작성 글 보기</button>
					<!-- 글내역 출력 -->
					<div class="d-none" id="mBoard">
						<div class="card shadow mb-4">
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary">글 목록</h6>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table class="table table-bordered" id="dataTable" width="100%"
										cellspacing="0">
										<thead>
											<tr>
												<th>글번호</th>
												<th>글제목</th>
												<th>작성일</th>
												<th>조회수</th>
											</tr>
										</thead>
										<tfoot>
												<tr>
													<th>글번호</th>
													<th>글제목</th>
													<th>작성일</th>
													<th>조회수</th>
												</tr>
										</tfoot>
										<tbody>
										<c:forEach items="${requestScope.myBoards}" var="board">
											<tr class="tr_click" onclick="location.href='${pageContext.request.contextPath}/BoardContent?bno=${board.bno}';">
												<td>${board.bno }</td>
												<td>${board.btitle }</td>
												<td>${board.bdate }</td>
												<td>${board.bhits }</td>
											</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>

					<hr>
					<button onclick="displayBtn(mComment)">작성 댓글 보기</button>
					<div id="mComment" class="d-none">
					<div class="card shadow mb-4">
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary">댓글 목록</h6>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table class="table table-bordered" id="dataTable" width="100%"
										cellspacing="0">
										<thead>
											<tr>
												<th>글번호</th>
												<th>글제목</th>
												<th>작성자</th>
												<th>작성일</th>
												<th>조회수</th>
											</tr>
										</thead>
										<tfoot>
											<tr>
												<th>글번호</th>
												<th>글제목</th>
												<th>작성자</th>												
												<th>작성일</th>
												<th>조회수</th>
											</tr>
										</tfoot>
										<tbody><%-- 바디에 해당하는 내용을 참조한 게시글만큼 반복 --%>
												<%-- 이후 해당 글에 맞는 댓글(cbno == bno)이면 댓글 테이블 반복 --%>
											<c:forEach items="${requestScope.refBoards }" var="refBoard">
											<tr>
											<td>${refBoard.bno }</td>
											<td>${refBoard.btitle }</td>
											<td>${refBoard.bwriter }</td>
											<td>${refBoard.bdate }</td>
											<td>${refBoard.bhits }</td>
											</tr>
												<tr>
													<td colspan="5">
														<table>
															<thead>
																<tr colspan="2" style="width:100%;">
																	<th>↪</th>
																	<th>댓글내용</th>
																	<th>작성일</th>
																	<th>추천수</th>
																</tr>
															</thead>
															<tbody>
											<c:forEach items="${requestScope.myComments}" var="comment">
																<tr  colspan="5" class="tr_click"
																	onclick="location.href='${pageContext.request.contextPath}/BoardContent?bno=${comment.cbno}';">
																	<td>${comment.ccontent}</td>
																	<td>${comment.cdate }</td>
																	<td colspan="2">${comment.chits }</td>
																	
																</tr>
											</c:forEach>
															</tbody>
														</table>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
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
    let msg = '${requestScope.msg}';
	if(msg.length > 0){
		alert(msg);
	}
    </script>
    <script type="text/javascript">
    	const displayBtn = (msg) => {
    		$(msg).toggleClass("d-none");
    	};
    </script>
</body>

</html>