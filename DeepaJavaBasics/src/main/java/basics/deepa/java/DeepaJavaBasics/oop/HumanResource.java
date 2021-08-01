package basics.deepa.java.DeepaJavaBasics.oop;

public interface HumanResource 
{
	public String recruite(Resource resource);
	public String release(int index);
	public String[] release(String tech);
	public void update(Resource resource);
	public Resource[] filter(String tech);
	public Resource[] filter(Integer exp);
	public void sendToBench(Integer exp);
	public void viewBench();
	public void redeemToProject(String skill);
}
