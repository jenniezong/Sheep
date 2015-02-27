package test;

import module.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestDB {

	private static SessionFactory sf;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		sf = new Configuration().configure() // configures settings from
												// hibernate.cfg.xml
				.buildSessionFactory();
		User user = new User("nan", "nan");
		addUser(user);

	}

	private static void addUser(User user) {
		Session session = sf.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();

	}
}
