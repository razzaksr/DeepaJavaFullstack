package basics.deepa.java.DeepaJavaBasics.multithread;

import java.util.Scanner;

public class LifeCycle 
{
	public static void main(String[] args) 
	{
		Machine machine=new Machine();
		Thread t1=new Thread(machine,"Vinoth");
		Thread t2=new Thread(machine,"Victor");
		Thread t3=new Thread(machine,"Vinay");
		Thread t4=new Thread(machine,"Karan");
		Thread t5=new Thread(machine,"Murali");
		Thread t6=new Thread(machine,"Ranjith");
		Thread t7=new Thread(machine,"Ravi");
		Thread t8=new Thread(machine,"Dharan");
		Thread t9=new Thread(machine,"Maran");
		Thread t10=new Thread(machine,"Mahesh");
		t1.start();t2.start();t3.start();t4.start();t5.start();
		t6.start();t7.start();t8.start();t9.start();t10.start();
	}
}

class Machine implements Runnable
{
	int available=120000;
	Scanner scan=new Scanner(System.in);
	@Override
	public void run() 
	{
		System.out.println(Thread.currentThread().getName()+" Welcome to ICICI E Services");
		synchronized (scan) 
		{
			System.out.println("Tell us amount to withdraw: ");
			int amt=scan.nextInt();
			if(amt>4000)
			{
				System.out.println(Thread.currentThread().getName()+" Maximum limit exceed");
				Thread.currentThread().stop();
			}
			else {
				available-=amt;
				System.out.println(amt+" withdrawn successfully by "+Thread.currentThread().getName());
			}
		}
		try {
			Thread.currentThread().sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" Thanks for visiting ICICI E Services");
	}
}