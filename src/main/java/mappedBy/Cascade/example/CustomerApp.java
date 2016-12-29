package mappedBy.Cascade.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CustomerApp {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("mappedBy.cfg.xml").buildSessionFactory();
		
		Customer c = new Customer();
		c.setName("Sunil");
		c.setPlaceName("Bangalore");
		
		Vehicle v = new Vehicle();
		v.setName("Car");
		
		Vehicle v1 = new Vehicle();
		v1.setName("Car-Jeep");
		
		c.getVehicle().add(v1);
		c.getVehicle().add(v);
		
		v.setLsOfCustomer(c);
		v1.setLsOfCustomer(c);
		
		
		Session session = factory.openSession();
		session.beginTransaction();
		session.persist(c);
		session.save(v);
		session.save(v1);
		
		session.getTransaction().commit();
	}
}
