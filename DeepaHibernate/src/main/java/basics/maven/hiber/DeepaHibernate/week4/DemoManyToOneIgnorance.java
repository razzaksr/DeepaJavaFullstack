package basics.maven.hiber.DeepaHibernate.week4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DemoManyToOneIgnorance 
{
	public static void main(String[] args) 
	{
		SessionFactory fact=new Configuration().configure().buildSessionFactory();
		Session session=fact.openSession();
		session.beginTransaction();
		
		/*
		ResourcePerson person=new ResourcePerson("Razak Mohamed", "Java,JavaScript");
		
		Product pro1=new Product("IRCTC", "Java", "Railway department",person);
		Product pro2=new Product("PassportSeva", "Dotnet", "Foriegn Affairs",person);
		Product pro3=new Product("UIDAI", "Java", "Union govt of India",person);
		person.getCareer().add(pro1); 
		person.getCareer().add(pro2);
		person.getCareer().add(pro3);
		session.save(person);
		session.save(pro1);session.save(pro2);session.save(pro3);
		*/
		 
		
		session.getTransaction().commit();
		session.close();
		fact.close();
	}
}
