package basics.deepa.java.DeepaJavaBasics.oop;

import java.util.Arrays;

public class TechCorp implements HumanResource
{
	private Resource[] team=new Resource[10];
	private Resource[] bench=new Resource[10];

	@Override
	public String toString() {
		return "TechCorp [team=" + Arrays.toString(team) + "]";
	}

	@Override
	public String recruite(Resource resource) {
		// TODO Auto-generated method stub
		for(int index=0;index<team.length;index++)
		{
			if(team[index]==null)
			{
				team[index]=resource;
				return resource.getName()+" has recruited ";
			}
		}
		return resource.getName()+" hasn't recruited";
	}

	@Override
	public String release(int index) {
		// TODO Auto-generated method stub
		if(index<team.length)
			{
				team[index]=null;
				return team[index].getName()+" has released ";
			}
		else
		{
			return "Invalid index";
		}
	}

	@Override
	public String[] release(String tech) {
		// TODO Auto-generated method stub
		String[] tmp=new String[team.length];
		for(int index=0,pos=0;index<team.length;index++)
		{
			if(Arrays.toString(team[index].getTech()).contains(tech))
			{
				tmp[pos]=team[index].getName();
				team[index]=null;
				pos++;
			}
		}
		return tmp;
	}

	@Override
	public void update(Resource resource) {
		// TODO Auto-generated method stub
		for(int index=0;index<team.length;index++)
		{
			if(team[index].getName().equals(resource.getName()))
			{
				team[index]=resource;
				System.out.println(resource.getName()+" has updated ");
				return;
			}
		}
		System.out.println(resource.getName()+" not part of the team");
	}

	@Override
	public Resource[] filter(String tech) {
		// TODO Auto-generated method stub
		System.out.println("Filter based on skill: "+tech);
		Resource[] tmp=new Resource[team.length];
		for(int index=0,pos=0;index<team.length;index++)
		{
			if(Arrays.toString(team[index].getTech()).contains(tech))
			{
				tmp[pos]=team[index];
				pos++;
			}
		}
		return tmp;
	}

	@Override
	public Resource[] filter(Integer exp) {
		// TODO Auto-generated method stub
		System.out.println("Filter based on experience: "+exp);
		Resource[] tmp=new Resource[team.length];
		for(int index=0,pos=0;index<team.length;index++)
		{
			if(team[index].getExperience()>=exp)
			{
				tmp[pos]=team[index];
				pos++;
			}
		}
		return tmp;
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
			if(Arrays.toString(bench[index].getTech()).contains(skill))
			{
				for(int ind=0;ind<team.length;ind++)
				{
					if(team[ind]==null)
					{
						team[index]=bench[index];
						System.out.println(bench[index].getName()+" has redeemed to project ");
					}
				}
			}
			else {
				System.out.println(bench[index].getName()+" has sack");
				bench[index]=null;
			}
		}
	}
}
