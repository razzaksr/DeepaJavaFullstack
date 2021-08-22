package basics.deepa.java.DeepaJavaBasics.files;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteByStreams 
{
	public static void main(String[] args) throws IOException 
	{
		File file=new File("D:\\Course backups\\Java\\palindrome.txt");
		FileOutputStream fos=new FileOutputStream(file);
		
		String hello=new DataInputStream(System.in).readLine();
		
		fos.write(hello.getBytes());
		
		fos.close();
		
		System.out.println("Content written "+file.getName());
	}
}
