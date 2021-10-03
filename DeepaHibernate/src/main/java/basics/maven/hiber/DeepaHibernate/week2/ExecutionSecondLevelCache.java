package basics.maven.hiber.DeepaHibernate.week2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ExecutionSecondLevelCache 
{
	public static void main(String[] args) 
	{
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
    	System.out.println(factory.isOpen());
    	
    	Session session=factory.openSession();
    	session.beginTransaction();
    	
    	System.out.println(session.createQuery("from Resource").list());
    	
    	session.getTransaction().commit();
    	session.close();
    	
    	
    	session=factory.openSession();
    	session.beginTransaction();
    	
    	System.out.println(session.createQuery("from Resource").list());
    	
    	session.getTransaction().commit();
    	session.close();
    	
    	factory.close();
	}
}
