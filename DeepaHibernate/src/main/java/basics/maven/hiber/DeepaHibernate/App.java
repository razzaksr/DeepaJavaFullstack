package basics.maven.hiber.DeepaHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory factory=new Configuration().configure().buildSessionFactory();
    	System.out.println(factory.isOpen());
    	
    	
    	Session session=factory.openSession();
    	session.beginTransaction();
    	
    	Pen pen1=new Pen("Dash5", "Reynolds", "Red", 10, 1000);//transient
    	Pen pen2=new Pen("Point4", "Nataraj", "Blue", 5, 250);
    	Pen pen3=new Pen("Reach2", "Bindas", "Green", 12, 900);
    	//Pen pen1=new Pen("Polo5", "Camlin", "Black", 7, 450);
    	//Pen pen2=new Pen("Polo3", "Camlin", "Black", 7, 450);
    	session.save(pen1);session.save(pen2);session.save(pen3);
    	
    	session.getTransaction().commit();
    	session.close();
    	
    	
    	factory.close();
        System.out.println( "Hello World!" );
    }
}
