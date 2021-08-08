package basics.deepa.java.DeepaJavaBasics.exceptions;

public class DeepaException extends Exception 
{
	public DeepaException()
	{
		super("PasswordMismatchException");
	}
	public String toString()
	{
		return "PasswordMismatchException";
	}
}
