package basics.maven.hiber.DeepaHibernate.week3;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ExecuteCollections 
{
	public static void main(String[] args) 
	{
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
    	
    	Session session=factory.openSession();
    	session.beginTransaction();
    	
    	Stuffs stuffs=new Stuffs("apple,cherry,banana", 2, "heat");
    	Stuffs stuffss=new Stuffs("Grape,Guva,Peanut,Dates", 5, "Freeze");
    	
    	Stocks goods=new Stocks("Jam", "Kissan", new Date("3/12/2020"), 20, 35);
    	goods.getMany().add(stuffss);goods.getMany().add(stuffs);
    	session.save(goods);
    	
    	session.getTransaction().commit();
    	session.close();
	}
}
