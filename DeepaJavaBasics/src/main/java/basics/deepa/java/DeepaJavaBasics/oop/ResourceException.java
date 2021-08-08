package basics.deepa.java.DeepaJavaBasics.oop;

public class ResourceException extends Exception
{
	public ResourceException()
	{
		super("Resource Not Available");
	}
	public String toString() {
		return "Resource Not Available";
	}
}
