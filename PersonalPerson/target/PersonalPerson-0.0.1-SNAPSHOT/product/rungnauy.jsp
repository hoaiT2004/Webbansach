<%@page import="model.Book"%>
<%@page import="database.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sách Rừng Na Uy</title>
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
	<br>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-lg-4">
				<div id="carouselExampleIndicators" class="carousel slide mb-4"
					data-bs-ride="true">
					<div class="carousel-indicators">
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="0" class="active" aria-current="true"
							aria-label="Slide 1"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="1" aria-label="Slide 2"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="2" aria-label="Slide 3"></button>
					</div>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="<%=url %>/img/rungnauybook.png" alt="1">
						</div>
						<div class="carousel-item">
							<img src="<%=url %>/img/rungnauy1.png" alt="2">
						</div>
						<div class="carousel-item">
							<img src="<%=url %>/img/rungnauy2.png" alt="3">
						</div>
					</div>
					<button class="carousel-control-prev" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
			</div>
			<%
			BookDAO dao = new BookDAO();
			Book Java = dao.searchName("Rừng Na Uy");
			%>
			<div class="col-lg-8">
				<h1 style="text-align: center">Rừng Na Uy - Sách ngôn tình</h1>
				<hr>
				<form action="<%=url %>/dat-hang-controller" class="form" method="get">
								<%
					String baoLoi = request.getAttribute("baoLoiSL")+"";
				baoLoi = (baoLoi.equals("null"))?"":baoLoi;
				%>
				<h4 style="text-align: center;color:red;"><%=baoLoi %></h4>
				<input type="hidden" name = "hd" value="check">
				<input type="hidden" name = "tensach" value="Rừng Na Uy"> 
				<input type="hidden" name = "tenlink" value="rungnauy">
					<h6 style="text-align: right;">
						Đã bán
						<%=100 - Java.getCount_()%>
						sản phẩm
					</h6>
					<div class="row">
						<div class="col-lg-4">
							<h2 style="color: gray;">Giá bán</h2>
						</div>
						<div class="col-lg-8">
							<h3 style="color: left"><%=(int)Java.getPrice()%>VNĐ
							</h3>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-lg-4" style="color: gray;">
							<h2>Mã giảm giá</h2>
						</div>
						<div class="col-lg-2">
							<input class="form-check-input" type="radio" value="10000"
								name="voucher"> <label class="form-check-label"
								for="flexCheckDefault">

								<h2>10k</h2>

							</label>
						</div>
						<div class="col-lg-2">
							<input class="form-check-input" type="radio" value="15000"
								name="voucher"> <label class="form-check-label"
								for="flexCheckDefault">

								<h2>15k</h2>

							</label>
						</div>
						<div class="col-lg-2">
							<input class="form-check-input" type="radio" value="20000"
								name="voucher"> <label class="form-check-label"
								for="flexCheckDefault">

								<h2>20k</h2>

							</label>
						</div>
					</div>
					<span style="color: gray;"><%=Java.getDescribe()%></span>
					<div class="discount-info">
						<div ><h2 style="color:gray;">THÔNG TIN & KHUYẾN MÃI</h2></div>
						<div class="content">
							<p>
								<br /> <span style="color: #000000;"><span
									style="font-size: 14px;">✅ Được kiểm tra hàng và Thanh
										toán khi nhận hàng.<br /> ✅&nbsp;Giao hàng trên Toàn Quốc<br />
										✅&nbsp;Đặt online hoặc gọi ngay
								</span></span><span style="font-size: 14px;"><strong><a
										href="tel:0343199493"><span style="color: #FF0000;"></span></a></strong><strong
									style="font-family: arial, helvetica, sans-serif; font-size: 16px;"><em><a
											href="tel:0343199493"><span
												style="color: rgb(255, 0, 0);">0343199493</span></a></em></strong></span><br /> <span
									style="color: #000000;"><span style="font-size: 14px;">✅<em><strong>&nbsp;</strong></em>Chiết
										khấu cao cho các đại lý và khách đặt sỉ
								</span></span>
							</p>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4" style="color: gray;">
							<h2>Số lượng</h2>
						</div>
						<div class="col-lg-2">
							<input type="number" name="soluong" value="1" />
						</div>
					</div>
					<div class="text-center">
							<input type="submit" value="Thêm vào giỏ hàng"
								class="btn btn-primary" >

						</div>
				</form>
			</div>

		</div>


	</div>




	<!-- End Page content -->
	<!-- Footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
	<!-- End footer -->
</body>
</html>