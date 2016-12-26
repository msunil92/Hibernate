package com.hibernate.demo.UserDetails;


import java.util.ArrayList;
import java.util.Collection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserApp {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("user.cfg.xml").buildSessionFactory();
		Session session = null;
		try{
			Address add1 = new Address("K.K Layout","Bangalore","560072");
			Address add2 = new Address("K.K Layout","Mangalore","560072");
			
			Collection<Address> listOfAddress1 = new ArrayList<Address>();
			listOfAddress1.add(add1);
			listOfAddress1.add(add2);
			User user1 = new User("Sunil",listOfAddress1);
			
			Collection<Address> listOfAddress2 = new ArrayList<Address>();
			listOfAddress2.add(add1);
			listOfAddress2.add(add2);
			User user2 = new User("Anil",listOfAddress2);
			
			session = factory.openSession();
			session.beginTransaction();
			session.save(user1);
			session.save(user2);
			session.getTransaction().commit();
			
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		finally {
			session.close();
		}
	}
}
