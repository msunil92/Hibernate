package com.hibernate.demo.proxyobjects;


import java.util.ArrayList;
import java.util.Collection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentApp {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("student.cfg.xml").buildSessionFactory();
		Session session = null;
		try{
			College college1 = new College("RV");
			College college2 = new College("NCJ");
			College college3 = new College("NCJ");
			
			Collection<College> listOfAddress1 = new ArrayList<College>();
			listOfAddress1.add(college1);
			listOfAddress1.add(college2);
			Student s1 = new Student("Sunil",listOfAddress1);
			
			Collection<College> listOfAddress2 = new ArrayList<College>();
			listOfAddress2.add(college1);
			listOfAddress2.add(college2);
			listOfAddress2.add(college3);
			Student s2 = new Student("Anil",listOfAddress2);
			
			session = factory.openSession();
			session.beginTransaction();
			session.save(s1);
			session.save(s2);
			session.getTransaction().commit();
			session.close();
			
			session = factory.openSession();
			session.beginTransaction();
			//session.close();
			Student studentDetails = new Student();
			studentDetails = (Student) session.get(Student.class, 2);
			System.out.println(studentDetails.getListOfColleges().size());
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//session.close();
		}
	}
}
