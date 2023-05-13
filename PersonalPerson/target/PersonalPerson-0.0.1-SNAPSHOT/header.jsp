<%@page import="model.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ request.getContextPath(); %>
<nav class="navbar navbar-expand-lg bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src="<%=url %>/img/avatar.png"
				alt="Bootstrap" height="30">
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="<%=url %>/index.jsp">Trang chủ</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Combo
							giảm giá</a></li>
					<li class="nav-item"><a class="nav-link disabled">Hết hàng</a>
					</li>
				</ul>
				<form class="d-flex" role="search" action="#">
					<input class="form-control me-2" type="search"
						placeholder="Nội dung tìm kiếm" aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Tìm</button> 
					<%
					Client cl = null;
					Object obj = session.getAttribute("khachHang");
					cl = (Client) obj;
					if (cl == null) {
					%>
					<a class="btn btn-primary" type="submit"
						style="while-space: nowrap;" href="<%=url %>/khachhang/dangNhap.jsp"><span>Đăng Nhập</span></a>
					<%
					} else {
					%>
					<input type = "hidden" name="hanhdong" value = "dang-xuat">
					<div class="row text-center" style="margin-left: 0.25em">
						<div class="dropstart">
							<button class="btn btn-secondary dropdown-toggle" type="button"
								data-bs-toggle="dropdown" aria-expanded="false">Tài khoản
								</button>
								<ul class="dropdown-menu">	
							<!--  
								<div class="btn-group dropstart">
									<button type="button" class="btn btn-secondary dropdown-toggle"
										data-bs-toggle="dropdown" aria-expanded="false">Cài
										đặt & quyền riêng tư</button>
									<ul class="dropdown-menu">
									-->
										<li><a class="dropdown-item" href="<%=url %>/khachhang/thayDoiAnh.jsp">Thay đổi ảnh đại diện</a></li>
							<li><a class="dropdown-item" href="<%=url %>/khachhang/thayDoiThongTin.jsp">Thay đổi thông tin</a></li>
							<li><a class="dropdown-item" href="#">Nhật ký hoạt động</a></li>
							<li><a class="dropdown-item" href="#">Ngôn ngữ</a></li>
							<li><a class="dropdown-item" href="<%=url %>/khachhang/doiMatKhau.jsp">Đổi
									mật khẩu</a></li>
							<hr>
							<!--  </ul>	
								</div>
								
							<ul class="dropdown-menu">
-->

								<li><a class="dropdown-item" href="<%=url%>/khachhang/container.jsp">Đơn hàng của tôi</a></li>
								<li><a class="dropdown-item" href="">Trợ giúp
										& hỗ trợ</a></li>
								<li><a class="dropdown-item" href="#">Đóng góp ý kiến</a></li>
								<hr>
								<li><a class="dropdown-item" href="<%=url %>/khach-hang-controller?hanhdong=dang-xuat">Đăng xuất</a></li>
							</ul>
						</div>
	
					</div>
					<%
					}
					%>
				</form>
			</div>
		</div>
	</nav>