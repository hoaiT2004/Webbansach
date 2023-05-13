<%@page import="model.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đổi mật khẩu</title>
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
</head>
<body>
<%String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
+ request.getContextPath(); %>
<!-- Header -->
	<%@include file="../header.jsp" %>
	<!-- End header -->
	<div class="main__user">
		<%
		Client cl1 = null;
		Object obj1 = session.getAttribute("khachHang");
		cl1 = (Client) obj1;
		if (cl1 == null) {
		%>
		<a href="<%=url %>/index.jsp">Bạn chưa đăng nhập vào hệ thống vui lòng quay
			lại trang chủ</a>
		<%
		} else {
		String baoLoimk = request.getAttribute("baoLoiMK") + "";
		baoLoimk = (baoLoimk.equals("null")) ? "" : baoLoimk;
		%>
	
		<div class="setting__main">
			<form action="<%=url %>/khach-hang-controller" method="post" class="form">
				<input type="hidden" name="hanhdong" value ="doi-mk">
				<input type="hidden" name="_token"
					value="d7q4Q4uzFGjre2xMg5igAFGeoUAGApI5IuqhO7Na">
				<div>

					<input name="username" type="text" value=<%=cl.getUserName()%>></input>
					<h1 class="setting__main__pw__title" style="text-align: center">Đổi
						mật khẩu</h1>
					<p>Mật khẩu của bạn phải có ít nhất 8 ký tự, bao gồm cả chữ
						số,chữ cái và ký tự đặc biệt (!$@%).</p>
					<span style="color: red">
			<%=baoLoimk%>
		</span>
					<div>
						<label class="setting__main__label">Mật khẩu hiện tại<span
							style="color: red">*</span></label> <input
							placeholder="Mật khẩu hiện tại" type="password" name="matKhauCu"
							id="matKhauCu" class="form-control" required="required">
					</div>
					<div>
						<label>Mật khẩu mới<span style="color: red">*</span><span
							style="color: red" id="baoloi"></span></label> <input
							placeholder="Mật khẩu mới" type="password" name="matKhauMoi"
							class="form-control" required="required" required="required"
							id="check" onkeyup="kiemTraMatKhau()">
					</div>
					<div>
						<label>Nhập lại mật khẩu<span style="color: red">*</span></label>
						<input placeholder="Nhập lại mật khẩu mới" type="password"
							name="nhapLaiMatKhau" class="form-control" id="check1"
							required="required" onkeyup="kiemTraMatKhau()">
					</div>
				</div>
				<hr>
				<button type="submit" value="" class="w-100 btn btn-lg btn-primary"
					style="background-color: blue;">Đổi mật khẩu</button>
			</form>
		</div>
	</div>
	<%
	}
	%>
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
	</script>
	<!-- Footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
	<!-- End footer -->
</body>
</html>