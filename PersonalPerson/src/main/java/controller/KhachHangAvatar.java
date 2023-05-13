package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import database.ClientDAO;
import model.Client;

/**
 * Servlet implementation class ClientThayDoiAnh
 */
@WebServlet("/khach-hang-avatar")
public class KhachHangAvatar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KhachHangAvatar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	//	System.out.println("123");
		Object obj = request.getSession().getAttribute("khachHang");
		Client Client = null;
		if (obj != null)
			Client = (Client) obj;
		System.out.println(Client);
		if (Client != null) {
			String baoLoi = "";
			try {
				String folder = getServletContext().getRealPath("khachhang/avatar");
				System.out.println("folder=" + folder);
				File file;
				int maxFileSize = 5000 * 1024;
				int maxMemSize = 5000 * 1024;

				String contentType = request.getContentType();

				if (contentType.indexOf(contentType) >= 0) {
					DiskFileItemFactory factory = new DiskFileItemFactory();

					// Quy dinh dung luong toi da cho 1 file
					factory.setSizeThreshold(maxMemSize);

					// Tao file upload
					ServletFileUpload upload = new ServletFileUpload(factory);

					upload.setSizeMax(maxFileSize);

					List<FileItem> files = upload.parseRequest(request);

					for (FileItem fileItem : files) {
						if (!fileItem.isFormField()) {
							String fileName = System.currentTimeMillis() + fileItem.getName();
							String path = folder + "\\" + fileName;
							file = new File(path);

							fileItem.write(file);

							Client.setUrl(fileName);
							ClientDAO ClientDAO = new ClientDAO();
							System.out.println(ClientDAO.updateImage(Client));
							Client = ClientDAO.selectById(Client);
							System.out.println(Client);
						} else {
							String name = fileItem.getFieldName();
							String value = fileItem.getString();
							System.out.println(name + " : " + value);
						}
					}
					baoLoi = "Cập nhật thành công!";
					request.setAttribute("baoLoi", baoLoi);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/khachhang/thayDoiAnh.jsp");
					rd.forward(request, response);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}