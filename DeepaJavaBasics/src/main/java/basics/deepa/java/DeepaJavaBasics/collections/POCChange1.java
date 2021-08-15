package basics.deepa.java.DeepaJavaBasics.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import basics.deepa.java.DeepaJavaBasics.oop.HumanResource;
import basics.deepa.java.DeepaJavaBasics.oop.Resource;
import basics.deepa.java.DeepaJavaBasics.oop.ResourceException;

public class POCChange1 
{
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) 
	{
		TecCorp corp=new TecCorp();
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

class TecCorp implements HumanResource
{ 
	//private Resource[] team=new Resource[10];
	ArrayList<Resource> team=new ArrayList<Resource>();
	ArrayList<Resource> bench=new ArrayList<Resource>();
	//private Resource[] bench=new Resource[10];
	public void setTeam(ArrayList<Resource> tmp)
	{
		this.team=tmp;
	}
	public void setBench(ArrayList<Resource> tmp)
	{
		this.bench=tmp;
	}
	Scanner scan=new Scanner(System.in);

	@Override
	public String toString() {
		return team.toString();
	}

	@Override
	public String recruite(Resource resource) {
		// TODO Auto-generated method stub
		team.add(resource);
		return resource.getName()+" has recruited ";
	}

	@Override
	public String release(int index) {
		// TODO Auto-generated method stub
		try {
			if(team.get(index)!=null)
			{
				String name=team.get(index).getName();
				team.remove(index);
				return name+" has released ";
			}
			else
			{
				throw new ResourceException();
			}
		}
		catch(ResourceException res)
		{
			System.out.println(res);
			System.out.println("Tell us index once again within "+team.size());
			return release(scan.nextInt());
		}
	}

	@Override
	public String[] release(String tech) {
		// TODO Auto-generated method stub
		//String[] tmp=new String[team.length];
		List<String> tmp=new ArrayList<String>();
		try
		{
			for(int index=0;index<team.size();index++)
			{
				if(Arrays.toString(team.get(index).getTech()).contains(tech))
				{
					tmp.add(team.get(index).getName());
					team.remove(index);
				}
			}
			if(tmp.isEmpty())
			{
				throw new ResourceException();
			}
			else {
				return (String[])tmp.toArray();
			}
		}
		catch(ResourceException res)
		{
			System.out.println(res);
			System.out.println("Tell us skillset once again: ");
			return release(scan.next());
		}
	}

	@Override
	public void update(Resource resource) {
		// TODO Auto-generated method stub
		try
		{
			for(int index=0;index<team.size();index++)
			{
				if(team.get(index).getName().equals(resource.getName()))
				{
					team.set(index, resource);
					System.out.println(resource.getName()+" has updated ");
					return;
				}
			}
			throw new ResourceException();
		}
		catch(ResourceException res)
		{
			System.out.println(res);
			System.out.println(resource.getName()+" not part of the team");
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
			update(ress);
		}
	}

	@Override
	public Resource[] filter(String tech) {
		// TODO Auto-generated method stub
		try
		{
			System.out.println("Filter based on skill: "+tech);
			Vector<Resource> tmp=new Vector<Resource>();
			for(int index=0;index<team.size();index++)
			{
				if(Arrays.toString(team.get(index).getTech()).contains(tech))
				{
					tmp.add(team.get(index));
				}
			}
			if(tmp.isEmpty())
				throw new ResourceException();
			else
				return (Resource[])tmp.toArray();
		}
		catch(ResourceException res)
		{
			System.out.println(res);
			System.out.println("Tell us skillset once again: ");
			return filter(scan.next());
		}
	}

	@Override
	public Resource[] filter(Integer exp) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Filter based on experience: "+exp);
			Vector<Resource> tmp=new Vector<Resource>();
			for(int index=0;index<team.size();index++)
			{
				if(team.get(index).getExperience()>=exp)
				{
					tmp.add(team.get(index));
				}
			}
			if(tmp.isEmpty())
				throw new ResourceException();
			else
				return (Resource[])tmp.toArray();
		}
		catch(ResourceException res)
		{
			System.out.println(res);
			System.out.println("Tell us experience once again: ");
			return filter(scan.nextInt());
		}
	}

	@Override
	public void sendToBench(Integer exp) {
		System.out.println("Trying to send resources whom are all having experience: "+exp);
		// TODO Auto-generated method stub
		for(int index=0;index<team.size();index++)
		{
			if(team.get(index).getExperience()>=exp)
			{
				bench.add(team.get(index));
				System.out.println(team.get(index).getName()+" moved to bench");
				team.remove(index);
			}
		}
	}

	@Override
	public void viewBench() {
		// TODO Auto-generated method stub
		System.out.println("Resource's in the bench");
		System.out.println(bench);
	}

	@Override
	public void redeemToProject(String skill) {
		System.out.println("Trying to redeem resources by "+skill);
		// TODO Auto-generated method stub
		for(int index=0;index<bench.size();index++)
		{
			if(Arrays.toString(bench.get(index).getTech()).contains(skill))
			{
				team.add(bench.get(index));
				System.out.println(bench.get(index).getName()+" has redeemed to project ");
				bench.remove(index);
				break;
			}
			else {
				System.out.println(bench.get(index).getName()+" has sack");
				bench.remove(index);
			}
		}
	}
}