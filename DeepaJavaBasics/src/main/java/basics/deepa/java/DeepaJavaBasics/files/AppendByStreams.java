package basics.deepa.java.DeepaJavaBasics.files;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AppendByStreams 
{
	public static void main(String[] args) throws IOException 
	{
		File file=new File("D:\\Course backups\\Java\\palindrome.txt");
		FileInputStream fis=new FileInputStream(file);
		String tmp=new String(fis.readAllBytes());
		fis.close();
		
		FileOutputStream fos=new FileOutputStream(file);
		
		tmp+=new DataInputStream(System.in).readLine();
		
		fos.write(tmp.getBytes());
		
		fos.close();
		
		System.out.println(file.getName()+" contents are appended");
	}
}
