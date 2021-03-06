package basics.deepa.java.DeepaJavaBasics;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDemo 
{
	public void demoValue(String check)
	{
		System.out.println("Idol in demo valus is: "+check);
		check="Almighty";
		System.out.println("Idol in demo valus is: "+check);
	}
	public void demoValue(int[] ind)
	{
		System.out.println("value @ 3rd "+ind[3]);
		ind[3]-=(ind[3]*0.080);
		System.out.println("value @ 3rd "+ind[3]);
	}
	public static void main(String[] args) 
	{
		ArrayDemo demo=new ArrayDemo();
		/*
		 * 
		 * 
		 * String idol="Dad"; demo.demoValue(idol);
		 * System.out.println("Idol in main: "+idol);
		 * 
		 * int[] hey= {2,89,0,23,12,89,11}; demo.demoValue(hey);
		 * System.out.println(hey[3]+" in main");
		 * int[] hey= {2,12,23,29,89,99};
		 */
		
		String[] yet=new String[10];
		/*
		 * demo.initialize(yet);// O(1) demo.list(yet);// O(n)
		 * System.out.println(demo.linear(yet, "Education"));//O(n) demo.update(yet, 10,
		 * "Industry");// O(1) System.out.println(demo.lineaRecur(yet, "Employment",
		 * 0));// O(n) //Arrays.sort(yet);// O(1) demo.selectionSort(yet);
		 * System.out.println("After sorting"); demo.list(yet);
		 * System.out.println(demo.binary(yet, "Industry", 0, yet.length-1));// O(logn)
		 */		
		
		Double[][] hai={{2.3,0.1,8.9,2.0,1.9},{89.2,78.2,1.2,9.1,12.6,23.9}};//new Double[2][5];
		//Arrays.sort(hai[0]);Arrays.sort(hai[1]);
		demo.sortQuick(hai[0], 0, hai[0].length-1);
		demo.sortQuick(hai[1], 0, hai[1].length-1);
		
		System.out.println(Arrays.toString(hai[0]));
		System.out.println(Arrays.toString(hai[1]));
		
		System.out.println(demo.binary(hai, 2.0, 0, 0, hai[1].length-1));
		
		/*
		 * Character[][] blocks=new Character[2][]; demo.initialize(blocks);
		 * demo.list(blocks); //Arrays.sort(blocks[0]); //Arrays.sort(blocks[1]);
		 * demo.selectionSort(blocks); demo.list(blocks);
		 * System.out.println(demo.binary(blocks, 'X', 1, 0, blocks[1].length-1));
		 */
	}
	
	public int quick(Double[] one,int start,int end)
	{
		Double pivotalData=one[end];
		int initial=start-1;
		
		for(int index=start;index<end;index++)
		{
			if(one[index].compareTo(pivotalData)<0)
			{
				initial++;
				Double third=one[initial];
				one[initial]=one[index];
				one[index]=third;
			}
		}
		
		Double tmp=one[end];
		one[end]=one[initial+1];
		one[initial+1]=tmp;
		
		return initial+1;
	}
	
	public void sortQuick(Double[] each,int start,int end)
	{
		if(start<end)
		{
			int pivotPoint=quick(each,start,end);
			quick(each,start,pivotPoint-1);
			quick(each,pivotPoint+1,end);
		}
	}
	
	Scanner scan=new Scanner(System.in);
	
	
	
	public int binary(Double[][] wind,Double data,int row,int start,int end)
	{
		int mid=(start+end)/2;
		if(wind[row][mid].compareTo(data)==0)
			return mid;
		else if(wind[row][mid].compareTo(data)>0)
			return binary(wind, data, row, start, mid);
		else if(wind[row][mid].compareTo(data)<0)
			return binary(wind, data, row, mid+1, end);
		else
			return -1;
	}
	
	public void selectionSort(Character[][] wind)
	{
		for(int row=0;row<wind.length;row++)
		{
			for(int select=0;select<wind[row].length;select++)
			{
				for(int compare=select+1;compare<wind[row].length;compare++)
				{
					if(wind[row][select]>wind[row][compare])
					{
						wind[row][select]=(char)(wind[row][select]^wind[row][compare]);
						wind[row][compare]=(char)(wind[row][select]^wind[row][compare]);
						wind[row][select]=(char)(wind[row][select]^wind[row][compare]);
					}
				}
			}
		}
	}
	
	public int binary(Character[][] wind,Character data,int row,int start,int end)
	{
		int mid=(start+end)/2;
		if(wind[row][mid]==data)
			return mid;
		else if(wind[row][mid]>data)
			return binary(wind, data, row, start, mid);
		else if(wind[row][mid]<data)
			return binary(wind, data, row, mid+1, end);
		else
			return -1;
	}
	
	public void initialize(Character[][] oil)
	{
		oil[0]=new Character[] {'W','!','5','E'};
		oil[1]=new Character[] {'X','Q'};
		
		/*
		 * for(int row=0;row<oil.length;row++) {
		 * System.out.println("Tell us count for "+row+" row"); oil[row]=new
		 * Character[scan.nextInt()]; for(int pos=0;pos<oil[row].length;pos++) {
		 * System.out.println("Tell us character for "+pos+" @ row "+row);
		 * oil[row][pos]=scan.next().charAt(0); } }
		 */
	}
	
	public void list(Character[][] focus)
	{
		for(Character[] row:focus)
		{
			for(Character data:row)
			{
				System.out.print(data+" ");
			}
			System.out.println();
		}
	}
	
	public void selectionSort(String[] wind)
	{
		String third="";
		for(int select=0;select<wind.length;select++)
		{
			for(int compare=select+1;compare<wind.length;compare++)
			{
				if(wind[select].compareTo(wind[compare])>0)
				{
					third=wind[select];
					wind[select]=wind[compare];
					wind[compare]=third;
				}
			}
		}
	}
	
	public int binary(String[] which,String data,int start,int end)
	{
		int mid=(start+end)/2;
		if(which[mid].compareTo(data)==0)
			return mid;
		else if(data.compareTo(which[mid])>0)
			return binary(which, data, mid+1, end);
		else if(data.compareTo(which[mid])<0)
			return binary(which, data, start, mid);
		else
			return -1;
	}
	
	public int linear(String[] iden,String data)
	{
		for(int index=0;index<iden.length;index++)
		{
			if(data.equals(iden[index]))
			{
				return index;
			}
		}
		return -1;
	}
	public int lineaRecur(String[] iden,String data,int start)
	{
		if(start>=iden.length)
			return -1;
		else
		{
			if(iden[start].equals(data))
			{
				return start;
			}
			else {
				start++;
				return lineaRecur(iden, data,start);
			}
		}
	}
	public void update(String[] which,int pos,String data)
	{
		if(pos<=which.length)
		{
			which[pos-1]=data;
			System.out.println("Data has updated");
		}
		else {
			System.out.println("Can't update");
		}
	}
	public void initialize(String[] un)
	{
		un[0]="Language";un[2]="Education";un[4]="Forest";un[6]="Food";un[8]="Medicine";
		un[1]="Culture";un[3]="Water";un[5]="Nature";un[7]="Sports";un[9]="Employment";
		/*
		 * for(int index=0;index<un.length;index++) {
		 * System.out.println("Tell us data: "); un[index]=scan.next(); }
		 */
	}
	public void list(String[] focus)
	{
		for(String t:focus) 
		{
			System.out.println(t);
		}
	}
}
