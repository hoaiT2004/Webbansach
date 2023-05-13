<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lấy lại mật khẩu</title>
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

	%>
<%
				String error = request.getAttribute("baoLoiLayMK")+"";
				error = (error.equals("null"))?"":error;
				%>
	<!-- header -->
	<%@include file="../header.jsp"%>
	<div class="container">
		<main class="form-signin w-100 m-auto">
			<form action="<%=url1%>/khach-hang-controller"
				class="form">
				<input type="hidden" name="hanhdong" value ="laylai-mk">
				<div class="text-center">

				<h3>Khôi phục mật khẩu</h3>
				<h4 style="text-align: center;color: red;"><%=error %></h4>
					<div class="form-floating">
						<input type="text" class="form-control" id="tendangnhap"
							required="required" name = "tendangnhap"> <label for="tendangnhap">Nhập tên đăng nhập<span style="color:red;">*</span></label>
					</div>
					<br>
					<button type="submit" class="w-25 btn btn-lg btn-primary" style="background-color: red;">Lấy lại mật khẩu</button>
				</div>
			</form>
			<!-- Footer -->
			<jsp:include page="../footer.jsp"></jsp:include>
			<!-- End footer -->
		</main>
	</div>
</body>
</html>