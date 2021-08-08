package basics.deepa.java.DeepaJavaBasics.multithread;

public class Multitask 
{
	public static void main(String[] args) 
	{
		Domestic dom=new Domestic();
		Commercial com=new Commercial();
		Thread t1=new Thread(dom,"Private Vehicle");
		Thread t2=new Thread(com,"Public Vehicle");
		t1.start();t2.start();
	}
}
class Commercial extends Vehicle implements Runnable
{
	private static int collection=0;
	@Override
	public void calculateTax() {
		// TODO Auto-generated method stub
		if(getType().equals("three")||getType().equals("four"))
		{
			if(!getPermit().equals("state"))
			{
				collection+=210;
				setTotal(210);
			}
			else
			{
				collection+=300;
				setTotal(300);
			}
		}
		else {
			System.out.println("No tax");
		}
	}

	@Override
	public int cumulative() {
		// TODO Auto-generated method stub
		return Commercial.getTotal();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName());
		setRegnum("tn87t2567");
		setPermit("national");
		setType("four");
		calculateTax();
		System.out.println("Collection after "+Thread.currentThread().getName()+" is "+collection);
		System.out.println("Total Collection after "+Thread.currentThread().getName()+" is "+cumulative());
	}
	
}

class Domestic extends Vehicle implements Runnable
{
	private static int collection=0;
	@Override
	public void calculateTax() {
		// TODO Auto-generated method stub
		if(getType().equals("three")||getType().equals("four"))
		{
			if(!getPermit().equals("state"))
			{
				collection+=120;
				setTotal(120);
			}
			else
			{
				collection+=180;
				setTotal(180);
			}
		}
		else {
			System.out.println("No tax");
		}
	}

	@Override
	public int cumulative() {
		// TODO Auto-generated method stub
		return Domestic.getTotal();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName());
		setRegnum("tn53l4192");
		setPermit("state");
		setType("three");
		calculateTax();
		System.out.println("Collection after "+Thread.currentThread().getName()+" is "+collection);
		System.out.println("Total Collection after "+Thread.currentThread().getName()+" is "+cumulative());
	}
	
}

abstract class Vehicle
{
	public abstract void calculateTax();
	public abstract int cumulative(); 
	private static int total;
	private String regnum;
	private String type;
	private String permit;
	public static int getTotal() {
		return total;
	}
	public static void setTotal(int total) {
		Vehicle.total += total;
	}
	public String getRegnum() {
		return regnum;
	}
	public void setRegnum(String regnum) {
		this.regnum = regnum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPermit() {
		return permit;
	}
	public void setPermit(String permit) {
		this.permit = permit;
	}
}