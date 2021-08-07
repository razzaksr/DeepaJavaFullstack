package basics.deepa.java.DeepaJavaBasics.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NEsted 
{
	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		int kms=0, fuel=0, index=0;
		int[] history= {90,12,100,50,20,0,210,5,310};
		
		try
		{
			System.out.println("Select kms driven from history");
			index=scan.nextInt();
			kms=history[index];
			System.out.println("Tell us fuel filled to travel "+kms);
			fuel=scan.nextInt();
			System.out.println("Milage is "+(kms/fuel));
		}
		catch(InputMismatchException | ArrayIndexOutOfBoundsException  number)
		{
			Scanner sc=new Scanner(System.in);
			System.out.println(number+"\nNumeric only index within "+history.length);
			try
			{
				System.out.println("Select kms driven from history");
				index=sc.nextInt();
				kms=history[index];
				System.out.println("Tell us fuel filled to travel "+kms);
				fuel=sc.nextInt();
				System.out.println("Milage is "+(kms/fuel));
			}
			catch(ArithmeticException am)
			{
				System.out.println(am+"\nfuel has to be mentioned");
				System.out.println("Tell us fuel filled to travel "+kms);
				fuel=sc.nextInt();
				System.out.println("Milage is "+(kms/fuel));
			}
		}
		catch(ArithmeticException am)
		{
			System.out.println(am+"\nfuel has to be mentioned");
			System.out.println("Tell us fuel filled to travel "+kms);
			fuel=scan.nextInt();
			System.out.println("Milage is "+(kms/fuel));
		}
		catch(Exception exe)
		{
			System.out.println(exe);
		}
		finally {
			System.out.println("Milage calculation done");
		}
	}
}
