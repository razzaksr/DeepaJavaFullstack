package basics.deepa.java.DeepaJavaBasics.multithread;

public class OneByOne 
{
	public static void main(String[] args) 
	{
		West west=new West();
		Thread t1=new Thread(west,"MongoDb");
		Thread t2=new Thread(west,"Mongoose");
		Thread t3=new Thread(west,"MySQL");
		Thread t4=new Thread(west,"MariaDB");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
class West implements Runnable
{
	double[] wts= {9.1,3.5,12.8,20.4,5.5,9.2,10.5};
	public void list()
	{
		System.out.println(Thread.currentThread().getName()+" came for listing");
		for(double tmp:wts)
		{
			System.out.println(tmp);
		}
	}
	public void bubble()
	{
		System.out.println(Thread.currentThread().getName()+" came for sorting");
		for(int bub1=0;bub1<wts.length-1;bub1++)
		{
			for(int bub2=0;bub2<wts.length-bub1-1;bub2++)
			{
				if(wts[bub1]>wts[bub2])
				{
					wts[bub1]*=wts[bub2];
					wts[bub2]=wts[bub1]/wts[bub2];
					wts[bub1]/=wts[bub2];
				}
			}
		}
	}
	@Override
	public void run() 
	{
		System.out.println("Before sorting");
		list();
		synchronized (wts) 
		{
			bubble();
			System.out.println("After sorting "+Thread.currentThread().getName());
			list();
		}
	}
}