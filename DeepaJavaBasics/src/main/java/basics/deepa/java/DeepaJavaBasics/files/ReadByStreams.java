package basics.deepa.java.DeepaJavaBasics.files;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadByStreams
{
	public static void main(String[] args) throws IOException 
	{
		File file=new File("D:\\Course backups\\Javascript\\Manikandan\\Express\\ReactClientForRestCRUD\\client\\src\\API\\contact.js");
		FileInputStream fis=new FileInputStream(file);
		
		//ByteArrayInputStream bis=new ByteArrayInputStream(fis.readAllBytes());
		
		
		
		System.out.println("The Content are:\n"+new String(fis.readAllBytes()));
		
		fis.close();
	}
}
