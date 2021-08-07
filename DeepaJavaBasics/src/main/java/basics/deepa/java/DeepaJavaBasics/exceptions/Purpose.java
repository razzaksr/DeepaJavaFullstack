package basics.deepa.java.DeepaJavaBasics.exceptions;

import java.util.Scanner;

public class Purpose 
{
	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		String yet="Zealous7Tech4Corp";
		try {
			System.out.println("Tell us two indecies inorder to X");
			int one=yet.charAt(scan.nextInt());
			int two=yet.charAt(scan.nextInt());
			System.out.println(one*two);
		}
		catch(StringIndexOutOfBoundsException sin)
		{
			System.out.println(sin+" index within "+yet.length());
			//sin.printStackTrace();
			System.out.println("Tell us two indecies inorder to X");
			int one=yet.charAt(scan.nextInt());
			int two=yet.charAt(scan.nextInt());
			System.out.println(one*two);
		}
		finally
		{
			System.out.println("Multiplication done");
		}
	}
}
