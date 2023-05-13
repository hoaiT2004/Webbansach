<%@page import="model.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Thay đổi ảnh</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>
<style>
.red {
	color: red;
}
</style>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<%
	Object obj = session.getAttribute("khachHang");
	Client khachHang = null;
	if (obj != null)
		khachHang = (Client) obj;
	if (khachHang == null) {
	%>
	<h1>Bạn chưa đăng nhập vào hệ thống. Vui lòng quay lại trang chủ!</h1>
	<%
	} else {
		String baoLoi = request.getAttribute("baoLoi")+"";
		baoLoi = (baoLoi.equals("null"))?"":baoLoi;
	%>
		<%
		String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
		%>
		<div class="container">
			<div class="text-center">
				<h1>THÔNG TIN TÀI KHOẢN</h1>
				<h4 style="color:green;text-align: center;"><%=baoLoi %></h4>
			</div>
			<form class="form" action="<%=url1%>/khach-hang-avatar"
				method="post" enctype="multipart/form-data">
				<!-- enctype="multipart/form-data"  ==> Để upload được file -->
				<div class="row">
					<div class="col-sm-6">
						<h3>Thông tin khách hàng</h3>
						<%
						String duongDanAnh = khachHang.getUrl();
						if (duongDanAnh.equals("")) {
						%>
						<img src="https://code.ptit.edu.vn/2020/images/avt.png"
							alt="Ảnh Avatar" />
						<%
						} else {
						%>
						<img src="<%=url1%>/khachhang/avatar/<%=duongDanAnh%>" style="width: 120px;height: 70px;" alt="Ảnh Avatar" />
						<%
						}
						%>
						<div class="mb-3">
							<label for="duongDanAnh" class="form-label">Đường dẫn ảnh</label>
							<input type="file" class="form-control" id="duongDanAnh"
								name="duongDanAnh">
						</div>
						<input class="btn btn-primary form-control" type="submit"
							value="Lưu thông tin">
					</div>
				</div>
			</form>
		</div>
	<%
	}
	%>
	<jsp:include page="../footer.jsp" />
</body>

</html>