package basics.maven.hiber.DeepaHibernate.week5;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import basics.maven.hiber.DeepaHibernate.week4.sunday.Sofa;

public class DemoCriteria 
{
	public static void main(String[] args) 
	{
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Session session=factory.openSession();
		session.beginTransaction();
		
		
		
		session.getTransaction().commit();
		session.close();
		
		factory.close();
	}
}
