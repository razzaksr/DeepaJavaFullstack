package basics.deepa.java.DeepaJavaBasics.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PropertiesWriteByStream 
{
	public static void main(String[] args) throws IOException 
	{
		Car car1=new Car("Tiago NRG", "Tata", "Hatchback", 735100.4, 2021);
		Car car2=new Car("Tiago NRG", "Tata", "Hatchback", 735100.4, 2010);
		Car car3=new Car("Tiago NRG", "Tata", "Hatchback", 735100.4, 2019);
		Car car4=new Car("Tiago NRG", "Tata", "Hatchback", 735100.4, 2018);
		File file=new File("D:\\Course backups\\Java\\properties.doc");
		FileOutputStream fos=new FileOutputStream(file);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		
		List<Car> list=new ArrayList<Car>();
		list.add(car1);list.add(car2);list.add(car3);list.add(car4);
		
		oos.writeObject(list);
		
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
