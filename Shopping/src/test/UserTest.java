package test;

import static org.junit.Assert.fail;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

	private SessionFactory sf;

	@Before
	public void setUp() throws Exception {

		sf = new Configuration().configure() // configures settings from
				// hibernate.cfg.xml
				.buildSessionFactory();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
