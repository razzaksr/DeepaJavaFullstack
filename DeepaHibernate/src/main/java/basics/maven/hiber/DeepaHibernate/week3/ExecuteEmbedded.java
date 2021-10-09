package basics.maven.hiber.DeepaHibernate.week3;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ExecuteEmbedded 
{
	public static void main(String[] args) 
	{
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
    	
    	Session session=factory.openSession();
    	session.beginTransaction();
    	
    	Stuffs stuffs=new Stuffs("apple,cherry,banana", 2, "heat");
    	Stuffs stuffss=new Stuffs("Grape,Guva,Peanut,Dates", 5, "Freeze");
    	Goods goods=new Goods("Jam", "Kissan", new Date("3/12/2020"), 20, 35, stuffs);
    	goods.setStuffing(stuffss);
    	session.save(goods);
    	
    	session.getTransaction().commit();
    	session.close();
	}
}
