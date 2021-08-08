package basics.deepa.java.DeepaJavaBasics.oop;

import java.util.Arrays;
import java.util.Scanner;

public class TechCorp implements HumanResource
{
	private Resource[] team=new Resource[10];
	private Resource[] bench=new Resource[10];
	public void setTeam(Resource[] tmp)
	{
		this.team=tmp;
	}
	public void setBench(Resource[] tmp)
	{
		this.bench=tmp;
	}
	Scanner scan=new Scanner(System.in);

	@Override
	public String toString() {
		return "TechCorp [team=" + Arrays.toString(team) + "]";
	}

	@Override
	public String recruite(Resource resource) {
		// TODO Auto-generated method stub
		try
		{
			for(int index=0;index<team.length;index++)
			{
				if(team[index]==null)
				{
					team[index]=resource;
					return resource.getName()+" has recruited ";
				}
			}
			throw new ResourceException();
		}
		catch(ResourceException res)
		{
			return res.toString();
		}
	}

	@Override
	public String release(int index) {
		// TODO Auto-generated method stub
		try {
			if(team[index]!=null&&index<team.length)
			{
				String name=team[index].getName();
				team[index]=null;
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
			String inds="";
			for(int pos=0;pos<team.length;pos++)
			{
				if(team[pos]==null)
					inds+=pos+" ";
			}
			System.out.println("Tell us index once again within "+team.length+" also excluding "+inds);
			return release(scan.nextInt());
		}
	}

	@Override
	public String[] release(String tech) {
		// TODO Auto-generated method stub
		String[] tmp=new String[team.length];
		try
		{
			for(int index=0,pos=0;index<team.length;index++)
			{
				if(Arrays.toString(team[index].getTech()).contains(tech))
				{
					tmp[pos]=team[index].getName();
					team[index]=null;
					pos++;
				}
			}
			if(tmp[0]==null)
			{
				throw new ResourceException();
			}
			else {
				return tmp;
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
			for(int index=0;index<team.length;index++)
			{
				if(team[index]!=null&&team[index].getName().equals(resource.getName()))
				{
					team[index]=resource;
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
			Resource[] tmp=new Resource[team.length];
			for(int index=0,pos=0;index<team.length;index++)
			{
				if(team[index]!=null&&Arrays.toString(team[index].getTech()).contains(tech))
				{
					tmp[pos]=team[index];
					pos++;
				}
			}
			if(tmp[0]==null)
				throw new ResourceException();
			else
				return tmp;
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
			Resource[] tmp=new Resource[team.length];
			for(int index=0,pos=0;index<team.length;index++)
			{
				if(team[index]!=null&&team[index].getExperience()>=exp)
				{
					tmp[pos]=team[index];
					pos++;
				}
			}
			if(tmp[0]==null)
				throw new ResourceException();
			else
				return tmp;
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
		for(int index=0,pos=0;index<team.length;index++)
		{
			if(team[index]!=null&&team[index].getExperience()>=exp)
			{
				bench[pos]=team[index];
				System.out.println(team[index].getName()+" moved to bench");
				team[index]=null;
				pos++;
			}
		}
	}

	@Override
	public void viewBench() {
		// TODO Auto-generated method stub
		System.out.println("Resource's in the bench");
		System.out.println(Arrays.toString(bench));
	}

	@Override
	public void redeemToProject(String skill) {
		System.out.println("Trying to redeem resources by "+skill);
		// TODO Auto-generated method stub
		for(int index=0;index<bench.length;index++)
		{
			if(bench[index]!=null&&Arrays.toString(bench[index].getTech()).contains(skill))
			{
				for(int ind=0;ind<team.length;ind++)
				{
					if(team[ind]==null)
					{
						team[ind]=bench[index];
						System.out.println(bench[index].getName()+" has redeemed to project ");
						bench[index]=null;
						break;
					}
				}
			}
			else {
				if(bench[index]!=null)
				{
					System.out.println(bench[index].getName()+" has sack");
					bench[index]=null;
				}
			}
		}
	}
}
