package controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.BookDAO;
import database.ClientDAO;
import database.OrderDAO;
import database.OrderDetailsDAO;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import model.Book;
import model.Client;
import model.Order;
import model.OrderDetails;

/**
 * Servlet implementation class DatHangController
 */
@WebServlet("/dat-hang-controller")
public class DatHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DatHangController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String hd = request.getParameter("hd");
		if (hd.equals("check")) {
			kiemTraDangNhap(request, response);
		} else if (hd.equals("dathang")) {
			capNhatHoaDon(request, response);
		}

	}

	private void capNhatHoaDon(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String voucher = request.getParameter("voucher");
		String tenSach = request.getParameter("tensach");
		String soLuong = request.getParameter("soluong");
		String nguoiNhan = request.getParameter("nguoinhan");
		// String tenLink = request.getParameter("tenlink");
		String tienTraTruoc = request.getParameter("thanhtoantruoc");
		String hinhThuc = request.getParameter("hinhthuc");
		String url = "";
		tenSach.trim();// K cần thiết

		System.out.println("tên sách:" + tenSach);
		System.out.println("tên sách = " + tenSach + "\t Hình thức = " + hinhThuc + "\t voucher=" + voucher
				+ "\t Số lượng = " + soLuong);

		// Book
		BookDAO dao = new BookDAO();
		Book b = dao.searchName(tenSach);
		b.setCount_(b.getCount_() - Integer.valueOf(soLuong));
		int k = Integer.valueOf(soLuong);

		// OrderDetails
		int id = 1;
		OrderDetailsDAO dao2 = new OrderDetailsDAO();
		while (true) {
			OrderDetails check = dao2.selectById("đơn " + id);
			if (check == null) {
				break;
			}
			id++;
		}

		OrderDetails details = new OrderDetails();
		details.setOrderDetailsCode("đơn " + id);
		if (voucher != null)
			details.setVoucher(Integer.parseInt(voucher));
		else
			details.setVoucher(0);
		details.setCount_(k);
		details.setPrice((int) b.getPrice());
		details.setTotalMoney(details.getCount_() * details.getPrice() - details.getVoucher());
		details.setSanPham(details.getCount_() + " quyển sách " + b.getBookName());
		// Order
		Order order = new Order();
		order.setAmountPaid(Integer.valueOf(tienTraTruoc));
		order.setMissingAmount(details.getTotalMoney() - order.getAmountPaid());
		int id2 = 1;
		OrderDAO dao3 = new OrderDAO();
		while (true) {
			Order check = dao3.selectById("o" + id2);
			if (check == null) {
				break;
			}
			id2++;
		}
		order.setOrderCode("o" + id2);
		HttpSession session = request.getSession();
		Client cl = null;
		Object obj = session.getAttribute("khachHang");
		cl = (Client) obj;
		order.setPurchaseAddress(cl.getAddress());
		order.setReceiverAddress(cl.getReceiverAddress());
		order.setPersonReceiver(nguoiNhan);
		if (order.getMissingAmount() == 0) {
			order.setPaymentStatus("đã thanh toán");
		} else if (order.getMissingAmount() > 0) {
			order.setPaymentStatus("chưa thanh toán");
		} else {
			order.setPaymentStatus("Thanh toán thừa");
		}
		order.setStatus("đang giao hàng");
		order.setPayments(hinhThuc);
		// Mối quan hệ
		order.setOrderDetails(details);
		Set<Order> s1 = new HashSet<>();
		if (cl.getOrd() != null) {
			Set<Order> s11 = cl.getOrd();
			if (s11.size() > 0) {
				for (Order order2 : s11) {
					s1.add(order2);
				}
			}
		}
		Set<Client> s2 = new HashSet<>();
		if (order.getClient() != null) {
			Set<Client> s22 = order.getClient();
			if (s22.size() > 0) {
				for (Client client : s22) {
					s2.add(client);
				}
			}
		}
		s1.add(order);
		s2.add(cl);
		order.setClient(s2);
		cl.setOrd(s1);

		OrderDAO details2 = new OrderDAO();
		ClientDAO clientDAO = new ClientDAO();
		clientDAO.update(cl);
		dao.update(b, b);
		int x = details2.insert(order);
		System.out.println("Thêm " + x + " đơn hàng!");
		if (x <= 0) {
			url = "/thanhtoan/order.jsp";
		} else {
			url = "/thanhtoan/statusOrder.jsp";
		}
		request.setAttribute("order", order);
		request.setAttribute("orderdetails", details);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private void kiemTraDangNhap(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String tenSach = request.getParameter("tensach");
		String tenLink = request.getParameter("tenlink");
		String voucher = request.getParameter("voucher");
		String soLuong = request.getParameter("soluong");
		HttpSession session = request.getSession();
		Client cl = null;
		Object obj = session.getAttribute("khachHang");
		cl = (Client) obj;
		String url = "";
		if (cl != null) {
			String baoLoiSL = "";
			if (Integer.valueOf(soLuong) <= 0) {
				baoLoiSL += "Chọn số liệu tối thiểu là 1 để mua";
				request.setAttribute("baoLoiSL", baoLoiSL);
				url = "/product/" + tenLink + ".jsp";
			} else {
				String link = "dathang";
				System.out.println("Có khách hàng");
				url = "/thanhtoan/order.jsp";
				System.out.println("tên sách = " + tenSach + "\t Tên link = " + tenLink + "\t voucher=" + voucher
						+ "\t Số lượng = " + soLuong);
				request.setAttribute("tensach", tenSach);
				request.setAttribute("tenlink", tenLink);
				request.setAttribute("voucher", voucher);
				request.setAttribute("soluong", soLuong);
			}
		} else {
			url = "/khachhang/dangNhap.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
