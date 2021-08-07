package basics.deepa.java.DeepaJavaBasics.exceptions;

import basics.deepa.java.DeepaJavaBasics.oop.Resource;

public class ThirdOne 
{
	static Resource res; 
	public static void main(String[] args) 
	{
		try
		{
			res.setName("Razak Mohamed S");
			res.setTech(new String[] {"Java","Python","Javascript"});
			res.setExperience(11);
			System.out.println(res);
		}
		catch(NullPointerException np)
		{
			System.out.println("Object has to be initialized");
			res=new Resource();
			res.setName("Razak Mohamed S");
			res.setTech(new String[] {"Java","Python","Javascript"});
			res.setExperience(11);
			System.out.println(res);
		}
	}
}
