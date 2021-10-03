package basics.maven.hiber.DeepaHibernate.week2;

import java.util.Iterator;

public class Execution 
{
	public static void main(String[] args) 
	{
		Service service=new Service();
		
		/*
		 * Resource res1=new Resource("Mohan", "Python,Javascript", 8); Resource
		 * res2=new Resource("Victor", "Python", 2);  Resource res4=new Resource("Vijaya",
		 * "Python,Java", 13); System.out.println(service.insertion(res1)+" inserted");
		 * System.out.println(service.insertion(res2)+" inserted");
		 * System.out.println(service.insertion(res3)+" inserted");
		 * System.out.println(service.insertion(res4)+" inserted");
		 */
		
		/*
		 * Iterator<Resource> it=service.getAll().iterator(); while(it.hasNext()) {
		 * System.out.println(it.next()); }
		 */
		
		//System.out.println(service.getOne(4));
		
		/*
		 * Resource res3=new Resource(4,"Annamalai", "Java,Selenium,Python", 4);
		 * 
		 * System.out.println(service.updateOne(res3));
		 */
		
		Resource res1=new Resource(2,"Mohan", "Python,Javascript", 8);
		System.out.println(service.deleteOne(res1));
		
	}
}
