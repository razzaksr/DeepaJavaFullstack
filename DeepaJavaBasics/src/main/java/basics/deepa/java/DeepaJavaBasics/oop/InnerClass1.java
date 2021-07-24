package basics.deepa.java.DeepaJavaBasics.oop;

import java.util.Arrays;

import basics.deepa.java.DeepaJavaBasics.oop.Warehouse.Security;

public class InnerClass1 
{
	public static void main(String[] args) 
	{
		Warehouse house=new Warehouse();
		Security sec=house.new Security();
		sec.list();
		sec.copy(2);
		Warehouse.reverse();
	}
}

class Warehouse
{
	String[][] yet= {
			{"VLC player","PUBG","TempleRun"},
			{"Free fire"},
			{"Whatsapp","Instagram","Facebook","LinkedIn"},
			{"MS Office","WPS Office"}
			};
	
	public static void reverse()
	{
		for(String[] row:new Warehouse().yet)
		{
			Arrays.sort(row);
			System.out.println(Arrays.toString(row));
		}
	}
	
	class Security
	{
		String[] monitor= {};
		public void list()
		{
			for(String[] row:yet)
			{
				for(String data:row)
				{
					System.out.println(data);
				}
			}
		}
		public void copy(int row)
		{
			monitor=yet[row];
			System.out.println(Arrays.toString(monitor));
		}
	}
}