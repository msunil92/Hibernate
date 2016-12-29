package CRUD.Operations;


import java.util.ArrayList;
import java.util.Collection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TeamApp {
	public static void main(String[] args) {
		TeamApp.update(1);
	}
	
	public static void create() {
		SessionFactory factory = new Configuration().configure("CRUD.cfg.xml").buildSessionFactory();
		Session session = null;
		try{
			Team team = new Team();
			team.setName("India");
			
			Collection<Player> players = new ArrayList();
			for (int i=1;i<10;i++){
				Player p = new Player();
				p.setAge(i);
				p.setName("Sunil" +i);
				p.setSkill("SKILL" + i);
				players.add(p);
				p=null;
			}
			
			team.setPlayers(players);
			
			
			session = factory.openSession();
			session.beginTransaction();
			session.persist(team);
			session.getTransaction().commit();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	public static void delete() {
		SessionFactory factory = new Configuration().configure("CRUD.cfg.xml").buildSessionFactory();
		Session session = null;
		try{
			Team team = new Team();
			
			session = factory.openSession();
			session.beginTransaction();
			team = (Team) session.get(Team.class, 1);
			session.delete(team);
			session.getTransaction().commit();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	public static void update(int x) {
		SessionFactory factory = new Configuration().configure("CRUD.cfg.xml").buildSessionFactory();
		Session session = null;
		try{
			Team team = new Team();
			
			session = factory.openSession();
			session.beginTransaction();
			team = (Team) session.get(Team.class, x);
			team.setName("updated name");
			session.update(team);
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
