package basics.deepa.java.DeepaJavaBasics.collections;

import java.util.TreeSet;

public class ListCustom 
{
	public static void main(String[] args) 
	{
		TreeSet<Service> object=new TreeSet<Service>();
		object.add(new Service("ABC Corp", 13.5));
		object.add(new Service("Zealous Tech Corp", 9.5));
		object.add(new Service("Le Fresh", 8.3));
		object.add(new Service("Zebronics", 10.5));
		System.out.println(object);
	}
}

class Service implements Comparable<Service>
{
	private String name;
	private Double worth;
	public Service(String a,Double b) {name=a;worth=b;}
	public String toString()
	{
		return name+" "+worth+"\n";
	}
	@Override
	public int compareTo(Service o) {
		// TODO Auto-generated method stub
		//return this.worth.compareTo(o.worth);
		return o.worth.compareTo(this.worth);
	}
}