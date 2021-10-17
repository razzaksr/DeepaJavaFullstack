package basics.maven.hiber.DeepaHibernate.week4;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class SecondLevelCache 
{
	public static void main(String[] args) 
	{
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		/*
		 * Course t1=new Course("Fun","CSE"); Course t2=new Course("OS","CSE"); Course
		 * t3=new Course("Python","IT"); Course t4=new Course("DSP","EEE"); Course
		 * t5=new Course("OS","ECE");
		 * s.save(t1);s.save(t2);s.save(t3);s.save(t4);s.save(t5);
		 */
		
		Course t=(Course)s.get(Course.class, 2);
		System.out.println(t);
		
		Query q1= s.createQuery("from Course");
		q1.setCacheable(true);
		
		List<Course> list= q1.getResultList();
		
		System.out.println(list.toString());
		
		s.getTransaction().commit();
		s.close();
		
		
		Session s2=sf.openSession();
		s2.beginTransaction();
		
		Course c=(Course)s2.get(Course.class, 2);
		System.out.println(c);
		
		
		Query q2= s2.createQuery("from Course");
		q2.setCacheable(true);
		
		List<Course> list1 = q2.getResultList();
		
		System.out.println(list1.toString());
		
		s2.getTransaction().commit();
		s2.close();
		
		
		sf.close();
	}
}
