package basics.deepa.java.DeepaJavaBasics.oop;

import java.util.Arrays;

public class SubClass1 
{
	public void season()
	{
		System.out.println("Winter is coming");
	}
	public static void main(String[] args) 
	{
		SubClass1 sub=new SubClass1();
		sub.season();
		Find find=new Find();
		find.list();
	}
}

class Find
{
	private String[] yet= {"Scarlet","Pratt","Downey","Hiddleson","Evans"};
	public void list()
	{
		System.out.println(Arrays.toString(yet));
	}
}