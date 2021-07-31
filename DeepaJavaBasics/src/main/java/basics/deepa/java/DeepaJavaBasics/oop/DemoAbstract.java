package basics.deepa.java.DeepaJavaBasics.oop;

public class DemoAbstract 
{
	public static void main(String[] args) 
	{
		Vehicle vehicle=new Domestic();
		vehicle.setRegnum("tn53l4192");
		vehicle.setPermit("state");
		vehicle.setType("three");
		vehicle.calculateTax();
		vehicle=new Commercial();
		vehicle.setRegnum("tn87t2567");
		vehicle.setPermit("national");
		vehicle.setType("four");
		vehicle.calculateTax();
		System.out.println(vehicle.cumulative());
	}
}

class Commercial extends Vehicle
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
	
}

class Domestic extends Vehicle
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