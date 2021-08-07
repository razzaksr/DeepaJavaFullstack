package basics.deepa.java.DeepaJavaBasics.exceptions;

import java.util.Scanner;

public class SecondUncheck 
{
	public static void main(String[] yet) 
	{
		Scanner scan=new Scanner(System.in);
		System.out.println(yet.length);
		try
		{
			int fuel=Integer.parseInt(yet[0]);
			int kms=Integer.parseInt(yet[1]);
			System.out.println(kms/fuel);
		}
		catch(NumberFormatException number)
		{
			System.out.println(number+"\nData are should be numeric");
			int fuel=Integer.parseInt(scan.next());
			int kms=Integer.parseInt(scan.next());
			System.out.println(kms/fuel);
		}
		finally
		{
			System.out.println("Milage calculation done");
		}
	}
}
