package basics.maven.hiber.DeepaHibernate.week5;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import basics.maven.hiber.DeepaHibernate.week4.sunday.Sofa;

public class DemoNamedQuery 
{
	public static void main(String[] args) 
	{
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Session session=factory.openSession();
		session.beginTransaction();
		
		Query qry=session.getNamedQuery("getByName");
		qry.setParameter("hai", "Nilkamal");
		
		List<Sofa> list=qry.getResultList();
		
		System.out.println(list);
		
		qry=session.getNamedQuery("getByMaterial");
		
		list=qry.getResultList();
		
		System.out.println(list);
		
		session.getTransaction().commit();
		session.close();
		
		factory.close();
	}
}
