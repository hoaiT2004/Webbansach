<%@page import="model.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thay đổi thông tin</title>
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
<!-- Header -->
	<%@include file="../header.jsp" %>
	<!-- End header -->
	<%
	String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ request.getContextPath();
	String baoLoiin4 = request.getAttribute("baoLoiThayDoiin4") + "";
	baoLoiin4 = (baoLoiin4.equals("null")) ? "" : baoLoiin4;
	String thanhCong = request.getAttribute("thanhCong") + "";
	thanhCong = (thanhCong.equals("null")) ? "" : thanhCong;
	Client cl1 = null;
	Object obj1 = session.getAttribute("khachHang");
	cl1 = (Client) obj1;
	if (cl1 == null) {
	%>
	Bạn chưa đăng nhập hệ thống!Vui lòng quay lại
	<a href="<%=url %>/index.jsp">trang chủ</a>
	<%
	} else {
	%>
	<div class="main__user">
		<div class="setting__main">
			<form action="<%=url %>/khach-hang-controller" method="POST" class="form">
				<input type="hidden" name="hanhdong" value ="doi-in4">
				<!--  
                <input type="hidden" name="_token" value="FDq4hMabcLPR4GloMJrH2Ql2W7Qz5Tjeo4c5oNyf">
                <div class="setting__main__acc">
                    <div class="setting__main__popup disappear" onclick="popup_disappear('setting__main__popup')">
                        <img src="https://code.ptit.edu.vn/2020/images/double-tick-indicator.png" alt="">
                        <p id="upload_message"></p>
                    </div>
                    <div class="setting__main__popup__fail__single disappear" onclick="popup_disappear('setting__main__popup__fail__single')">
                        <img src="https://code.ptit.edu.vn/2020/images/double-tick-indicator.png" alt="">
                        <p id="upload_error"></p>
                    </div>	
                    -->
				<div class="text-center">
					<h1 class="setting__main__acc__title" style="text-align: center;">Cập
						nhật thông tin</h1>
					<%
					if (baoLoiin4.length() > 0) {
					%>
					<span style="color: red"> <%=baoLoiin4%>
					</span>
					<%
					} 
					else if(thanhCong.length() > 0){
					%>
					<span style="color: green"> <%=thanhCong%>
					</span><a href="<%=url %>/index.jsp">Trang chủ</a>
					<%
					}
					%>
					<!-- 
						<table>
							<tr>
								<td class="setting__main__label setting__label__hide">Ảnh
									đại diện</td>
								<td class="setting__main__img__input"><label
									id="avt__label" for="upload__avt"> <img
										src="https://code.ptit.edu.vn/2020/images/avt.png" alt=""
										id="loadFileImg" /> <span>Đổi ảnh đại diện</span>
								</label> <input type="file" name="file" id="upload__avt"></td>
							</tr>
                        <tr>
                            <td class="setting__main__label setting__label__hide">Tên</td>
                            <td>
                                <p class="setting__main__name">Nguyễn Xuân Hòa</p>
                                <p class="setting__main__sub">Cập nhật ảnh đại diện, địa chỉ email và mật khẩu của bạn của bạn.</p>
                            </td>
                        </tr>
                         
						</table>   </div>
				-->
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="mb-3">
							<div class="form-floating">
								<input id="hoten" class="form-control" type="text" name="hoten"
									value=<%=cl.getFullName()%>> <label for="hoten"
									class="form-label">Họ và tên</label>
							</div>
						</div>
						<div class="mb-3">
							<div class="form-floating">
								<select id="gioitinh" name="gioitinh" class="form-control">
									<option></option>
									<option value="khongBiet"
										<%=(cl.getSex().equals("Chưa rõ")) ? "selected='selected'" : ""%>>Chưa
										rõ</option>
									<option value="Nam"
										<%=(cl.getSex().equals("Nam")) ? "selected='selected'" : ""%>>Nam</option>
									<option value="Nữ"
										<%=(cl.getSex().equals("Nữ")) ? "selected='selected'" : ""%>>Nữ</option>
								</select> <label for="gender" class="form-label">Giới tính <span
									style="color: red;">*</span>
								</label>
							</div>
						</div>
						<div class="mb-3">
							<div class="form-floating">
								<input class="form-control" id="diachi" type="text"
									name="diachi" value=<%=cl.getEmailAddress()%>> <label
									for="diachi" class="form-label">Địa chỉ</label>
							</div>
						</div>
						<div class="mb-3">
							<div class="form-floating">
								<input class="form-control" name="diachimuahang"
									id="diachimuahang" type="text"
									value=<%=cl.getReceiverAddress()%>></input> <label
									for="diachimuahang" class="form-label">Địa chỉ mua hàng</label>

							</div>
						</div>
						<!-- 
						<div class="mb-3">
							<div class="form-floating">
								<input class="form-control" id="citizen_id" type="text"
									name="citizen_id"> <label for="citizen_id"
									class="form-label">CMND/CCCD</label>
							</div>
						</div>
						 -->
					</div>
					<div class="col-md-6">
						<div class="mb-3">
							<div class="form-floating">
								<input id="birthday" class="form-control" type="date"
									placeholder="dd/mm/yyyy" name="birthday"> <label
									for="birthday" class="form-label"
									value=<%=cl.getDateOfBirth()%>>Ngày sinh <span
									style="color: red;">*</span></label>
							</div>
						</div>
						<div class="mb-3">
							<div class="form-floating">
								<input class="form-control" id="phone" type="tel" name="phone"
									value=<%=cl.getPhoneNumber()%>> <label for="phone"
									class="form-label">SĐT</label>
							</div>
						</div>
						<!--  
						<div class="mb-3">
							<label for="about" class="form-label">Giới thiệu</label>
							<textarea id="about" rows="4" cols="78" name="about"></textarea>

-->
						<p class="setting__main__des">
							(<span style="color: red;">*</span>) Bắt buộc
						</p>
					</div>
				</div>
				<hr>
				<button type="submit" value="" class="w-100 btn btn-lg btn-primary"
					style="background-color: blue;">Cập nhật</button>
			</form>
		</div>
	</div>
	<%
	}
	%>
	<!-- Footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
	<!-- End footer -->
</body>
</html>