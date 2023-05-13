package database;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import model.Author;

public class AuthorDAO {
	List<Author> data = new ArrayList<>();

	public List<Author> selectAll() {
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					String hql = "from Author";
					data = session.createQuery(hql).getResultList();
					transaction.commit();
					session.close();
				} catch (Exception e) {
					////ConnectHib.shutdown();
					e.printStackTrace();
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	public Author selectById(Author t) {
		Author a = null;
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					a = session.get(Author.class, t.getAuthorCode());
					transaction.commit();
					session.close();
				} catch (Exception e) {
					////ConnectHib.shutdown();
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	public int insert(Author a) {
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					session.save(a);
					transaction.commit();
					session.close();
				} catch (Exception e) {
					////ConnectHib.shutdown();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AuthorDAO dao = new AuthorDAO();
		Author b = dao.selectById(a);
		if(b != null) {
			return 1;
		}
		return 0;
	}

	public int insertAll(List<Author> a) {
		int dem = 0;
		for (Author author : a) {
			dem += insert(author);
		}
		return dem;
	}

	public int delete(Author a) {
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					 session.delete(a);
					 
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

	public int deleteAll(List<Author> a) {
		int dem = 0;
		for (Author author : a) {
			dem += delete(author);
		}
		return dem;
	}

	public int update(Author a, Author b) {
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					 session.update(b);//thằng a để lấy id
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
		AuthorDAO dao = new AuthorDAO();
//		ArrayList<Author> data = dao.selectAll();
//		for (Author author : data) {
//			System.out.println(author);
//		}
		Date d = new Date(2004-1900, 5-1, 24);
		Author auth = new Author("1", "Nguyễn Xuân Hòa", "Nam", d, "Là 1 chàng trai ok");
		
System.out.println(dao.insert(auth));
	}
}
