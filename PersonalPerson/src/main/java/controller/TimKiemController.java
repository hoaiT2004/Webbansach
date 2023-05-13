package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.BookDAO;
import model.Book;

/**
 * Servlet implementation class TimKiemController
 */
@WebServlet("/tim-kiem")
public class TimKiemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TimKiemController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String key = request.getParameter("key");
		BookDAO dao = new BookDAO();
		Book b = dao.searchName(key);
		String url = "";
		String k = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
		int res = 0;
		int check = 0;
		if (b != null) {
			res = 1;
			check = 1;
			if (key.equalsIgnoreCase(
					"Tâm Lý Học Và Chuyện Yêu: Vì Sao Đàn Ông Thích Phụ Nữ Trẻ, Phụ Nữ Thích Đàn Ông Giàu?")) {
				url = "/product/tamlyhocvachuyenyeu.jsp";
			} else {
				url = "/product/" + b.getBookName() + ".jsp";
			}
		} else {
			if (res == 0) {
				if (key.equalsIgnoreCase("trang chủ")) {
					url = "/index.jsp";
					check = 1;
				} else if (key.equalsIgnoreCase("truyện kinh dị")) {
					url = "/indexkinhdi.jsp";
					check = 1;
				} else if (key.equalsIgnoreCase("sách tình yêu")) {
					url = "/indextinhyeu.jsp";
					check = 1;
				} else if (key.equalsIgnoreCase("sách lập trình")) {
					url = "/index.jsp";
					check = 1;
				}
			} else {
				res = 0;
				if (key.equalsIgnoreCase("trang chủ")) {
					url = "../index.jsp";
					check = 1;
				} else if (key.equalsIgnoreCase("truyện kinh dị")) {
					url = "../indexkinhdi.jsp";
					check = 1;
				} else if (key.equalsIgnoreCase("sách tình yêu")) {
					url = "../indextinhyeu.jsp";
					check = 1;
				} else if (key.equalsIgnoreCase("sách lập trình")) {
					url = "../index.jsp";
					check = 1;
				}
			}
			if(check == 0) {
				url = "/error/NotFound.jsp";
			}
			//request.setAttribute("key", key);
			check = 0;
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
