package basics.maven.hiber.DeepaHibernate.week4.sunday;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLWithParamters 
{
	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Parameters demo");
		
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Session session=factory.openSession();
		session.beginTransaction();
		
		Query qry=null;List mat=null;
		
		qry=session.createQuery("from Sofa where price between :start and :end");
		qry.setParameter("start", scan.nextInt());
		qry.setParameter("end", scan.nextInt());
		mat=(List<Sofa>)qry.list();
		System.out.println(mat);
		
		session.getTransaction().commit();
		session.close();
		
		factory.close();
	}
}
