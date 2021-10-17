package basics.maven.hiber.DeepaHibernate.week4.sunday;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class SofaHQL 
{
	public static void main(String[] args) 
	{
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Session session=factory.openSession();
		session.beginTransaction();
		
		Query qry=session.createQuery("from Sofa");
		//qry.setFirstResult(4);
		qry.setMaxResults(4);
		
		List<Sofa> all =(List<Sofa>) qry.list();
		System.out.println(all);
		
		
		qry=session.createQuery("select material from Sofa");
		List<String> mat=(List<String>)qry.list();
		System.out.println(mat);
		
		qry=session.createQuery("select size from Sofa where price between 10000 and 15000");
		mat=(List<String>)qry.list();
		System.out.println(mat);
		
		session.getTransaction().commit();
		session.close();
		
		factory.close();
	}
}
