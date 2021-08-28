package deepa.java.console.ConsoleResource;

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
