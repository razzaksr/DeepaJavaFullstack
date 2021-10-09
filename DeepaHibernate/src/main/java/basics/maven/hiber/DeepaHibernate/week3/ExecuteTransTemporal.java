package basics.maven.hiber.DeepaHibernate.week3;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ExecuteTransTemporal 
{
	public static void main(String[] args) 
	{
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
    	
    	Session session=factory.openSession();
    	session.beginTransaction();
    	
    	//Product product=new Product("OTG16", "Transcend", new Date("3/30/2021"), 34, 430);
    	Product product=new Product();
    	product.setBrand("HP");product.setManufact(new Date());product.setName("SD Card");//product.setPrice(300);
    	session.save(product);
    	
    	session.getTransaction().commit();
    	session.close();
	}
}
