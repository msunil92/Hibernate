package oneToMany;


import java.util.ArrayList;
import java.util.Collection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentApp {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("oneToMany.cfg.xml").buildSessionFactory();
		Session session = null;
		try{
			College college1 = new College();
			college1.setName("NCJ");
			college1.setPlace("Mangalore");
			College college2 = new College();
			college2.setName("DHS");
			college2.setPlace("Bangalore");
			
			Student s1 = new Student();
			s1.setName("Sunil");
			s1.getListOfColleges().add(college1);
			s1.getListOfColleges().add(college2);
			
			
			session = factory.openSession();
			session.beginTransaction();
			session.save(s1);
			session.save(college1);
			session.save(college2);
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
