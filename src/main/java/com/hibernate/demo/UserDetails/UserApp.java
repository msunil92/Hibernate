package com.hibernate.demo.UserDetails;


import java.util.Collection;
import java.util.HashSet;

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
			Collection<Address> listOfAddress = new HashSet();
			listOfAddress.add(add1);
			listOfAddress.add(add2);
			User user = new User("Sunil",listOfAddress);
			
			session = factory.openSession();
			session.beginTransaction();
			session.save(user);
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
