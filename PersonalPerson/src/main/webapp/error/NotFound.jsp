<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>www.web</title>
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
<%	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ request.getContextPath();
%>
<h1 style="text-align: center;color: red;">ERROR 404:Not Found</h1>
<div class = "text-center">
<%

String link = request.getHeader("referer");//lấy ra link trang web trước đó
String currentUrl = request.getRequestURL().toString();//Lấy ra link hiện tại
%>
<form action="<%=currentUrl%>" >
<img alt="Not Found" src="<%=url %>/img/404.png" style="height: 500px;width: 100%" >
<br>
<br>
<input type="submit" value="Tải lại" class = "btn btn-success" style="width: 500px;"> 
</form>
</div>
</body>
</html>