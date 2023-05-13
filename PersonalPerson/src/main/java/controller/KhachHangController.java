package controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import database.ClientDAO;
import model.Client;
import util.GuiEmail;
import util.MaHoa;
import util.SoNgauNhien;

/**
 * Servlet implementation class KhachHangController
 */
@WebServlet("/khach-hang-controller")
public class KhachHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KhachHangController() {
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
		String hanhDong = request.getParameter("hanhdong");
		System.out.println("Hành động=" + hanhDong);
		//đăng ký tài khoản
		if (hanhDong.equals("dang-ky")) {
			kiemTraDangKy(request, response);
		}else if (hanhDong.equals("xac-thuc")) {
			xacThuc(request, response);
		} 
		//đăng nhập
		else if (hanhDong.equals("dang-nhap")) {
			kiemTraDangNhap(request, response);
			//Đổi mk
		} else if (hanhDong.equals("doi-mk")) {
			doiMatKhau(request, response);
			//Thay đổi thông tin
		} else if (hanhDong.equals("doi-in4")) {
			thayDoiThongTin(request, response);
			//Đăng xuất
		} else if (hanhDong.equals("dang-xuat")) {
			dangXuat(request, response);
			//avatar
		}else if (hanhDong.equals("thaydoianh")) {
			thayDoiAnh(request, response);
			//Quên mật khẩu
		}else if (hanhDong.equals("laylai-mk")) {
			layLaiMK(request, response);
		} else if (hanhDong.equals("xac-thuc-layMK")) {//doi-mk-moilaylai
			xacThucTenDN(request, response);
		}else if (hanhDong.equals("doi-mk-moilaylai")) {//doi-mk-moilaylai
			capNhatMK(request, response);
		}
	}

	private void thayDoiAnh(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
//		String duongDanAnh = request.getParameter("duongDanAnh");
//		String baoLoi = "";
//		String url = "/khachhang/thayDoiAnh.jsp";
//		HttpSession session = request.getSession();
//		Object obj = session.getAttribute("khachHang");
//		Client cl = (Client)obj;
//		cl.setDuongDan(duongDanAnh);
//		ClientDAO dao  =new ClientDAO();
//		int res = dao.updateImage(cl);
//		if(res > 0) {
//			baoLoi += "Thay đổi ảnh thành công";
//		}else {
//			baoLoi += "Quá trình thay đổi thất bại!";
//		}
//		request.setAttribute("baoLoi", baoLoi);
//		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
//		rd.forward(request, response);
		// lấy khách hàng từ session
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("khachHang");
		Client cl = (Client) obj;
		if (cl != null) {
			try {
				String folder = getServletContext().getRealPath("avatar");
				System.out.println(folder);
				File file;
				int maxFileSize = 5000 * 1024;
				int maxMemSize = 5000 * 1024;
				String contentType = request.getContentType();
				if (contentType.indexOf(contentType) >= 0) {
					DiskFileItemFactory factory = new DiskFileItemFactory();

					// Quy định dung lượng tối đa cho mỗi file
					factory.setSizeThreshold(maxMemSize);

					// Tạo file upload
					ServletFileUpload upload = new ServletFileUpload();

					// Quy định dung lượng tối đa của web
					upload.setSizeMax(maxFileSize);

					List<FileItem> files = upload.parseRequest(request);
					for (FileItem fileItem : files) {
						if (!fileItem.isFormField()) {
							String fileName = System.currentTimeMillis() + fileItem.getName();
							String path = folder + "\\" + fileName;
							file = new File(path);
							try {
								fileItem.write(file);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							cl.setUrl(fileName);
							ClientDAO dao = new ClientDAO();
							dao.updateImage(cl);
							cl = dao.selectById(cl);
						} else {//Kp là link
							String name = fileItem.getFieldName();
							String value = fileItem.getString();
							System.out.println(name + " : " + value);
						}
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}

	}
	private void layLaiMK(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String tenDangNhap = request.getParameter("tendangnhap");
		ClientDAO dao = new ClientDAO();
		Client cl = dao.LayTaiKhoanTuTenDangNhap(tenDangNhap);
		HttpSession session = request.getSession();
		session.setAttribute("tenkhachhang", cl);
		String baoLoiLayMK = "";
		String url = "";
		if(cl == null) {
			baoLoiLayMK += "Tên đăng nhập không tồn tại<br>";
			url = "/khachhang/layLaiMK.jsp";
		}else {
			String maCode = SoNgauNhien.soNgauNhien();
			String link = "http://localhost:8080/Myproject/khach-hang-controller?hanhdong=xac-thuc-layMK&maxacnhan="
					+ maCode+"&macode="+maCode;
			String noiDung = "<p>Nhóc_dev xin ch&agrave;o bạn <strong>" + cl.getFullName() + "</strong>,</p>\r\n"
					+ "<p>Vui l&ograve;ng x&aacute;c thực t&agrave;i khoản của bạn bằng c&aacute;ch nhập m&atilde; <strong>"
					+ maCode + "</strong>, hoặc click trực tiếp v&agrave;o đường link sau đ&acirc;y:</p>\r\n"
					+ "<p><a href=\"" + link + "\">" + link + "</a></p>\r\n"
					+ "<p>Lưu ý mã xác thực chỉ có thời hạn đến hết " + cl.getTimeOfSpecify() + "</p>\r\n"
					+ "<p>Đ&acirc;y l&agrave; email tự động, vui l&ograve;ng kh&ocirc;ng phản hồi email n&agrave;y.</p>\r\n"
					+ "<p>Tr&acirc;n trọng cảm ơn.</p>";
			System.out.println(GuiEmail.guiEmail(cl.getEmailAddress(), "Xác nhận tài khoản tại web.nhóc_dev",
					noiDung));
			request.setAttribute("macode", maCode);
			url = "/khachhang/xacNhanTenDangNhap.jsp";
		}
		request.setAttribute("baoLoiLayMK", baoLoiLayMK);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void xacThuc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String maXacNhan = request.getParameter("maxacnhan");
		String baoLoiXacThuc = "";
		String url = "";
		// lấy khách hàng vừa đăng ký
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("khachhangmoidangky");
		Client cl = (Client) obj;
		if (maXacNhan.length() != 6) {
			baoLoiXacThuc += "Mã xác nhận phải đủ 6 số<br>";
		}
		// String maXacNhanTaiKhoan = request.getAttribute("maxacthuc")+"";
		System.out.println(maXacNhan);
		System.out.println(cl.getVerificationCodes());
		if (!maXacNhan.equals(cl.getVerificationCodes())) {
			baoLoiXacThuc += "Mã xác thực không chính xác<br>";
		}
		// Xử lí nếu mã xác thực hết thời hạn
//			Date todaysDate = new Date(new java.util.Date().getTime());
//			Calendar c = Calendar.getInstance();
//			c.setTime(todaysDate);
//			Date thoiGianHieuLucXacThuc = new Date(c.getTimeInMillis());
//			if(thoiGianHieuLucXacThuc > cl.getThoiGianHieuLucCuaMaXacThuc()){
//				
//			}
		request.setAttribute("baoLoiXacThuc", baoLoiXacThuc);
		if (baoLoiXacThuc.length() <= 0) {
			cl.setAuthenticationStatus(true);
			ClientDAO dao = new ClientDAO();
			System.out.println(dao.updateVerifyInformation(cl));
			url = "/khachhang/thanhCong.jsp";
		} else {
			url = "/khachhang/xacThucTaiKhoan.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);

	}
	private void xacThucTenDN(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String maXacNhan = request.getParameter("maxacnhan");
		String maCode = request.getParameter("macode");
		String baoLoiXacThuc = "";
		String url = "";
		if (maXacNhan.length() != 6) {
			baoLoiXacThuc += "Mã xác nhận phải đủ 6 số<br>";
		}
		System.out.println(maXacNhan);
		System.out.println(maCode);
		if (!maXacNhan.equals(maCode)) {
			baoLoiXacThuc += "Mã xác thực không chính xác<br>";
		}
		request.setAttribute("baoLoiXacThuc", baoLoiXacThuc);
		if (baoLoiXacThuc.length() <= 0) {
			url = "/khachhang/updateMK.jsp";
		} else {
			url = "/khachhang/xacNhanTenDangNhap.jsp";
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

	private void dangXuat(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();// xóa data
		try {
			String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath();
			response.sendRedirect(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void kiemTraDangNhap(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String tenLink = request.getParameter("tenlink");
		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");
		// kiểm tra tên đăng nhập và mật khẩu
		ClientDAO dao = new ClientDAO();
		model.Client cl = new model.Client();
		cl.setUserName(tenDangNhap);
		MaHoa mh = new MaHoa();
		matKhau = mh.toSHA1(matKhau);
		cl.setPassword(matKhau);
		model.Client khachHang = dao.kiemTraMatKhauVaTenDangNhap(cl);
		// System.out.println(khachHang);
		String baoLoi = "";
		String url = "";
		// Check lỗi
		System.out.println(khachHang);
		if (khachHang == null) {
			baoLoi += "Tài khoản hoặc mật khẩu không hợp lệ";
		}
		// Set Attribute
		// request.setAttribute("matkhau", matKhau);
		request.setAttribute("tenDangNhap", tenDangNhap);
		request.setAttribute("baoLoiDN", baoLoi);
//Gán đường dẫn	
		if (baoLoi.length() > 0) {
			url = "/khachhang/dangNhap.jsp";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("khachHang", khachHang);
			System.out.println("tên link="+tenLink);
			if(!tenLink.equals("null")) {
				url = "/product/"+tenLink+".jsp";
			}else {
			url = "/index.jsp";
			}
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void kiemTraDangKy(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String tenDangNhap = request.getParameter("tendangnhap");
		String matkhau = request.getParameter("matkhau");
		String nhapLaiMatKhau = request.getParameter("nhaplaimatkhau");
		String hoVaTen = request.getParameter("hovaten");
		String gioiTinh = request.getParameter("gioitinh");
		String ngaySinh = request.getParameter("ngaysinh");
		String diaChi = request.getParameter("diachi");
		String diaChiMuaHang = request.getParameter("diachimuahang");
		String soDienThoai = request.getParameter("sodienthoai");
		String email = request.getParameter("email");
		// Lưu dữ liệu
		request.setAttribute("tenDangNhap", tenDangNhap);
		// request.setAttribute("matkhau", matkhau);
//			 request.setAttribute("nhacLaiMatKhau", nhacLaiMatKhau);   ///2 cái này k nên lưu vì sẽ lộ thông tin người dùng
		request.setAttribute("hoVaTen", hoVaTen);
		request.setAttribute("gioiTinh", gioiTinh);
		request.setAttribute("ngaySinh", ngaySinh);
		request.setAttribute("diaChi", diaChi);
		request.setAttribute("diaChiMuaHang", diaChiMuaHang);
		request.setAttribute("soDienThoai", soDienThoai);
		request.setAttribute("email", email);
		// khai báo
		String url = "";
		String baoLoi = "";
		// Xử lí tên đăng nhập
		ClientDAO clientDAO = new ClientDAO();
		Client client = new Client();
		client.setUserName(tenDangNhap);
		// System.out.println(baoLoi.length());
		boolean check = clientDAO.kiemTraTenDangNhap(tenDangNhap);
		System.out.println("check="+check);
		if (check == true) {
			baoLoi += "Tên đăng nhập đã tồn tại<br>";
		}
		if (tenDangNhap.length() < 7) {
			baoLoi += "Tên đăng nhập phải lớn hơn 6 kí tự<br>";
		}
		// Xử lí mật khẩu
		if (matkhau.equals(nhapLaiMatKhau) == false) {
			baoLoi += "Mật khẩu đã nhập không trùng khớp!<br>";
		}
		if (matkhau.length() < 8) {
			baoLoi += "Mật khẩu phải có độ dài lớn hơn 8<br>";
		}
		int demSo = 0;
		int demChuThuong = 0;
		int demChuHoa = 0;
		int demKiTuDacBiet = 0;
		for (int i = 0; i < matkhau.length(); i++) {
			if (matkhau.charAt(i) > '0' && matkhau.charAt(i) <= '9') {
				demSo++;
			} else if (matkhau.charAt(i) > 'a' && matkhau.charAt(i) <= 'z') {
				demChuThuong++;
			} else if (matkhau.charAt(i) > 'A' && matkhau.charAt(i) <= 'Z') {
				demChuHoa++;
			} else {
				demKiTuDacBiet++;
			}
		}
		if (demSo == 0) {
			baoLoi += "Mật khẩu phải chứa ít nhất 1 số.<br>";
		}
		if (demChuThuong == 0) {
			baoLoi += "Mật khẩu phải chứa ít nhất 1 kí tự thường.<br>";
		}
		if (demChuHoa == 0) {
			baoLoi += "Mật khẩu phải chứa ít nhất 1 kí tự viết hoa.<br>";
		}
		if (demKiTuDacBiet == 0) {
			baoLoi += "Mật khẩu phải chứa ít nhất 1 kí tự đặc biệt.<br>";
		}
		// Duyệt lỗi
		if (baoLoi.length() > 0) {
			url = "/khachhang/dangKy.jsp";
			request.setAttribute("baoLoi", baoLoi);
		} else {
			// Mã hóa mật khẩu
			MaHoa mh = new MaHoa();
			matkhau = mh.toSHA1(matkhau);
			// Tạo session lấy mã ID random và lưu client
//			HttpSession session = request.getSession();
//			String maKhachHang = session.getId();
			int maKhachHang = 1;
			while(true) {
				Client cli = new Client();
				cli.setClientCode(maKhachHang+"");
				Client cl = clientDAO.selectById(cli); 
				if(cl == null) {
					break;
				}
				maKhachHang++;
			}
			Date d = Date.valueOf(ngaySinh);
//			d.setMonth(d.getMonth() - 1);
//			d.setYear(d.getYear() - 1900);
			Client cli = new Client(maKhachHang+"", tenDangNhap, matkhau, hoVaTen, gioiTinh, diaChi, diaChiMuaHang, d,
					soDienThoai, email);
			ClientDAO dao = new ClientDAO();
//			System.out.println(dao);
			int k = dao.insert(cli);
			System.out.println("Cập nhật thêm " + k+" khách hàng!");
			if (k <= 0) {
				baoLoi += "Quá trình thêm data bị lỗi!<br>";
				url = "/khachhang/dangKy.jsp";
				request.setAttribute("baoLoi", baoLoi);
			} else {
				// Mã xác thực
				String soNgauNhien = SoNgauNhien.soNgauNhien();
				// request.setAttribute("maxacthuc", soNgauNhien);
				// soNgauNhien = MaHoa.toSHA1(soNgauNhien);
				// Thời gian hiệu lực của mã xác thực
				Date todaysDate = new Date(new java.util.Date().getTime());
				Calendar c = Calendar.getInstance();
				c.setTime(todaysDate);
				c.add(Calendar.DATE, 1);
				Date thoiGianHieuLucXacThuc = new Date(c.getTimeInMillis());
				// Trạng thái xác thực = false
				boolean trangThaiXacThuc = false;
				// Update lại data
				cli.setVerificationCodes(soNgauNhien);
				cli.setTimeOfSpecify(thoiGianHieuLucXacThuc);
				cli.setAuthenticationStatus(trangThaiXacThuc);
				int res = dao.updateVerifyInformation(cli);
				System.out.println("cập nhật " + res);
				if (res > 0) {
					System.out.println(GuiEmail.guiEmail(cli.getEmailAddress(), "Xác thực tài khoản tại web.nhóc_dev",
							getNoiDung(cli)));
					HttpSession session1 = request.getSession();
					session1.setAttribute("khachhangmoidangky", cli);
				}
				url = "/khachhang/xacThucTaiKhoan.jsp";
			}

		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void thayDoiThongTin(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String hoTen = request.getParameter("hoten");
		String gioiTinh = request.getParameter("gioitinh");
		String diaChi = request.getParameter("diachi");
		String diaChiMuaHang = request.getParameter("diachimuahang");
		String ngaySinh = request.getParameter("birthday");
		String soDT = request.getParameter("phone");
		String url = "/khachhang/thayDoiThongTin.jsp";
		String baoLoi = "";
		String thanhCong = "";
		// Set up database
		ClientDAO dao = new ClientDAO();
		Client cl = null;
		// lấy khách hàng từ session
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("khachHang");
		cl = (Client) obj;
		if (cl != null) {
			cl.setFullName(hoTen);
			cl.setSex(gioiTinh);
			cl.setAddress(diaChi);
			cl.setReceiverAddress(diaChiMuaHang);
			cl.setPhoneNumber(soDT);
			int k = dao.updateThongTinKhachHang(cl);
			System.out.println("cập nhật " + k);
			if (k != 0) {
				thanhCong = "Bạn đã cập nhật thông tin thành công!!!";
			} else {
				baoLoi = "Cập nhật không thành công";
			}
		}
		request.setAttribute("baoLoiThayDoiin4", baoLoi);
		request.setAttribute("thanhCong", thanhCong);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doiMatKhau(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String matKhauCu = request.getParameter("matKhauCu");
		String matKhauMoi = request.getParameter("matKhauMoi");
		String nhapLaiMatKhau = request.getParameter("nhapLaiMatKhau");
		MaHoa maHoa = new MaHoa();
		String matKhauCu_shal = maHoa.toSHA1(matKhauCu);
		// set-up username
		System.out.println(matKhauCu);
		System.out.println(matKhauCu_shal);
		// Lấy data khách hàng
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("khachHang");
		Client khachHang = null;
		String baoLoi = "";
		if (obj != null)
			khachHang = (Client) obj;
		System.out.println(khachHang.getPassword());
		if (khachHang.getPassword().equals(matKhauCu_shal) == false) {
			baoLoi += "Mật khẩu hiện tại không chính xác<br>";
		}
		if (matKhauCu.equals(khachHang.getPassword()) == true) {
			baoLoi += "Mật khẩu mới phải khác mật khẩu cũ<br>";
		}
		if (matKhauMoi.equals(nhapLaiMatKhau) == false) {
			baoLoi += "Mật khẩu mới không trùng khớp!<br>";
		}
		if (matKhauMoi.length() < 8) {
			baoLoi += "Mật khẩu phải có độ dài lớn hơn 8<br>";
		}
		int demSo = 0;
		int demChuThuong = 0;
		int demChuHoa = 0;
		int demKiTuDacBiet = 0;
		for (int i = 0; i < matKhauMoi.length(); i++) {
			if (matKhauMoi.charAt(i) > '0' && matKhauMoi.charAt(i) <= '9') {
				demSo++;
			} else if (matKhauMoi.charAt(i) > 'a' && matKhauMoi.charAt(i) <= 'z') {
				demChuThuong++;
			} else if (matKhauMoi.charAt(i) > 'A' && matKhauMoi.charAt(i) <= 'Z') {
				demChuHoa++;
			} else {
				demKiTuDacBiet++;
			}
		}
		if (demSo == 0) {
			baoLoi += "Mật khẩu mới phải chứa ít nhất 1 số.<br>";
		}
		if (demChuThuong == 0) {
			baoLoi += "Mật khẩu mới phải chứa ít nhất 1 kí tự thường.<br>";
		}
		if (demChuHoa == 0) {
			baoLoi += "Mật khẩu mới phải chứa ít nhất 1 kí tự viết hoa.<br>";
		}
		if (demKiTuDacBiet == 0) {
			baoLoi += "Mật khẩu mới phải chứa ít nhất 1 kí tự đặc biệt.<br>";
		}
		String url = "";
		if (baoLoi.length() > 0) {
			url = "/khachhang/doiMatKhau.jsp";
			request.setAttribute("baoLoiMK", baoLoi);
		} else {
			ClientDAO dao = new ClientDAO();
			matKhauMoi = maHoa.toSHA1(matKhauMoi);
			int res = dao.updateMatKhau(matKhauMoi, khachHang.getUserName());
			url = "/khachhang/doiMKThanhCong.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void capNhatMK(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String matKhauMoi = request.getParameter("matKhauMoi");
		//String nhapLaiMatKhau = request.getParameter("nhapLaiMatKhau");
		MaHoa maHoa = new MaHoa();
		String matKhauMoi_shal = maHoa.toSHA1(matKhauMoi);
		// Lấy data khách hàng
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("tenkhachhang");
		Client khachHang = null;
		String baoLoi = "";
		if (obj != null)
			khachHang = (Client) obj;
		System.out.println(khachHang.getPassword());
		System.out.println(matKhauMoi_shal);
		//System.out.println(matKhauMoi);
		if (khachHang.getPassword().equals(matKhauMoi_shal) == true) {
			baoLoi += "Mật khẩu mới không được trùng mật khẩu cũ<br>";
		}
		if (matKhauMoi.length() < 8) {
			baoLoi += "Mật khẩu phải có độ dài lớn hơn 8<br>";
		}
		int demSo = 0;
		int demChuThuong = 0;
		int demChuHoa = 0;
		int demKiTuDacBiet = 0;
		for (int i = 0; i < matKhauMoi.length(); i++) {
			if (matKhauMoi.charAt(i) > '0' && matKhauMoi.charAt(i) <= '9') {
				demSo++;
			} else if (matKhauMoi.charAt(i) > 'a' && matKhauMoi.charAt(i) <= 'z') {
				demChuThuong++;
			} else if (matKhauMoi.charAt(i) > 'A' && matKhauMoi.charAt(i) <= 'Z') {
				demChuHoa++;
			} else {
				demKiTuDacBiet++;
			}
		}
		if (demSo == 0) {
			baoLoi += "Mật khẩu mới phải chứa ít nhất 1 số.<br>";
		}
		if (demChuThuong == 0) {
			baoLoi += "Mật khẩu mới phải chứa ít nhất 1 kí tự thường.<br>";
		}
		if (demChuHoa == 0) {
			baoLoi += "Mật khẩu mới phải chứa ít nhất 1 kí tự viết hoa.<br>";
		}
		if (demKiTuDacBiet == 0) {
			baoLoi += "Mật khẩu mới phải chứa ít nhất 1 kí tự đặc biệt.<br>";
		}
		String url = "";
		if (baoLoi.length() > 0) {
			url = "/khachhang/updateMK.jsp";
			request.setAttribute("baoLoiMK", baoLoi);
		} else {
			ClientDAO dao = new ClientDAO();
			matKhauMoi = maHoa.toSHA1(matKhauMoi);
			int res = dao.updateMatKhau(matKhauMoi, khachHang.getUserName());
			url = "/khachhang/doiMKThanhCong.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String getNoiDung(Client kh) {
		String link = "http://localhost:8080/PersonalPerson/khach-hang-controller?hanhdong=xac-thuc&maxacnhan="
				+ kh.getVerificationCodes();
		String noiDung = "<p>Nhóc_dev xin ch&agrave;o bạn <strong>" + kh.getFullName() + "</strong>,</p>\r\n"
				+ "<p>Vui l&ograve;ng x&aacute;c thực t&agrave;i khoản của bạn bằng c&aacute;ch nhập m&atilde; <strong>"
				+ kh.getVerificationCodes() + "</strong>, hoặc click trực tiếp v&agrave;o đường link sau đ&acirc;y:</p>\r\n"
				+ "<p><a href=\"" + link + "\">" + link + "</a></p>\r\n"
				+ "<p>Lưu ý mã xác thực chỉ có thời hạn đến hết " + kh.getTimeOfSpecify() + "</p>\r\n"
				+ "<p>Đ&acirc;y l&agrave; email tự động, vui l&ograve;ng kh&ocirc;ng phản hồi email n&agrave;y.</p>\r\n"
				+ "<p>Tr&acirc;n trọng cảm ơn.</p>";
		return noiDung;
	}
//	public static String getNoiDungTenDN(Client kh) {
//		String link = "http://localhost:8080/Myproject/khach-hang-controller?hanhdong=xac-thuc-layMK&maxacnhan="
//				+ kh.getVerificationCodes();
//		String maCode = SoNgauNhien.soNgauNhien();
//		String noiDung = "<p>Nhóc_dev xin ch&agrave;o bạn <strong>" + kh.getFullName() + "</strong>,</p>\r\n"
//				+ "<p>Vui l&ograve;ng x&aacute;c thực t&agrave;i khoản của bạn bằng c&aacute;ch nhập m&atilde; <strong>"
//				+ maCode + "</strong>, hoặc click trực tiếp v&agrave;o đường link sau đ&acirc;y:</p>\r\n"
//				+ "<p><a href=\"" + link + "\">" + link + "</a></p>\r\n"
//				+ "<p>Lưu ý mã xác thực chỉ có thời hạn đến hết " + kh.getTimeOfSpecify() + "</p>\r\n"
//				+ "<p>Đ&acirc;y l&agrave; email tự động, vui l&ograve;ng kh&ocirc;ng phản hồi email n&agrave;y.</p>\r\n"
//				+ "<p>Tr&acirc;n trọng cảm ơn.</p>";
//		
//		return noiDung;
//	}
	

}
