package basics.deepa.java.DeepaJavaBasics.exceptions;

import java.io.IOException;
import java.util.Scanner;

public class Prompt 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		Scanner scan=new Scanner(System.in);
		Runtime run=Runtime.getRuntime();
		System.out.println("Tell us what you wish to open: ");
		Process pro=run.exec(scan.next());
		Thread.sleep(2000);
		System.out.println("Tell us what you wish to open: ");
		pro=run.exec(scan.next());
		Thread.sleep(2000);
		System.out.println("Tell us what you wish to open: ");
		pro=run.exec(scan.next());
	}
}
