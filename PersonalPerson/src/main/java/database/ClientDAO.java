package database;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Date;

import model.Book;
import model.Client;
import util.MaHoa;

// ctrl + shift + s
// ctrl + shift + f
public class ClientDAO {
	public List<Client> selectAll() {
		List<Client> data = new ArrayList<Client>();
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					String hql = "from Client";
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

	public Client selectById(Client client) {
		Client d = null;

		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					d = session.get(Client.class, client.getClientCode());
					transaction.commit();
					session.close();
				} catch (Exception e) {
				//	//ConnectHib.shutdown();
					e.printStackTrace();
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}

	public int insert(Client client) {
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					session.save(client);
					transaction.commit();
					session.close();
				} catch (Exception e) {
				//	//ConnectHib.shutdown();
					e.printStackTrace();
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClientDAO dao = new ClientDAO();
		Client cl = dao.selectById(client);
		if (cl != null)
			return 1;

		return 0;
	}

	public int insertAll(List<Client> list) {
		int dem = 0;
		for (Client Client : list) {
			dem += this.insert(Client);
		}
		return dem;
	}

	public int delete(Client client) {
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					session.delete(client);

					transaction.commit();
					session.close();
					return 1;
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
		return 0;
	}

	public int deleteAll(List<Client> list) {
		int dem = 0;
		for (Client Client : list) {
			dem += this.delete(Client);
		}
		return dem;
	}

	/**
	 * @param client
	 * @return
	 */
	public int update(Client t) {
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					session.update(t);// thằng a để lấy id
					transaction.commit();
					session.close();
					return 1;
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
		return 0;
	}

	public int updateImage(Client t) {
		int kq = 0;
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					String hql = "update Client t set t.url=:url where t.userName=:user";
					// String hql = "update Cat c set c.dateofbirth =:date,c.name=:name,c.sex=:gt
					// where c.id=:id";
					Query query = session.createQuery(hql);
					query.setParameter("url", t.getUrl());
					query.setParameter("user", t.getUserName());
					kq = query.executeUpdate();
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
		return kq;
	}

	public int updateVerifyInformation(Client client) {
		int kq = 0;
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					String hql = "update Client t set t.verificationCodes=:verificationCodes,t.TimeOfSpecify=:TimeOfSpecify,t.authenticationStatus=:authenticationStatus where t.userName=:userName";
					Query query = session.createQuery(hql);
					query.setParameter("verificationCodes", client.getVerificationCodes());
					query.setParameter("TimeOfSpecify", client.getTimeOfSpecify());
					query.setParameter("authenticationStatus", client.isAuthenticationStatus());
					query.setParameter("userName", client.getUserName());
					kq = query.executeUpdate();
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
		return kq;
	}

	public int updateThongTinKhachHang(Client client) {
		int kq = 0;
		// String sql = "UPDATE khachhang" + " SET " +
		// "hoten=?,gioitinh=?,diachi=?,diachimuahang=?,sodienthoai=?,email=? WHERE
		// tendangnhap=?;";
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					String hql = "update Client t set t.fullName=:fullName,t.sex=:sex,t.address=:address,t.receiverAddress=:receiverAddress,t.phoneNumber =:phoneNumber,t.emailAddress=:emailAddress where t.userName=:userName";
					Query query = session.createQuery(hql);
					query.setParameter("fullName", client.getFullName());
					query.setParameter("sex", client.getSex());
					query.setParameter("address", client.getAddress());
					query.setParameter("receiverAddress", client.getReceiverAddress());
					query.setParameter("phoneNumber", client.getPhoneNumber());
					query.setParameter("emailAddress", client.getEmailAddress());
					query.setParameter("userName", client.getUserName());
					kq += query.executeUpdate();
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
		return kq;
	}

	public boolean kiemTraTenDangNhap(String tenDangNhap) {
		Client cl = null;
		// String sql = "SELECT * FROM khachhang WHERE tendangnhap=?;";
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					String hql = "from Client c where c.userName=:user";
					Query query = session.createQuery(hql);
					query.setParameter("user", tenDangNhap);
					Object obj = query.getSingleResult();
					cl= (Client)obj;
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
			System.out.println("đas");
			e.printStackTrace();
		}
		if(cl != null) return true;
		return false;
	}

