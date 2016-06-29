package hibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateSessionFactory {

	static SessionFactory sessionFactory = null;

	public CreateSessionFactory() {
		Configuration c = new Configuration().configure("/hibernate.cfg.xml");
		sessionFactory = c.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory != null) {
			return sessionFactory;
		} else {
			Configuration c = new Configuration()
					.configure("/hibernate.cfg.xml");
			sessionFactory = c.buildSessionFactory();

		}
		return sessionFactory;
	}

	/*private static final SessionFactory sessionFactory;
	static {
		try {
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}*/

}
