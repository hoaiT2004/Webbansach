package database;
	import org.hibernate.SessionFactory;
	import org.hibernate.cfg.Configuration;
	public class ConnectHib {
		private static final SessionFactory sessionFactory = buildSessionFactory();
		private static SessionFactory buildSessionFactory() {
			try {
				return new Configuration().configure().buildSessionFactory();
			} catch (Exception e) {
				e.printStackTrace();
				e.getMessage();
				return null;
			}
		}
		
		public static SessionFactory getSessionFactory() {
			return sessionFactory;
		}
		
		public static void shutdown() {
			getSessionFactory().close();
		}
	}
