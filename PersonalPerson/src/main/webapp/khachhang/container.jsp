<%@page import="model.OrderDetails"%>
<%@page import="model.Order"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đơn hàng của tôi</title>
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
	<br>
	<div class="container">
	<div class = "row">
	<div class = "col-lg-1" ><h6 style="color: gray;">Tên đơn</h6></div>
	<div class = "col-lg-2"><h6 style="color: gray;">Chi tiết đơn hàng</h6></div>
	<div class = "col-lg-2"><h6 style="color: gray;">Nơi mua</h6></div>
	<div class = "col-lg-2"><h6 style="color: gray;">Nơi nhận</h6></div>
	<div class = "col-lg-2"><h6 style="color: gray;">Người nhận</h6></div>
	<div class = "col-lg-1"><h6 style="color: gray;">Tổng tiền</h6></div>
	<div class = "col-lg-2"><h6 style="color: gray;">Trạng thái</h6></div>
	</div>
	<br>
	<hr>
		<%
		Set<Order> mySet = cl.getOrd();
		for (Order o : mySet) {
			OrderDetails od = o.getOrderDetails();
			//int money = (int) o.getMissingAmount();
		%>
		<div class = "row">
		<div class = "col-lg-1"><%=o.getOrderCode() %></div>
	<div class = "col-lg-2"><%=od.getSanPham() %></div>
	<div class = "col-lg-2"><%=o.getPurchaseAddress() %></div>
	<div class = "col-lg-2"><%=o.getReceiverAddress() %></div>
	<div class = "col-lg-2"><%=o.getPersonReceiver() %></div>
	<div class = "col-lg-1"><%=od.getTotalMoney() %></div>
	<div class = "col-lg-2"><%=o.getStatus() %></div>
	</div>
	<hr>
		<%
		}
		%>
	</div>
	<!-- End Page content -->

	<!-- Footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
	<!-- End footer -->
</body>
</html>