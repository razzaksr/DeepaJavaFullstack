package basics.deepa.java.DeepaJavaBasics.oop;

public class InnerClass3 
{
	public static void main(String[] args) 
	{
		Marshmallow marsh=new Marshmallow();
		marsh.gen();
	}
}

class Marshmallow
{
	double[] ctc= {};
	
	public void gen()
	{
		
		class Passing
		{
			public void add()
			{
				ctc=new double[]{9.1,3.4,7.1,6.1,45.9,12.4};
			}
		}
		Passing pass=new Passing();
		pass.add();
		double data=0;
		data=ctc[0]/ctc[1];
		System.out.println(data);
	}
}