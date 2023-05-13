<%@page import="database.OrderDetailsDAO"%>
<%@page import="model.Order"%>
<%@page import="model.OrderDetails"%>
<%@page import="model.Book"%>
<%@page import="database.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thanh toán hóa đơn</title>
</head>
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
<body>

	<!-- Header -->
	<%@include file="../header.jsp"%>
	<!-- End header -->

	<!-- Page content -->
	<%
	String tenSach = request.getAttribute("tensach") + "";
	String tenLink = request.getAttribute("tenlink") + "";
	String voucher = request.getAttribute("voucher") + "";
	String soLuong = request.getAttribute("soluong") + "";
	BookDAO dao = new BookDAO();
	Book b = dao.searchName(tenSach);
	voucher = (voucher.equals("null"))?"0":voucher;
	int tongTien = 0;
	int money = (int)b.getPrice();
	if (voucher != null) {
		tongTien = ((int) b.getPrice() * Integer.valueOf(soLuong) - Integer.valueOf(voucher));
	} else {
		tongTien = (int) b.getPrice() * Integer.valueOf(soLuong);
	}
	%>
	<h1 style="text-align: center;"><%=tenSach%></h1>
	<br>
	<hr>
	<form method="get" action="<%=url%>/dat-hang-controller">
		<input type="hidden" name="hd" value="dathang"> <input
			type="hidden" name="voucher" value="<%=voucher%>"> <input
			type="hidden" name="tensach" value="<%=tenSach%>"> <input
			type="hidden" name="soluong" value="<%=soLuong%>">
		<div class="row">
			<div class="col-lg-4">
				<h2 style="color: gray;">Giá bán</h2>
			</div>
			<div class="col-lg-8">
				<h3 style="color: left"><%=money%>
				</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4">
				<h2 style="color: gray;">Số lượng</h2>
			</div>
			<div class="col-lg-8">
				<h3 style="color: left"><%=soLuong%>
				</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4">
				<h2 style="color: gray;">Voucher</h2>
			</div>
			<div class="col-lg-8">
				<h3 style="color: left"><%=voucher%>
				</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4" style="color: gray;">
				<h2>Hình thức thanh toán</h2>
			</div>
			<div class="col-lg-2">
				<input class="form-check-input" type="radio" value="tiền mặt"
					name="hinhthuc"> <label class="form-check-label"
					for="flexCheckDefault">

					<h2>Tiền mặt</h2>

				</label>
			</div>
			<div class="col-lg-4">
				<input class="form-check-input" type="radio" value="chuyển khoản"
					name="hinhthuc"> <label class="form-check-label"
					for="flexCheckDefault">

					<h2>Chuyển khoản</h2>

				</label>
			</div>
		</div>
		<!--  -->
		<div class="row">
			<div class="col-lg-4">
				<h2 style="color: gray;">Trả trước</h2>
			</div>
			<div class="col-lg-8">
				<input type="number" name="thanhtoantruoc" value="10000">
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4">
				<h2 style="color: gray;">Người nhận</h2>
			</div>
			<div class="col-lg-8">
				<input type="text" name = "nguoinhan">
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-lg-4">
				<h2 style="color: gray;">Tổng tiền</h2>
			</div>
			<div class="col-lg-8">
				<h3 style="color: left"><%=tongTien%>
				</h3>
			</div>
		</div>
		<br> <br>
		<div class="text-center">
			<input type="submit" value="Thanh toán" class="btn btn-primary">

		</div>
	</form>

	<!-- End Page content -->

	<!-- Footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
	<!-- End footer -->
</body>
</html>