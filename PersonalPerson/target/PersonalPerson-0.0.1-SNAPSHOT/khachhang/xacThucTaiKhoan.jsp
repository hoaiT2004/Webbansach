<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xác thực tài khoản</title>
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
	String maxacthuc = request.getAttribute("baoLoiXacThuc")+"";
	maxacthuc = (maxacthuc.equals("null"))?"":maxacthuc;
	%>
	<!-- header -->
	<%@include file="../header.jsp"%>
	<div class="container">
		<main class="form-signin w-100 m-auto">
		<h4 on></h4>
			<form action="<%=url1%>/khach-hang-controller"
				class="form">
				<input type="hidden" name="hanhdong" value ="xac-thuc">
				<div class="text-center">
				<p style="color:red;"><%=maxacthuc %></p>
					<div class="form-floating">
						<input type="number" class="form-control" id="maxacnhan"
							required="required" name = "maxacnhan"> <label for="maxacnhan">Mã
							xác nhận<span style="color:red;">*</span></label>
					</div>
					<br>
					<button type="submit" class="w-25 btn btn-lg btn-primary">Xác
						nhận</button>
				</div>
			</form>
			<!-- Footer -->
			<jsp:include page="../footer.jsp"></jsp:include>
			<!-- End footer -->
		</main>
	</div>
	<script type="text/javascript">
	   function myFunction() {
		      return "Chúng tôi đã gửi mã xác nhận vào email của bạn!!!";
		    }
		    var result = myFunction();
		    console.log(result);
	</script>
</body>
</html>