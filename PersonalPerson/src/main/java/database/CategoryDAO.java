package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Book;
import model.Category;

public class CategoryDAO {
	private List<Category> data = new ArrayList<Category>();

	public List<Category> selectAll() {
		List<Category> ketQua = new ArrayList<Category>();
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					String hql = "from Category";
					data = session.createQuery(hql).getResultList();
					transaction.commit();
					session.close();
				} catch (Exception e) {
					//ConnectHib.shutdown();
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public Category selectById(Category cat) {
		Category ketQua = null;
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					ketQua = session.get(Category.class, cat.getCategoryCode());
					transaction.commit();
					session.close();
				} catch (Exception e) {
					//ConnectHib.shutdown();
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	public int insert(Category category) {
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					session.save(category);
					transaction.commit();
					session.close();
				} catch (Exception e) {
					//ConnectHib.shutdown();
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CategoryDAO dao = new CategoryDAO();
		Category c = dao.selectById(category);
		if(c != null) return 1;
		return 0;
	}

	public int insertAll(List<Category> list) {
		int dem = 0;
		for (Category Category : list) {
			dem+=this.insert(Category);
		}
		return dem;
	}
	public int delete(Category category) {
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					 session.delete(category);
					 
					transaction.commit();
					session.close();
					return 1;
				} catch (Exception e) {
					//ConnectHib.shutdown();
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public int deleteAll(List<Category> arr) {
		int dem = 0;
		for (Category Category : arr) {
			dem += this.delete(Category);
		}
		return dem;
	}

	public int update(Category cate,Category cate2) {
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					 session.update(cate2);//thằng a để lấy id
					transaction.commit();
					session.close();
					return 1;
				} catch (Exception e) {
					//ConnectHib.shutdown();
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) {
//		CategoryDAO dao = new CategoryDAO();
//		ArrayList<Category> data = dao.selectAll();
//		for (Category category : data) {
//			System.out.println(category);
//		}
//		Category cat = new Category();
//		cat.setCategoryCode("KT");
//	Category c= dao.selectById(cat);
//	System.out.println(c);
	}
	
}