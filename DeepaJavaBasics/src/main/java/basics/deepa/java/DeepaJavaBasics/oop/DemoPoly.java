package basics.deepa.java.DeepaJavaBasics.oop;

import java.util.Arrays;

public class DemoPoly 
{
	static
	{
		System.out.println("Static block");
		Workshop work1=new Workshop("Deeplearning","Sobin",10);
		System.out.println(work1);
		DemoPoly.main();
		DemoPoly.main(new Integer[] {3,90,12,56,11,89,3});
		DemoPoly.main("Razak Mohamed S");
		DemoPoly.main(new String[][] {{"Salem","Dharmapuri","Namakkal"},{"Kovai","Erode"},{"Thanjai","Trichy","Kandchipuram"}});
	}
	public static void main() {
		System.out.println("Default main without parameters");
	}
	public static void main(Integer[] args) {
		System.out.println("Integer array main");
		System.out.println(Arrays.toString(args));
	}
	
	public static void main(String args) {
		System.out.println("String main "+args);
	}
	public static void main(String[][] args) {
		System.out.println("Multi dimentional array main");
		for(String[] row:args)
		{
			System.out.println(Arrays.toString(row));
		}
	}
	private Workshop[] ksr=new Workshop[] {
			new Workshop("Deeplearning","Adharsh",20),
			new Workshop("Fullstackjava", "Razak Mohamed S", 25),
			new Workshop("Python", "Sobin", 21),
			new Workshop("React", "Razak Mohamed S", 15),
			new Workshop("Embedded", "Aasai", 10),
			new Workshop("Deeplearning","Sobin",10)
	};
	public static void main(String[] args) 
	{
		System.out.println("Main thread");
		DemoPoly demo=new DemoPoly();
		//System.out.println(Arrays.toString(demo.find()));
		System.out.println(Arrays.toString(demo.find(21)));
		System.out.println(Arrays.toString(demo.find(2,5)));
		System.out.println(Arrays.toString(demo.find("Deeplearning")));
	}
	public Workshop[] find(int start,int end)
	{
		Workshop[] tmp=new Workshop[end-start];
		for(int pos=0;pos<tmp.length&&start<=end;pos++)
		{
			tmp[pos]=ksr[start];
			start++;
		}
		return tmp;
	}
	public Workshop[] find(int days)
	{
		System.out.println("finding based on "+ days +" days of workshop");
		Workshop[] tmp=new Workshop[ksr.length];
		for(int pos=0;pos<tmp.length;pos++)
		{
			if(ksr[pos].getDays()>=days)
				tmp[pos]=ksr[pos];
		}
		return tmp;
	}
	public Workshop[] find()
	{
		return ksr;
	}
	public Workshop[] find(String title)
	{
		System.out.println("finding workshop based on "+title+" title");
		Workshop[] tmp=new Workshop[ksr.length];
		for(int pos=0;pos<tmp.length;pos++)
		{
			if(ksr[pos].getTitle().compareToIgnoreCase(title)==0)
				tmp[pos]=ksr[pos];
		}
		return tmp;
	}
}

class Workshop
{
	private String title;
	private String resource;
	private int days;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	@Override
	public String toString() {
		return "Workshop [title=" + title + ", resource=" + resource + ", days=" + days + "]\n";
	}
	public Workshop(String title, String resource, int days) {
		super();
		this.title = title;
		this.resource = resource;
		this.days = days;
	}
	public Workshop() {
		super();
		// TODO Auto-generated constructor stub
	}
}