package basics.maven.hiber.DeepaHibernate.week4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DemoOneToOne 
{
	public static void main(String[] args) 
	{
		SessionFactory fact=new Configuration().configure().buildSessionFactory();
		Session session=fact.openSession();
		session.beginTransaction();
		
		//Product pro=new Product("IRCTC", "Java", "Railway department");
		
		//ResourcePerson person=new ResourcePerson("Razak Mohamed", "Java,JavaScript", pro);
		
		//session.save(person);
		//session.save(pro);
		
		session.getTransaction().commit();
		session.close();
		fact.close();
	}
}
