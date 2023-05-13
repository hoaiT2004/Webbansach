<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
	integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"></script>
</head>
<body>
<%
String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
+ request.getContextPath();
	String tenDangNhap = request.getAttribute("tenDangNhap") + "";
	String hoVaTen = request.getAttribute("hoVaTen") + "";
	String gioiTinh = request.getAttribute("gioiTinh") + "";
	String diaChi = request.getAttribute("diaChi") + "";
	String diaChiMuaHang = request.getAttribute("diaChiMuaHang") + "";
	String ngaySinh= request.getAttribute("ngaySinh")+"";
	String soDienThoai = request.getAttribute("soDienThoai") + "";
	String email = request.getAttribute("email") + "";
	String baoLoi = request.getAttribute("baoLoi") + "";
	
	
	tenDangNhap = (tenDangNhap.equals("null")) ? "" : tenDangNhap;
	hoVaTen = (hoVaTen.equals("null")) ? "" : hoVaTen;
	gioiTinh = (gioiTinh.equals("null")) ? "" : gioiTinh;
	diaChi = (diaChi.equals("null")) ? "" : diaChi;
	diaChiMuaHang = (diaChiMuaHang.equals("null")) ? "" : diaChiMuaHang;
	ngaySinh = (ngaySinh.equals("null"))?"":ngaySinh;
	soDienThoai = (soDienThoai.equals("null")) ? "" : soDienThoai;
	email = (email.equals("null")) ? "" : email;
	baoLoi = (baoLoi.equals("null")) ? "" : baoLoi;
	%>
	<!-- Header -->
	<%@include file="../header.jsp" %>
	<!-- End header -->
	<h1 style="text-align: center">Đăng ký tài khoản</h1>
	<span style="text-align: center;color: red"><%=baoLoi %></span>
	<div class="container mt-4">
		<form action="<%=url %>/khach-hang-controller" method="post" class="form">
		<input type="hidden" name="hanhdong" value ="dang-ky">
			<div class="row">
				<div class="col-md-6">
					<h3>Tài khoản</h3>
					<div class="mb-3">
						<lable for="tendangnhap" class="form-label">Tên đăng nhập<span
							style="color: red">*</span></lable>
						<input type="text" name="tendangnhap" class="form-control"
							required="required" value=<%=tenDangNhap%>>
					</div>
					<div class="mb-3">
						<label for="matkhau" class="form-label">Mật khẩu<span
							style="color: red">*</span></label> <input type="password" name="matkhau"
							class="form-control" required="required" id="check"
							onkeyup="kiemTraMatKhau()" value="">
					</div>
					<div class="mb-3">
						<label for="nhaplaimatkhau" class="form-label">Nhập lại
							mật khẩu<span style="color: red">*</span><span style="color: red"
							id="baoloi"></span>
						</label> <input type="password" name="nhaplaimatkhau" class="form-control"
							required="required" id="check1" onkeyup="kiemTraMatKhau()">
					</div>
					<!-- Thông tin khách hàng -->
					<h3>Thông tin khách hàng</h3>
					<div class="mb-3">
						<lable for=hovaten class="form-label">Họ và tên</lable>
						<input type="text" name="hovaten" class="form-control"
							value=<%=hoVaTen%>>
					</div>
					<div class="mb-3">
						<label for="gioiTinh" class="form-label">Giới tính</label> <select
							class="form-control" id="gioiTinh" name="gioitinh">
							<option></option>
							<option value="Nam" <%=(gioiTinh.equals("Nam"))?"selected='selected'":"" %> >Nam</option>
							<option value="Nữ" <%=(gioiTinh.equals("Nữ"))?"selected='selected'":"" %> >Nữ</option>
							<option value="Khác" <%=(gioiTinh.equals("Khác"))?"selected='selected'":"" %> >Khác</option>
						</select>
					</div>
					<div class="mb-3">
						<label for="ngaysinh" class="form-label">Ngày sinh</label> <input
							type="date" name="ngaysinh" class="form-control" value="<%=ngaySinh%>">
					</div>
				</div>
				<!-- Địa chỉ -->
				<div class="col-md-6">
					<h3>Địa chỉ</h3>
					<div class="mb-3">
						<lable for="diachi" class="form-label">Địa chỉ</lable>
						<input type="text" name="diachi" class="form-control"
							value=<%=diaChi%>>
					</div>
					<div class="mb-3">	
						<lable for="diachimuahang" class="form-label">Địa chỉ mua
						hàng</lable>
						<input type="text" name="diachimuahang" class="form-control"
							value=<%=diaChiMuaHang%>>
					</div>
					<div class="mb-3">
						<lable for="sodienthoai" class="form-label">Số điện thoại</lable>
						<input type="text" name="sodienthoai" class="form-control"
							value=<%=soDienThoai%>>
					</div>
					<div class="mb-3">
						<lable for="email" class="form-label">Email</lable>
						<input type="email" name="email" class="form-control"
							value=<%=email%>>
					</div>
					<div class="mb-3">
						<input type="checkbox" required="required"
							class="form-check-input" onclick="kiemTraNutBam()" id="agree">
						<label for="agree"><a href="<%=url%>/DieuKhoan.jsp">Đồng ý với điều khoản
								của công ty</a><span style="color: red">*</span></label>
					</div>
					<div class="mb-3">
						<input type="checkbox" name="dongynhanemail"
							class="form-check-input"> <label for="dongynhanemail">Đồng
							ý nhận email</label>
					</div>
					<hr>
					<div class="mb-3">
						<input type="submit" name="Xác nhận"
							style="background-color: blue; visibility: hidden;"
							class="form-control" id="nutbam">
					</div>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function kiemTraMatKhau() {
			mk = document.getElementById("check").value;
			mk1 = document.getElementById("check1").value;
			if (mk != mk1) {
				document.getElementById("baoloi").innerHTML = "Mật khẩu không khớp!";
				return false;
			} else {
				document.getElementById("baoloi").innerHTML = "";
				return true;
			}
		}
		function kiemTraNutBam() {
			dongYDieuKhoan = document.getElementById("agree");
			if (dongYDieuKhoan.checked == true) {
				document.getElementById("nutbam").style.visibility = "visible";
			} else {
				document.getElementById("nutbam").style.visibility = "hidden";
			}
		}
	</script>
	<!-- Footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
	<!-- End footer -->
</body>
</html>