package basics.deepa.java.DeepaJavaBasics.oop;

import java.util.Arrays;
import java.util.Scanner;

public class DemoSingle 
{
	public static void main(String[] args) 
	{
		Youtube you=new Youtube();
		you.show();
		you.setEmail("razzaksr@gmail.com");you.setPass("12345678");
		you.show();
		you.addVideo("Kids rhymes");you.addVideo("Geographic");you.addVideo("Boxing");
		you.addVideo("Goa");you.addVideo("Pop");
		you.show();
		System.out.println(you.info());
		Youtube you2=new Youtube("razaksrmd@gmail.com","987654321");
		you2.show();you2.addVideo("Eifel tower");you2.addVideo("Jallikattu");you2.addVideo("Mars");
		you2.addVideo("Solar system");
		you2.show();
		System.out.println(you2.info());
	}
}

class Youtube extends Google
{
	private Scanner sca=new Scanner(System.in);
	public String info()
	{
		return super.info() + Arrays.toString(lib);
	}
	public Youtube() 
	{
		System.out.println("Youtube initialization");
		if(lib.length==0)
		{
			System.out.println("Initialize your wishlist size");
			lib=new String[sca.nextInt()];
		}
	}
	public Youtube(String a,String b)
	{
		setEmail(a);setPass(b);
		if(lib.length==0)
		{
			System.out.println("Initialize your wishlist size");
			lib=new String[sca.nextInt()];
		}
	}
	//private String[] lib= {"enemy trailer","ilayaraj songs","rahman songs","zealous","boxing"};
	private String[] lib= {};
	
	public void addVideo(String yet)
	{
		for(int pos=0;pos<lib.length;pos++)
		{
			if(lib[pos]==null||lib[pos]=="")
			{
				lib[pos]=yet;
				System.out.println(yet+" added to wishlist");
				break;
			}
		}
	}
	
	public void show()
	{
		if(getEmail()!=null)
		{
			System.out.println(Arrays.toString(lib)+"\navailable in "+getEmail()+" account");
		}
		else {System.out.println("Login first");}
	}
}

class Google
{
	public Google() {System.out.println("Google initialization");}
	private String email;
	private String pass;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String info()
	{
		return email;
	}
}