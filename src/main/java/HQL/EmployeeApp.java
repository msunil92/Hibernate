package HQL;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeApp {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("Employee.cfg.xml").buildSessionFactory();
		Session session = null;
		//EmployeeApp.create(factory);
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Employee");
		Query query1 = session.createQuery("SELECT name,age FROM Employee");
		List<Employee> empList = (List<Employee>)query.list();
		List<Object[]> objArray = (List<Object[]>)query1.list();
		Object[] singleVal = (Object[] )query1.list().get(1);
 		System.out.println(empList.size());
		session.getTransaction().commit();
		session.close();
		for (Employee emp :empList)
			System.out.println(emp.getName());
		
		for (Object[] obj:objArray){
			String name = (String) obj[0];
			Integer age = (Integer) obj[1];
			System.out.println("name is :"+name + " "+ "age is " + age);
		}
		
		System.out.println("At Last");
		System.out.println(singleVal[0]+" "+ singleVal[1]);
			
		
		
	}
	
	public static void create(SessionFactory factory) {
		Session session = null;
		session = factory.openSession();
		session.beginTransaction();
		
		
		for (int i= 0 ;i <10; i++) {
			Employee emp = new Employee();
			emp.setName("EMP" + i);
			emp.setAge(i*10);
			emp.setPlace("Place "+i);
			emp.setSkill("Skill"+i);
			session.save(emp);
			emp = null;
		}
		
		session.getTransaction().commit();
		session.close();
	}
}
