package basics.deepa.java.DeepaJavaBasics.oop;

public interface Parkour 
{
	String skill="Java";
	public static void nonab()
	{
		System.out.println("Non abstract");
	}
	default void handshake()
	{
		System.out.println("Peace between neighbour countries");
	}
	
}
