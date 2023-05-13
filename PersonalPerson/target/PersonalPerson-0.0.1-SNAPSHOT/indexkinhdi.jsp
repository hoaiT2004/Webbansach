<%@page import="model.Book"%>
<%@page import="database.BookDAO"%>
<%@page import="model.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sách kinh dị</title>
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
	<%@include file="header.jsp"%>
	<!-- End header -->

	<!-- Page content -->
	<div class="container mt-4">
		<div class="row">
			<!-- Menu left -->
			<%@include file="menuleft.jsp"%>
			<!-- End Menu left -->

			<!-- Slider and Products -->
			<div class="col-lg-9">
				<!-- Slider -->
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
							<img src="img/bookstore2.png" class="d-block w-100" alt="">
						</div>
						<div class="carousel-item">
							<img src="img/bookstore1.png" class="d-block w-100" alt="2">
						</div>
						<div class="carousel-item">
							<img src="img/bookstore3.png" class="d-block w-100" alt="3">
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
				<!-- End Slider -->
				<!-- Products -->
				<div class="row">
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="<%=url %>/product/zoo.jsp"><img
								class="card-img-top" src="img/ZOObook.png" alt="dá"></a>
							<div class="card-body">
								<h4 class="card-title">
									<%
									BookDAO dao = new BookDAO();
									Book java = dao.searchName("Zoo");
									Book C = dao.searchName("Ác Quỷ Nam Kinh");
									Book JS = dao.searchName("Ring – Vòng Tròn Ác Nghiệt");
									Book Python = dao.searchName("GOTH – Những Kẻ Hắc Ám");
									Book Golang = dao.searchName("Bạch Dạ Hành");
									Book Php = dao.searchName("Mùi Hương");
									%>
									<a href="#">Zoo</a>
								</h4>
								<h5><%=java.getPrice()%></h5>
								<p class="card-text"><%=java.getDescribe()%></p>
							</div>
							<div class="card-footer">

								<p style="text-align: right; color: gray;">
									Đã bán
									<%=100-java.getCount_()%></p>
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="<%=url %>/product/acquynamkinh.jsp"><img class="card-img-top"
								src="img/acquybook.png" style="height: 171px;" alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Ác Quỷ Nam Kinh</a>
								</h4>
								<h5><%=C.getPrice()%></h5>
								<p class="card-text"><%=C.getDescribe()%></p>
							</div>
							<div class="card-footer">
								<p style="text-align: right; color: gray;">
									Đã bán
									<%=100-C.getCount_()%></p>
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="<%=url %>/product/ring.jsp"><img
								class="card-img-top" src="img/vongtronacnghietbook.png"
								style="height: 171px;" alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Ring – Vòng Tròn Ác Nghiệt</a>
								</h4>
								<h5><%=Python.getPrice()%></h5>
								<p class="card-text"><%=Python.getDescribe()%></p>
							</div>
							<div class="card-footer">
								<p style="text-align: right; color: gray;">
									Đã bán
									<%=100-Python.getCount_()%></p>
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="<%=url %>/product/goth.jsp"><img class="card-img-top"
								src="img/gothbook.png" style="height: 171px;" alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">GOTH – Những Kẻ Hắc Ám</a>
								</h4>
								<h5><%=JS.getPrice()%></h5>
								<p class="card-text"><%=JS.getDescribe()%></p>
							</div>
							<div class="card-footer">
								<p style="text-align: right; color: gray;">
									Đã bán
									<%=100-JS.getCount_()%></p>
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="<%=url %>/product/bachdahanh.jsp"><img
								class="card-img-top" src="img/bachdahanhbook.png"
								style="height: 171px;" alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Bạch Dạ Hành</a>
								</h4>
								<h5><%=Golang.getPrice()%></h5>
								<p class="card-text"><%=Golang.getDescribe()%></p>
							</div>
							<div class="card-footer">
								<p style="text-align: right; color: gray;">
									Đã bán
									<%=100-Golang.getCount_()%></p>
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="<%=url%>/product/muihuong.jsp"><img class="card-img-top"
								src="img/muihuongbook.png" style="height: 171px;" alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Mùi Hương</a>
								</h4>
								<h5><%=Php.getPrice()%></h5>
								<p class="card-text"><%=Php.getDescribe()%></p>
							</div>
							<div class="card-footer">
								<p style="text-align: right; color: gray;">
									Đã bán
									<%=100-Php.getCount_()%></p>
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>
				</div>
				<!-- End Products -->
			</div>
			<!-- End Slider and Products -->
		</div>
	</div>
	<!-- End Page content -->
	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- End footer -->
</body>
</html>