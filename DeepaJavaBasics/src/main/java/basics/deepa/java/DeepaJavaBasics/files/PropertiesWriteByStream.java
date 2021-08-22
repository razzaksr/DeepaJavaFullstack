package basics.deepa.java.DeepaJavaBasics.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PropertiesWriteByStream 
{
	public static void main(String[] args) throws IOException 
	{
		Car car=new Car("Tiago NRG", "Tata", "Hatchback", 735100.4, 2021);
		File file=new File("D:\\Course backups\\Java\\properties.doc");
		FileOutputStream fos=new FileOutputStream(file);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		
		oos.writeObject(car);
		
		/*
		fos.write(car.getModel().getBytes());
		fos.write(car.getBrand().getBytes());
		fos.write(car.getType().getBytes());
		fos.write(car.getPrice().toString().getBytes());
		fos.write(car.getRelease().toString().getBytes());
		*/
		
		oos.close();
		fos.close();
		
		System.out.println("Object properties are done");
	}
}
