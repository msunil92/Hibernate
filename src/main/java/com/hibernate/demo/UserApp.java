package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserApp {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = null;
		try{
			User user = new User("Sunil");
			session = factory.openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			user=null;
			user = (User)session.get(User.class, 1);
			System.out.println(user.getName());
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		finally {
			session.close();
		}
	}
}
