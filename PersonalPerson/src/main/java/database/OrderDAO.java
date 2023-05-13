package database;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Author;
import model.Order;

public class OrderDAO implements DAOInterface<Order>{
	List<Order> data = new ArrayList<>();
	@Override
	public List<Order> selectAll() {
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					String hql = "from Order";
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


	@Override
	public Order selectById(String id) {
		Order a = null;
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					a = session.get(Order.class, id);
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
		return a;
	}


	@Override
	public int insert(Order t) {
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					 session.save(t);
					transaction.commit();
					session.close();
				} catch (Exception e) {
					//ConnectHib.shutdown();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OrderDAO dao = new OrderDAO();
		Order a= dao.selectById(t.getOrderCode());
		if(a!=null) return 1;
		return 0;
	}


	@Override
	public int insertAll(List<Order> t) {
		int dem = 0;
		for (Order author : t) {
			dem += insert(author);
		}
		return dem;
	}


	@Override
	public int delete(Order t) {
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					 session.delete(t);
					 
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

	@Override
	public int deleteAll(List<Order> t) {
		int dem = 0;
		for (Order author : t) {
			dem += delete(author);
		}
		return dem;
	}

	@Override
	public int update(Order a,Order b) {
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
	OrderDAO dao = new OrderDAO();
}

}
