package basics.deepa.java.DeepaJavaBasics.oop;

import java.util.Arrays;
import java.util.Scanner;

public class HRManager 
{
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) 
	{
		TechCorp corp=new TechCorp();
		do 
		{
			System.out.println("HR Privilages");
			System.out.println("HIRE\nFIRE\nVIEW\nTO\nUPDATE\nREVOKE\nBENCH\nEXP\nSKILL\nOUT");
			String option=scan.next();
			switch(option) 
			{
			case "update":case "UPDATE":
				System.out.println("Update people by name, skills, experience");
				Resource ress=new Resource();
				ress.setName(scan.next());
				System.out.println("Tell us how many skill you have: ");
				int sizes=scan.nextInt();
				String[] tecs=new String[sizes];
				System.out.println("Tell your each skill one by one: ");
				for(int index=0;index<tecs.length;index++)
				{
					tecs[index]=scan.next();
				}
				ress.setTech(tecs);
				ress.setExperience(scan.nextInt());
				corp.update(ress);
				break;
			case "hire":case "HIRE":
				System.out.println("Hire people by name, skills, experience");
				Resource res=new Resource();
				res.setName(scan.next());
				System.out.println("Tell us how many skill you have: ");
				int size=scan.nextInt();
				String[] tec=new String[size];
				System.out.println("Tell your each skill one by one: ");
				for(int index=0;index<tec.length;index++)
				{
					tec[index]=scan.next();
				}
				res.setTech(tec);
				res.setExperience(scan.nextInt());
				System.out.println(corp.recruite(res));
				break;
			case "fire":case "FIRE":
				System.out.println("Tell us based on what you'll fire people");
				String what=scan.next();
				if(what.equalsIgnoreCase("direct"))
				{
					System.out.println("Tell us index: ");
					System.out.println(corp.release(scan.nextInt()));
				}
				else if(what.equalsIgnoreCase("skill"))
				{
					System.out.println("Tell us skill: ");
					System.out.println(Arrays.toString(corp.release(scan.next())));
				}
				else {
					System.out.println("Invalid option");
				}
				break;
			case "view":case "VIEW":
				System.out.println("Available resources:\n"+corp);
				break;
			case "to":case "TO":
				System.out.println("TEll us experience to send them to bench");
				corp.sendToBench(scan.nextInt());
				break;
			case "revoke":case "REVOKE":
				System.out.println("Tell us desired skill to search: ");
				corp.redeemToProject(scan.next());
				break;
			case "bench":case "BENCH":
				corp.viewBench();
				break;
			case "skill":case "SKILL":
				System.out.println("Tell us desired skill to search: ");
				System.out.println(Arrays.toString(corp.filter(scan.next())));
				break;
			case "exp":case "EXP":
				System.out.println("Tell us desired experience to filter");
				System.out.println(Arrays.toString(corp.filter(scan.nextInt())));
				break;
			default:return;
			}
		}while(true);
	}
}
