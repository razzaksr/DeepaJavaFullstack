package basics.deepa.java.DeepaJavaBasics.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialization 
{
	public static void main(String[] args) throws ClassNotFoundException, IOException 
	{
		File file=new File("D:\\Course backups\\Java\\properties.doc");
		FileInputStream fis=new FileInputStream(file);
		ObjectInputStream ois=new ObjectInputStream(fis);
		
		Car tmp=(Car)ois.readObject();
		
		System.out.println(tmp);
		
		ois.close();
		fis.close();
	}
}
