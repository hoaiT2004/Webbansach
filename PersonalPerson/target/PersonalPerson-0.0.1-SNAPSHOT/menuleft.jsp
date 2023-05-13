<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="col-lg-3">
   <%	String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ request.getContextPath(); %>
				<div class="list-group ">
					<a href="<%=url1 %>/index.jsp" class="list-group-item list-group-item-action">
						Sách lập trình </a>
						<a href="<%=url1 %>/indexkinhdi.jsp"
						class="list-group-item list-group-item-action">Truyện kinh dị</a>
						<a href="<%=url1 %>/indextinhyeu.jsp"
						class="list-group-item list-group-item-action">Sách tình yêu</a>
				</div>
			</div>