	public boolean kiemTraMatKhau(String matKhau) {
		Client cl = null;
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					String hql = "from Client c where c.password=:password";
					Query query = session.createQuery(hql);
					query.setParameter("password", matKhau);
					Object obj = query.getSingleResult();
					cl = (Client) obj;
					transaction.commit();
					session.close();
				} catch (Exception e) {
//					//ConnectHib.shutdown();
					e.printStackTrace();
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (cl != null) {
			return true;
		}
		return false;
	}

	public Client kiemTraMatKhauVaTenDangNhap(Client client) {
		Client cl = null;
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					String hql = "from Client c where c.password=:pass AND c.userName =:user";
					Query query = session.createQuery(hql);
					query.setParameter("pass", client.getPassword());
					query.setParameter("user", client.getUserName());
					Object obj = query.getSingleResult();
					cl = (Client) obj;
					transaction.commit();
					session.close();
				} catch (Exception e) {
					////ConnectHib.shutdown();
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cl != null)	System.out.println("ok");
		return cl;
	}

	public int updateMatKhau(String matKhauMoi, String username) {

		int kq = 0;
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					String hql = "update Client c set c.password=:password where c.userName =:username";
					Query query = session.createQuery(hql);
					query.setParameter("password", matKhauMoi);
					query.setParameter("username", username);
					kq = query.executeUpdate();
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
		return kq;
	}
	public Client LayTaiKhoanTuTenDangNhap(String tenDangNhap) {
		Client cl = null;
		// String sql = "SELECT * FROM khachhang WHERE tendangnhap=?;";
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					String hql = "from Client c where c.userName=:user";
					Query query = session.createQuery(hql);
					query.setParameter("user", tenDangNhap);
					Object obj = query.getSingleResult();
					cl= (Client)obj;
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
			System.out.println("đas");
			e.printStackTrace();
		}
		return cl;
	}
	public static void main(String[] args) {
		ClientDAO dao = new ClientDAO();
//		ArrayList<Client> data = dao.selectAll();
//		for (Client client : data) {
//			System.out.println(client);
//		}
//		Client client = new Client();
//client.setClientCode("KH9");
//Client result = dao.selectById(client);
//System.out.println(result);
//		Date d = new Date(2004 - 1900, 5 - 1, 24);// Vì năm cộng 1900,tháng cộng 1
//		Client newClient = new Client();
//		newClient.setFullName("hòa");
//		newClient.setSex("Nam");
//		newClient.setAddress("lt");
//		newClient.setReceiverAddress("lt");
//		newClient.setUserName("nhóc_dev3");
//		newClient.setPhoneNumber("034319943");
//		System.out.println(dao.updateThongTinKhachHang(newClient));
//	System.out.println(dao.insert(newClient));
		// System.out.println(dao.kiemTraTenDangNhap("hoa"));
		// System.out.println(dao.kiemTraTenDangNhap("hoaptit"));
//		String mk = "Trumhoahoc2@";
//		MaHoa mh = new MaHoa();
//		mk = mh.toSHA1(mk);
//		System.out.println(dao.kiemTraMatKhau(mk));
//		client.setUserName("admin123");
//		String mk = "Hieu26072004@";
//		mk = MaHoa.toSHA1(mk);
//		System.out.println(mk);
//		client.setPassword(mk);
//		Client c = dao.kiemTraMatKhauVaTenDangNhap(client);
//		newClient.setPassword(MaHoa.toSHA1(newClient.getPassword()));
//		System.out.println(dao.insert(newClient));
		Client cl = new Client();
	cl.setUserName("nhóc_dev3");
		String mk  ="Trumhoahoc2@";
		mk = MaHoa.toSHA1(mk);
		cl.setPassword(mk);
	//System.out.println(dao.kiemTraTenDangNhap("nhóc_dev3"));
		Client cli = dao.kiemTraMatKhauVaTenDangNhap(cl);
		System.out.println(cli);
//	System.out.println(dao.kiemTraMatKhau(cl.getPassword()));
//		String mk  ="Trumhoahoc2@";
//		mk = MaHoa.toSHA1(mk);
		//System.out.println(dao.updateMatKhau(mk, "nhóc_dev3"));
		System.out.println("----");
		
		
	}
}