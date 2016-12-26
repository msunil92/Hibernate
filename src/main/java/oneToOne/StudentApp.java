package oneToOne;


import java.util.ArrayList;
import java.util.Collection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentApp {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("oneToOne.cfg.xml").buildSessionFactory();
		Session session = null;
		try{
			College college1 = new College();
			college1.setName("FHS");
			Student s1 = new Student();
			s1.setName("Raj");
			s1.setCollege(college1);
			
			
			session = factory.openSession();
			session.beginTransaction();
			session.save(s1);
			session.save(college1);
			session.getTransaction().commit();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
}
