package basics.deepa.java.DeepaJavaBasics.files;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Basics
{
	public static void main(String[] args) throws IOException 
	{
		File file=new File("D:\\Course backups\\Java\\Deepa.doc");
		//file.createNewFile();
		System.out.println(file.getAbsolutePath()+" has created");
		System.out.println("Tell us content to write: ");
		FileWriter writer=new FileWriter(file);
		//writer.write(new DataInputStream(System.in).readLine());
		writer.append(new DataInputStream(System.in).readLine());
		writer.flush();
		writer.close();
		System.out.println(file.getName()+" content has written");
	}
}
