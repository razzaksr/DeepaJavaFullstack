package basics.deepa.java.DeepaJavaBasics.exceptions;

import java.util.Scanner;

public class Custom 
{
	private String user,pass;
	private boolean auth=false;
	private String[] list= {"Selection","Quick","Merge","Insertion","Bubble"};
	Scanner scan=new Scanner(System.in);
	public void show()
	{
		try
		{
			if(auth) {
				for(String tmp:list)
				{
					System.out.println(tmp);
				}
			}
			else {
				throw new DeepaException();
			}
		}
		catch(DeepaException deepa)
		{
			System.out.println(deepa);
			authorise();
			if(auth) {
				for(String tmp:list)
				{
					System.out.println(tmp);
				}
			}
		}
	}
	public Custom() {authorise();}
	public void authorise()
	{
		System.out.println("Tell us username and password");
		user=scan.next();pass=scan.next();
		if(user.equals("zealous")&&pass.equals("fullstack"))
		{
			auth=true;
		}
		else {auth=false;}
	}
}
