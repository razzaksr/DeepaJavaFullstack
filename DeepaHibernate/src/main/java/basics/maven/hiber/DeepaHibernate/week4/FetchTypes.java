package basics.maven.hiber.DeepaHibernate.week4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchTypes 
{
	public static void main(String[] args) 
	{
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		
		Furniture f =(Furniture) s.get(Furniture.class, 1);
		
		System.out.println(f.getFq().size());
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		
		System.out.println(f.getFq().size());
	}
}
