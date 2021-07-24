package basics.deepa.java.DeepaJavaBasics.oop;

import java.util.Arrays;
import java.util.Scanner;

public class InnerClass2 
{
	public static void main(String[] args) 
	{
		Wind.traverse();
		Wind.Ifen ifen=new Wind.Ifen();
		ifen.assign();
		Wind.traverse();
	}
}


class Wind
{
	static Integer[] yet= {};
	static void traverse()
	{
		System.out.println(Arrays.toString(yet));
	}
	static class Ifen
	{
		Scanner scan=new Scanner(System.in);
		public void assign()
		{
			System.out.println("Tell us no of values you wish to assign?");
			int size=scan.nextInt();
			yet=new Integer[size];
			System.out.println("Tell us value of "+size);
			for(int pos=0;pos<size;pos++)
			{
				yet[pos]=scan.nextInt();
			}
		}
	}
}