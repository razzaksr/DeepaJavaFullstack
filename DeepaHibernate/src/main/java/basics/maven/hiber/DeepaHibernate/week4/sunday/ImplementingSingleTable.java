package basics.maven.hiber.DeepaHibernate.week4.sunday;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ImplementingSingleTable 
{
	public static void main(String[] args) 
	{
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Session session=factory.openSession();
		session.beginTransaction();
		
		Google g1=new Google("razzaksr@gmail.com", "Razak Mohamed S", new Date("1/26/1991"));
		
		Youtube y1=new Youtube("rasheedharmohamed@gmail.com", "Rasheedha R", new Date("11/16/1991"));
		y1.setUploads(new String[] {"Kids rhymes","C++"});
		y1.setWatchlater(new String[] {"IoT","AI","Data science"});
		
		GPay gpay=new GPay("razaksrmd@gmail.com", "Razak Mohamed S", new Date("1/26/1991"));
		gpay.setAccnumber(87654567876578L);gpay.setAccbalance(2000.56);
		
		
		session.save(g1);session.save(y1);session.save(gpay);
		
		gpay.send(200);
		
		session.getTransaction().commit();
		session.close();
		
		factory.close();
	}
}
