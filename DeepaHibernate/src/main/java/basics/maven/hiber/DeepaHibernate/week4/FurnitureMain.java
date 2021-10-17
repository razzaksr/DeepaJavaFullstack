package basics.maven.hiber.DeepaHibernate.week4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FurnitureMain {
	public static void main(String[] args) {
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	Session s=sf.openSession();
	s.beginTransaction();
	Furniture f=new Furniture("Tv", 60000);
	//Collection<FurnitureQuality> c = new ArrayList<FurnitureQuality>();
	FurnitureQuality fq=new FurnitureQuality("5000","Smart Access",new Date("12/10/2020"));
	FurnitureQuality fq1=new FurnitureQuality("7200","Low Weight",new Date("03/17/2020"));
	/*c.add(fq);
	c.add(fq1);*/
	f.getFq().add(fq);
	f.getFq().add(fq1);
	/*
	 * Iterator li=s.createQuery("from Furniture").list().iterator();
	 * while(li.hasNext()) { System.out.println("data=="+li.next()); }
	 */
	System.out.println("");
	s.save(f);
	s.getTransaction().commit();
	s.close();
	sf.close();
		
	}
}
