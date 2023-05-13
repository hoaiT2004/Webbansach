<%@page import="model.OrderDetails"%>
<%@page import="model.Order"%>
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
	<%
	Object obj1 = request.getAttribute("order");
	Order order = (Order) obj1;
	Object obj2 = request.getAttribute("orderdetails");
	OrderDetails orderdetails = (OrderDetails) obj2;
	%>
	<!-- Page content -->
	<h1 style="text-align: center;">TRẠNG THÁI</h1>
	<br>
	<hr>
	<form action="<%=url%>/index.jsp" method="get">
		<div class="row">
			<div class="col-lg-4">
				<h2 style="color: gray;">Sản phẩm</h2>
			</div>
			<div class="col-lg-8">
				<h3 style="color: left"><%=orderdetails.getSanPham()%>
				</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4">
				<h2 style="color: gray;">Tổng tiền</h2>
			</div>
			<div class="col-lg-8">
				<h3 style="color: left"><%=orderdetails.getTotalMoney()%>
				</h3>
			</div>
		</div>
		<%
		if (order.getMissingAmount() > 0) {
		%>
		<div class="row">
			<div class="col-lg-4">
				<h2 style="color: gray;">Số tiền còn thiếu</h2>
			</div>
			<div class="col-lg-8">
				<h3 style="color: left"><%=(int)order.getMissingAmount()%>
				</h3>
			</div>
		</div>
		<%
		} else {
		int k = Math.abs((int) order.getMissingAmount());
		%>
		<div class="row">
			<div class="col-lg-4">
				<h2 style="color: gray;">Số tiền thừa</h2>
			</div>
			<div class="col-lg-8">
				<h3 style="color: left"><%=k%>
				</h3>
			</div>
		</div>
		<%
		}
		%>
		<div class="row">
			<div class="col-lg-4">
				<h2 style="color: gray;">Trạng thái thanh toán</h2>
			</div>
			<div class="col-lg-8">
				<h3 style="color: left"><%=order.getPaymentStatus()%>
				</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4">
				<h2 style="color: gray;">Hình thức</h2>
			</div>
			<div class="col-lg-8">
				<h3 style="color: left"><%=order.getPayments()%>
				</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4">
				<h2 style="color: gray;">Địa chỉ đặt hàng</h2>
			</div>
			<div class="col-lg-8">
				<h3 style="color: left"><%=order.getPurchaseAddress()%>
				</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4">
				<h2 style="color: gray;">Địa chỉ nhận hàng</h2>
			</div>
			<div class="col-lg-8">
				<h3 style="color: left"><%=order.getReceiverAddress()%>
				</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4">
				<h2 style="color: gray;">Người nhận</h2>
			</div>
			<div class="col-lg-8">
				<h3 style="color: left"><%=order.getPersonReceiver()%>
				</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4">
				<h2 style="color: gray;">Trạng thái giao hàng</h2>
			</div>
			<div class="col-lg-8">
				<h3 style="color: left"><%=order.getStatus()%>
				</h3>
			</div>
		</div>
		<div class="text-center">
			<input type="submit" value="Quay lại trang chủ"
				class="btn btn-primary">

		</div>
	</form>
	<!-- End Page content -->

	<!-- Footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
	<!-- End footer -->
</body>
</html>