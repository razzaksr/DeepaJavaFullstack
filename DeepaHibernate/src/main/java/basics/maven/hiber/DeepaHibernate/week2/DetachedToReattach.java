package basics.maven.hiber.DeepaHibernate.week2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DetachedToReattach 
{
	public static void main(String[] args) 
	{
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
    	System.out.println(factory.isOpen());
    	
    	Session session=factory.openSession();
    	session.beginTransaction();
    	
    	Resource res1=new Resource(10,"Mahes", "Python,Java", 1);// transient
    	//System.out.println(session.save(res1));//persist
    	
    	//res1.setExperience(11);//persist
    	
    	session.getTransaction().commit();
    	res1.setExperience(0);//detached
    	session.close();
    	
    	session=factory.openSession();
    	session.beginTransaction();
    	
    	session.merge(res1);// when merge called detached object changes will be updated>> reattach
    	
    	res1.setExperience(4);
    	
    	session.merge(res1);
    	
    	session.getTransaction().commit();
    	session.close();
    	
    	factory.close();
	}
}
