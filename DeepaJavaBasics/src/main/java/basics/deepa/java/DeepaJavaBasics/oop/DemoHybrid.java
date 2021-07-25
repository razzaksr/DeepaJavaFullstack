package basics.deepa.java.DeepaJavaBasics.oop;

import java.util.Arrays;

public class DemoHybrid
{
	public static void main(String[] args) 
	{
		BrandStore brand=new BrandStore();
		brand.setEmail("sabariragu@gmail.com");
		brand.setPass("sabari");
		brand.send("ZealousEBuddy");
		System.out.println(Arrays.toString(brand.getUpload()));
		System.out.println(Arrays.toString(brand.getAll()));
	}
}

class BrandStore extends PlayStore
{
	private String[] upload=new String[10];
	public String[] getUpload() {
		return upload;
	}
	public void setUpload(String[] upload) {
		this.upload = upload;
	}
	public void send(String name)
	{
		if(getEmail()!=null)
		{
			for(int pos=0;pos<upload.length;pos++)
			{
				if(upload[pos]==null||upload[pos]=="")
				{
					upload[pos]=name;
					int size=getAll().length;
					String news[]=new String[size+1];
					news=Arrays.copyOf(getAll(), getAll().length);
					news[getAll().length-1]=name;
					setAll(news);
					System.out.println(name+" has uploaded");
					break;
				}
			}
		}
		else {
			System.out.println("Login first");
		}
	}
}