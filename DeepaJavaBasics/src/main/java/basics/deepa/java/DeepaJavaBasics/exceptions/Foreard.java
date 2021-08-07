package basics.deepa.java.DeepaJavaBasics.exceptions;

import java.util.Scanner;

public class Foreard 
{
	static String[] hai= {"Downey","Evans","Jhonson","oslen"};
	static Scanner scan=new Scanner(System.in);
	static int index=0;
	public static void send()
	{
		try
		{
			System.out.println("Tell us index: ");
			index=scan.nextInt();
			System.out.println(hai[index]);
		}
		catch(ArrayIndexOutOfBoundsException ar)
		{
			System.out.println("Send not wish to handle");
			throw ar;
		}
	}
	public static void main(String[] args) 
	{
		try
		{
			Foreard.send();
		}
		catch(ArrayIndexOutOfBoundsException arr)
		{
			System.out.println("Tell us index: ");
			index=scan.nextInt();
			System.out.println(hai[index]);
		}
	}
}
