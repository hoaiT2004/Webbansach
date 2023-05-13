package database;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Author;
import model.OrderDetails;

public class OrderDetailsDAO implements DAOInterface<OrderDetails>{

	@Override
	public List<OrderDetails> selectAll() {
		List<OrderDetails> data = new ArrayList<>();
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
	public OrderDetails selectById(String id) {
		OrderDetails a = null;
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					a = session.get(OrderDetails.class, id);
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
	public int insert(OrderDetails t) {
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
		OrderDetailsDAO dao = new OrderDetailsDAO();
		OrderDetails o = dao.selectById(t.getOrderDetailsCode());
		if(o != null) return 1;
		return 0;
	}


	@Override
	public int insertAll(List<OrderDetails> t) {
		int dem = 0;
		for (OrderDetails author : t) {
			dem += insert(author);
		}
		return dem;
	}

	@Override
	public int delete(OrderDetails t) {
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
	public int deleteAll(List<OrderDetails> t) {
		int dem = 0;
		for (OrderDetails author : t) {
			dem += delete(author);
		}
		return dem;
	}


	@Override
	public int update(OrderDetails t, OrderDetails t2) {
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					 session.update(t2);//thằng a để lấy id
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
	
}

}
