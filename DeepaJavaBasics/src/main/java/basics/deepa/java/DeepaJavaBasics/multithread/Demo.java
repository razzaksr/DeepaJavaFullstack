package basics.deepa.java.DeepaJavaBasics.multithread;

public class Demo 
{
	public static void main(String[] args) throws InterruptedException 
	{
		House house=new House();
		Thread t1=new Thread(house,"MongoDb");
		Thread t2=new Thread(house,"Mongoose");
		Thread t3=new Thread(house,"MySQL");
		Thread t4=new Thread(house,"MariaDB");
		t1.start();t1.join();
		t2.start();t2.join();
		t3.start();t3.join();
		t4.start();t4.join();
	}
}

class House implements Runnable//extends Thread
{
	private int[][] rents= {{20000,10000,12000},{8000,5000,10000,5000,4000},{5600,3120,8000}};
	public void list()
	{
		for(int[] floor:rents)
		{
			for(int each:floor)
			{
				System.out.print(each+" ");
			}
			System.out.println();
		}
	}
	public void run()
	{
		System.out.println(Thread.currentThread().getName()+" came inside");
		System.out.println(Thread.currentThread().getId()+" came inside");
		list();
	}
}