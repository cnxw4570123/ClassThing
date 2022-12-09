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
                        <h1 class="h3 mb-0 text-gray-800">TAGO SERVICE.jsp</h1>
                    </div>
					<div id="tago_div">
						
					</div>
                    <!-- Content Row -->
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
</body>
	<script>
	tago_req();
	function tago_req(){
		$.ajax({
			type: "post",
			url: "${pageContext.request.contextPath}/Tago_get_data",
			data: {
				serviceKey : "FPorulAILptOMIMpewlVWjHPBlaQyC4km7wmWxFcjTwpiWfQ0ONVDga06VmIJ5NJSHlcwM6dtZ1leJ92Fg8ZvQ==",
				pageNo : 1,
				numofRows : "10",
				_type : "json",
				cityCode : "23",
				nodeId : "ICB163000060"
				},
			dataType: "json",
			async: false,
			success: function(busDataArr){
				/* output +='<div class="card border-left-primary shadow h-100 py-2">'+
				'<div class="card-body">'+
					'<div class="row no-gutters align-items-center">'+
						'<div class="col mr-2">'+
							'<div class="text-xs font-weight-bold">'+
								'<span class="text-primary">'+comList[i].cwriter+'</span>'+
								'<span class="text-uppercase pl-2">'+comList[i].cdate+'</span>'+
			 				'</div>'+
			 				'<hr class="my-1">'+
			 				'<input type="hidden" name="revCno" value="'+comList[i].cno +'">'+
			 				'<textarea name="revCcom" id="rcomment'+comList[i].cno+'" readonly="readonly" class="retext mb-2 border-0 font-weight-bold text-gray-800 w-100">'+ 
							comList[i].ccontent +'</textarea></div>'+
							output+= '</div></div></div>'; */
				let output ='';
				for (let i = 0; i < busDataArr.length; i++) {
				output +='<div class="card border-left-primary shadow h-100 py-2">'+
				'<div class="card-body">'+
				'<div class="row no-gutters align-items-center">'+
				'<div class="col mr-2">'+
				'<div class="text-lg font-weight-bold">';
					output+= '<span class="text-primary text-uppercase pl-2"> 버스번호 :' +busDataArr[i].routeno + '</span><br>';
					output+='</div><hr class="my-1">';
					let arrtime = busDataArr[i].arrtime/60;
					output += '<span class="text-uppercase pl-2"> 남은 정류장 수 :' +busDataArr[i].arrprevstationcnt + '개</span><br>';
					if(arrtime < 1){
					output+= '<span class="text-uppercase pl-2"> 남은 시간 : 1분미만</span><br>';
					} else{
					output+= '<span class="text-uppercase pl-2"> 남은 시간 :' +arrtime + '분</span><br>';
					}
					output+= '<span class="text-uppercase pl-2"> 정류장명 :' +busDataArr[i].nodenm + '</span><br>';
					output+= '<span class="text-uppercase pl-2"> 버스종류 :' +busDataArr[i].routetp + '</span><br>';
					output+= '<span class="text-uppercase pl-2"> 차량종류 :' +busDataArr[i].vehicletp + '</span>';
					output+= '</div></div></div></div><br>';
				}
				$('#tago_div').html(output);
							
			}
		});
	}

	</script>
</html>