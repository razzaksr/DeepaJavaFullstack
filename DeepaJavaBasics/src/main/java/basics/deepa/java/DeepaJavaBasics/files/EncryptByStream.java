package basics.deepa.java.DeepaJavaBasics.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;

public class EncryptByStream 
{
	public static void main(String[] args) throws IOException 
	{
		Car car=new Car("Tiago NRG", "Tata", "Hatchback", 735100.4, 2021);
		File file=new File("D:\\Course backups\\Java\\properties.zip");
		FileOutputStream fos=new FileOutputStream(file);
		DeflaterOutputStream dos=new DeflaterOutputStream(fos);
		
		dos.write(car.getModel().getBytes());
		dos.write(car.getBrand().getBytes());
		dos.write(car.getType().getBytes());
		dos.write(car.getPrice().toString().getBytes());
		dos.write(car.getRelease().toString().getBytes());
		
		dos.close();
		fos.close();
	}
}
