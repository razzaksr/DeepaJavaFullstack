package basics.deepa.java.DeepaJavaBasics.collections;

import java.util.Random;

public class RanGen 
{
	public static void main(String[] args) 
	{
		Random random=new Random();
		//System.out.println(random.nextInt(100000));
		StringBuffer buffer=new StringBuffer();
		for(int times=1;times<=5;times++)
		{
			buffer.append(random.nextInt(10));
		}
		System.out.println("OTP is "+buffer.toString());
	}
}
