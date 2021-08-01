package basics.deepa.java.DeepaJavaBasics.oop;

import java.util.Arrays;

public class Scopes 
{
	private int[][] han= {{9,12,5,15},{90,4,14,88,91,11},{89,55,11,34,76,4,5,54}};

	@Override
	public String toString() {
		return "Scopes [han[0]=" + Arrays.toString(han[0]) + "],[han[1]=" + Arrays.toString(han[1]) + "],[han[2]=" + Arrays.toString(han[2]) + "]";
	}
	
	void search(int data)
	{
		for(int row=0;row<han.length;row++)
		{
			for(int col=0;col<han[row].length;col++)
			{
				if(han[row][col]==data)
				{
					System.out.println(data+" matched @ row "+row+" col "+col);
					return;
				}
			}
		}
	}
	
	protected void update(int what)
	{
		for(int row=0;row<han.length;row++)
		{
			for(int col=0;col<han[row].length;col++)
			{
				if(han[row][col]<=what)
				{
					han[row][col]-=(han[row][col]*0.300);
				}
			}
		}
	}
	
	public final int[] subArray(int start,int end)
	{
		int[] tmp=new int[han[0].length+han[1].length+han[2].length];
		int index=0;
		for(int[] row:han)
		{
			for(int data:row)
			{
				tmp[index]=data;index++;
			}
		}
		System.out.println(Arrays.toString(tmp));
		int[] on= {};
		if(start>=0&&end<tmp.length-1)
		{
			on=new int[(end-start)+1];
			for(int each=0;each<on.length;each++)
			{
				on[each]=tmp[start];start++;
			}
		}
		return on;
	}
}
