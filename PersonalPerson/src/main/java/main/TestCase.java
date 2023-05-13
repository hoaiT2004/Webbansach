package main;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import database.AuthorDAO;
import database.BookDAO;
import database.CategoryDAO;
import database.ClientDAO;
import database.ConnectHib;
//import database.OrderDAO;
//import database.OrderDetailsDAO;
import model.Author;
import model.Book;
import model.Category;
import model.Client;
import model.Order;
import model.OrderDetails;

public class TestCase {
public static void main(String[] args) {
	
//	try {
//		SessionFactory sessionFactory = ConnectHib.getSessionFactory();
//		if(sessionFactory != null) {
//			Session session = sessionFactory.openSession();
//		try {
//			Transaction transaction = session.beginTransaction();
//			
//			Date d = new Date(2004-1900, 5-1, 24);
//			Author auth = new Author("1", "Nguyễn Xuân Hòa", "Nam", d, "Là 1 chàng trai ok");
//			
//			BookDAO bookDAO = new BookDAO();
//			Book book = new Book("b100", "java", auth, 2020, 50000, 100,null,"tiếng việt", "Sách cho coder");
//			Book book2 = new Book("b2", "C", auth, 2020, 50000, 100,null,"tiếng việt", "Sách cho coder");
//			Book book3 = new Book("b3", "C++", auth, 2020, 50000, 100,null,"tiếng việt", "Sách cho coder");
//			book.setAuth(auth);
//			book3.setAuth(auth);
//			
//			Set<Book> libook = new HashSet<>();
//			libook.add(book);
//			libook.add(book2);
//			libook.add(book3);
//			auth.setBook(libook);
//			
//			
//			Order order = new Order("o1", null,"lại thượng","lại thượng", "đang giao hàng", "tiền mặt", "chưa thanh toán", 0, 50000);
//			Order order2 = new Order("o2", null,"lại thượng","lại thượng", "đang xác thực", "ngân hàng", "đã thanh toán", 0, 50000);
//			Order order3 = new Order("o3", null,"lại thượng","lại thượng", "đang giao hàng", "tiền mặt", "đã thanh toán", 0, 50000);
//			Set<Order> liorder = new HashSet<>();
//			
//			
//			liorder.add(order);
//			liorder.add(order2);
//			liorder.add(order3);
//			
//			CategoryDAO categoryDAO = new CategoryDAO();
//			Category cate1 = new Category("cate1", "sách");
//			book.setCate(cate1);
//			book2.setCate(cate1);
//			book3.setCate(cate1);
//			cate1.setBook(libook);
//			
//			ClientDAO clientDAO = new ClientDAO();
//			Client cl1 = new Client("cl1", "checkthu", "12345678", "nguyễn AN", "nam", "lt", "lt", d, "0343199493", "nguyen@gmail.com");
//			Client cl2 = new Client("cl2", "checkthu", "12345678", "nguyễn AN", "nam", "lt", "lt", d, "0343199493", "nguyen@gmail.com");
//			Client cl3 = new Client("cl3", "checkthu", "12345678", "nguyễn AN", "nam", "lt", "lt", d, "0343199493", "nguyen@gmail.com");
//			Set<Client> liclient1 = new HashSet<>();
//			liclient1.add(cl1);
//			liclient1.add(cl2);
//			Set<Client> liclient2 = new HashSet<>();
//			liclient2.add(cl2);
//			liclient2.add(cl3);
//			order.setClient(liclient1);
//			order2.setClient(liclient2);
//			cl1.setOrd(liorder);
//			cl3.setOrd(liorder);
//			
//			//OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAO();
//			OrderDetails details1 = new OrderDetails("đơn 1", 2, 50000,0 , 50000, 0, 50000);
//			details1.setOrder(liorder);
//			order.setOrderDetails(details1);
//			order2.setOrderDetails(details1);
//			
//			//session.save(auth);
//			session.save(book);
////			session.save(book2);
////			session.save(book3);
//			//session.save(cate1);
////			session.save(cl1);
////			session.save(cl2);
////			session.save(cl3);
//			//session.save(details1);
////			session.save(order);
////			session.save(order2);
////			session.save(order3);
//			transaction.commit();
//			session.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//		ConnectHib.shutdown();
//		}
//		}
//		} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
}
}
