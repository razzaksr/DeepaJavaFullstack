package basics.maven.hiber.DeepaHibernate.week4.sunday;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SofaInsertion 
{
	public static void main(String[] args) 
	{
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Session session=factory.openSession();
		session.beginTransaction();
		
		Sofa s1=new Sofa("Nilkamal", "Normal", 3, 13400, "Artificial Leather");
		Sofa s2=new Sofa("Damro", "Hydrolic", 5, 43400, "Foam");
		Sofa s3=new Sofa("Victor", "Steel", 3, 9400, "Synthetic Foam");
		Sofa s4=new Sofa("Nilkamal", "Wooden", 2, 15400, "Cotton");
		Sofa s5=new Sofa("Malave", "Steel", 5, 12000, "Foam");
		Sofa s6=new Sofa("Jhonson", "Hydrolic", 3, 33400, "Artificial Leather");
		Sofa s7=new Sofa("Damro", "Wooden", 5, 59400, "Foam");
		
		session.save(s1);session.save(s2);session.save(s3);session.save(s4);
		session.save(s5);session.save(s6);session.save(s7);
		
		session.getTransaction().commit();
		session.close();
		
		factory.close();
	}
}
