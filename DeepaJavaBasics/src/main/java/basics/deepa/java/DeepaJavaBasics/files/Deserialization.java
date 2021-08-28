package basics.deepa.java.DeepaJavaBasics.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Deserialization 
{
	public static void main(String[] args) throws ClassNotFoundException, IOException 
	{
		File file=new File("D:\\Course backups\\Java\\properties.doc");
		FileInputStream fis=new FileInputStream(file);
		ObjectInputStream ois=new ObjectInputStream(fis);
		
		List<Car> list=new ArrayList<Car>();
		
		list=(List<Car>)ois.readObject();
		
		System.out.println(list.toString());
		
		ois.close();
		fis.close();
	}
}
