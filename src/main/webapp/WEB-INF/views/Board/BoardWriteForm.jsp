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
                        <h1 class="h3 mb-0 text-gray-800">Main.jsp</h1>
                    </div>

                    <!-- Content Row -->
					<h2>컨텐츠 영역</h2>
					<div class="row" style="border:1px solid black;">
						<div class="col-lg-12">
							<div class="p-5">
								<div class="text-center">
									<h1 class="h4 text-gray-900 mb-4">글 작성</h1>
								</div>
								<form class="user" action="${pageContext.request.contextPath}/BoardWrite" method="post"
									enctype="multipart/form-data">
									<div class="form-group">
										<label for="inputTitle" class="font-weight-bold">글제목</label> <input
											type="text" class="form-control form-control-user"
											id="inputTitle" name="btitle">
									</div>
									<div class="form-group">
										<label for="inputContent" class="font-weight-bold">글내용</label>
										<textarea class="form-control" id="inputContent"
											name="bcontent" rows="10"></textarea>
									</div>
									<div class="form-group">
										<input type="file" class="form-control form-control-user"
											style="padding-top: 11px; height: 48px;" name="bfile">
									</div>
									<input type="submit" class="btn btn-primary btn-user btn-block"
										value="작성하기">
								</form>
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
    
    
</body>

</html>