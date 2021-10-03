package basics.maven.hiber.DeepaHibernate.week2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Scopes 
{
	public static void main(String[] args) 
	{
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
    	System.out.println(factory.isOpen());
    	
    	Session session=factory.openSession();
    	session.beginTransaction();
    	
    	Resource res1=new Resource("Mahes", "Python,Java", 15);// transient
    	System.out.println(session.save(res1));//persist
    	
    	res1.setExperience(11);//persist
    	
    	session.getTransaction().commit();
    	res1.setExperience(5);//detached
    	session.close();
    	
    	factory.close();
	}
}
