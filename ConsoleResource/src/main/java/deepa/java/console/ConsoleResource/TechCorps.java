package deepa.java.console.ConsoleResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

class TechCorps implements HumanResource
{ 
	//private Resource[] team=new Resource[10];
	ArrayList<Resource> team=new ArrayList<Resource>();
	ArrayList<Resource> bench=new ArrayList<Resource>();
	//private Resource[] bench=new Resource[10];
	File file=new File("D:\\Course backups\\Java\\Deepa\\corp.doc");
	FileOutputStream fos;
	ObjectOutputStream oos;
	FileInputStream fis;
	ObjectInputStream ois;
	
	@Override
	public String toString() {
		List<Resource> tmp=new ArrayList<Resource>();
		try {
			//if(fis.read()!=-1)
				fis=new FileInputStream(file);
				ois=new ObjectInputStream(fis);
				tmp = (List<Resource>) ois.readObject();
				ois.close();
				fis.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmp.toString();
	}
	public void setTeam(List<Resource> tmp)
	{
		try {
			fos=new FileOutputStream(file);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(tmp);
			System.out.println("Team intialized");
			oos.close();
			fos.close();
			System.out.println(tmp.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setBench(ArrayList<Resource> tmp)
	{
		this.bench=tmp;
		try {
			oos.writeObject(bench);
			System.out.println("Bench intialized");
			oos.flush();
			fos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	Scanner scan=new Scanner(System.in);

	@Override
	public String recruite(Resource resource) {
		// TODO Auto-generated method stub
		//team.add(resource);
		List<Resource> tmp=new ArrayList<Resource>();
		
		try {
			fis=new FileInputStream(file);
			ois=new ObjectInputStream(fis);
			tmp = (List<Resource>)ois.readObject();
			ois.close();fis.close();
			tmp.add(resource);
			fos=new FileOutputStream(file);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(tmp);
			oos.close();
			fos.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resource.getName()+" has recruited successfully";
	}

	@Override
	public String release(int index) {
		// TODO Auto-generated method stub
		ArrayList<Resource> tmp=null;
		try {
			tmp = (ArrayList<Resource>)ois.readObject();
			if(tmp.get(index)!=null)
			{
				String name=tmp.get(index).getName();
				tmp.remove(index);
				return name+" has released ";
			}
			else
			{
				throw new ResourceException();
			}
		}
		catch(ResourceException | ClassNotFoundException | IOException res)
		{
			System.out.println(res);
			System.out.println("Tell us index once again within "+tmp.size());
			return release(scan.nextInt());
		}
	}

	@Override
	public String[] release(String tech) {
		// TODO Auto-generated method stub
		//String[] tmp=new String[team.length];
		ArrayList<Resource> tmps=null;
		List<String> tmp=new ArrayList<String>();
		try
		{
			tmps = (ArrayList<Resource>)ois.readObject();
			for(int index=0;index<tmps.size();index++)
			{
				if(Arrays.toString(tmps.get(index).getTech()).contains(tech))
				{
					tmp.add(tmps.get(index).getName());
					tmps.remove(index);
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
		catch(ResourceException | ClassNotFoundException | IOException res)
		{
			System.out.println(res);
			System.out.println("Tell us skillset once again: ");
			return release(scan.next());
		}
	}

	@Override
	public void update(Resource resource) {
		// TODO Auto-generated method stub
		ArrayList<Resource> tmps=null;
		try
		{
			tmps = (ArrayList<Resource>)ois.readObject();
			for(int index=0;index<tmps.size();index++)
			{
				if(tmps.get(index).getName().equals(resource.getName()))
				{
					tmps.set(index, resource);
					
					oos.writeObject(tmps);oos.flush();
					
					System.out.println(resource.getName()+" has updated ");
					return;
				}
			}
			throw new ResourceException();
		}
		catch(ResourceException | ClassNotFoundException | IOException res)
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
