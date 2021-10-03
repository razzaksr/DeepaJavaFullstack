package basics.maven.hiber.DeepaHibernate.week2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Service 
{
	private SessionFactory factory;
	private Session session;
	public Service()
	{
		factory=new Configuration().configure().buildSessionFactory();
		session=factory.openSession();
	}
	public int insertion(Resource resource)
	{
		session.beginTransaction();
		
		int number=(int)session.save(resource);
		
		session.getTransaction().commit();
		
		return number;
	}
	
	public List<Resource> getAll()
	{
		session.beginTransaction();
		
		List<Resource> hi =(List<Resource>) session.createQuery("from Resource").list();
		
		session.getTransaction().commit();
		
		return hi;
	}
	
	public Resource getOne(int key)
	{
		session.beginTransaction();
		
		Resource resource=session.get(Resource.class, key);
		
		session.getTransaction().commit();
		
		return resource;
	}
	
	public String updateOne(Resource resource)
	{
		session.beginTransaction();
		
		//session.find(Resource.class, resource.getNum()).getName()+" get updated";
		
		session.update(resource);
		
		session.getTransaction().commit();
		
		return resource.getName()+" has updated";
	}
	
	public String deleteOne(Resource resource)
	{
		session.beginTransaction();
		
		session.delete(resource);
		
		session.getTransaction().commit();
		
		return resource.getName()+" has deleted";
	}
	
}
