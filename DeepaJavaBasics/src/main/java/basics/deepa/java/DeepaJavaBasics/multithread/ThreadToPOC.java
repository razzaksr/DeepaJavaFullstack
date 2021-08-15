package basics.deepa.java.DeepaJavaBasics.multithread;

import java.util.Arrays;
import java.util.Scanner;

import basics.deepa.java.DeepaJavaBasics.oop.Resource;
import basics.deepa.java.DeepaJavaBasics.oop.TechCorp;

public class ThreadToPOC 
{
	public static void main(String[] args) 
	{
		Open open=new Open();
		open.corp.setTeam(new Resource[] {
				new Resource("RazakMohamedS", new String[] {"java","javascript","python"}, 10),
				new Resource("SabarinathanS", new String[] {"python"}, 13),
				new Resource("ManikandanM", new String[] {"javascript"}, 7),
				new Resource("MaheshwaranM", new String[] {"java"}, 15),
				new Resource("MularidharanM", new String[] {"C","CPP"}, 5),
				new Resource("SobinSunny", new String[] {"python"}, 7),
				new Resource("AasaiJay", new String[] {"java","python"}, 15),
				new Resource("RasheedhaR", new String[] {"java"}, 8),
				new Resource("AnnamalaiS", new String[] {"java","python"}, 5),
				new Resource("Anto", new String[] {"R"}, 3),
		});
		Thread t1=new Thread(open,"Manager One");
		Thread t2=new Thread(open,"Manager Two");
		Thread t3=new Thread(open,"Manager Three");
		Thread t4=new Thread(open,"Manager Four");
		t1.start();t2.start();t3.start();t4.start();
	}
}

class Open implements Runnable
{
	TechCorp corp=new TechCorp();
	static Scanner scan=new Scanner(System.in);
	@Override
	synchronized public void run() {
		// TODO Auto-generated method stub
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