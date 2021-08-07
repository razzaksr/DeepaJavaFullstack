package basics.deepa.java.DeepaJavaBasics.exceptions;

import java.util.Scanner;

public class InfiniteChances 
{
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) 
	{
		try
		{
			System.out.println("Tell us fuel and kms");
			int fuel=Integer.parseInt(scan.next());
			int kms=Integer.parseInt(scan.next());
			System.out.println(kms/fuel);
		}
		catch(NumberFormatException number)
		{
			System.out.println(number+"\nData are should be numeric");
			InfiniteChances.main(args);
		}
	}
}
