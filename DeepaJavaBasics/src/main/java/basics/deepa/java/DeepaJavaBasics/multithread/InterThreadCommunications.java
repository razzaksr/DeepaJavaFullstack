package basics.deepa.java.DeepaJavaBasics.multithread;

import java.util.Arrays;
import java.util.Scanner;

public class InterThreadCommunications 
{
	public static void main(String[] args) 
	{
		Theatre the=new Theatre();
		Market mark=new Market(the);
		Thread t1=new Thread(the,"Ravi");
		Thread t2=new Thread(mark,"Vikas");
		t1.start();t2.start();
	}
}

class Market implements Runnable
{
	public Market() {}
	Theatre local; 
	public Market(Theatre theatre)
	{
		local=theatre;
	}
	String[] items;
	Scanner scan=new Scanner(System.in);
	@Override
	public void run() 
	{
		synchronized (local.scan) 
		{
			if(local.amt<200)
			{
				local.amt=300;
				System.out.println(Thread.currentThread().getName()+" helped inorder to watch movie");
				local.scan.notify();
			}
		}
		System.out.println(Thread.currentThread().getName()+" visited to market for function purchase ");
		System.out.println("No of purchased: ");
		items=new String[scan.nextInt()];
		for(int pos=0;pos<items.length;pos++)
		{
			System.out.println("Tell us each purchased item: ");
			items[pos]=scan.next();
		}
		list();
	}
	public void list()
	{
		System.out.println(Arrays.toString(items));
	}
}

class Theatre implements Runnable
{
	Scanner scan=new Scanner(System.in);
	int amt;
	@Override
	public void run() 
	{
		synchronized (scan) 
		{
			System.out.println("Enter the amount: ");
			amt=scan.nextInt();
			if(amt<200)
			{
				try {
					scan.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Enjoy your movie "+Thread.currentThread().getName());
		}
	}
}