package basics.maven.hiber.DeepaHibernate.week4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DemoManyToMany 
{
	public static void main(String[] args) 
	{
		SessionFactory fact=new Configuration().configure().buildSessionFactory();
		Session session=fact.openSession();
		session.beginTransaction();
		
		
		ResourcePerson person1=new ResourcePerson("Razak Mohamed", "Java,JavaScript");
		ResourcePerson person2=new ResourcePerson("Annamalai", "Java,Python");
		ResourcePerson person3=new ResourcePerson("Sobin", "Python");
		
		Product pro1=new Product("IRCTC", "Java", "Railway department");
		Product pro2=new Product("PassportSeva", "Dotnet", "Foriegn Affairs");
		Product pro3=new Product("UIDAI", "Java", "Union govt of India");
		
		person1.getCareer().add(pro1);
		person1.getCareer().add(pro3);
		
		person2.getCareer().add(pro1);
		person2.getCareer().add(pro2);
		
		person3.getCareer().add(pro2);
		person3.getCareer().add(pro3);
		
		
		pro1.getPersons().add(person1);pro1.getPersons().add(person2);
		pro2.getPersons().add(person2);pro2.getPersons().add(person3);
		pro3.getPersons().add(person3);pro3.getPersons().add(person1);
		
		
		session.save(person1);session.save(person2);session.save(person3);
		session.save(pro1);session.save(pro2);session.save(pro3);
		
		session.getTransaction().commit();
		session.close();
		fact.close();
	}
}
