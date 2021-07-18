package fullstack.java.desktop.DeepaJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Scanner;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

import fullstack.java.desktop.DeepaJava.control.Controller;
import fullstack.java.desktop.DeepaJava.model.Notes;
import fullstack.java.desktop.DeepaJava.users.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, ClassNotFoundException
    {
    	File file=new File("hello.zip");
    	FileOutputStream fos=new FileOutputStream(file);
    	DeflaterOutputStream dos=new DeflaterOutputStream(fos);
    	ObjectOutputStream oos=new ObjectOutputStream(dos);
    	
    	User user=new User("Razak Mohamed", "Shahul hameed");
    	
    	//dos.write(new String("Welcome to zealous").getBytes());
    	
    	oos.writeObject(user);
    	
    	oos.close();dos.close();fos.close();
    	
    	
    	FileInputStream fis=new FileInputStream(file);
    	InflaterInputStream iis=new InflaterInputStream(fis);
    	ObjectInputStream ois=new ObjectInputStream(iis);
    	
    	//byte[] tmp=new byte[fis.available()];
    	//System.out.println(new String(tmp));
    	
    	//iis.read(tmp);
    	
    	User newOne=(User)ois.readObject();
    	ois.close();iis.close();fis.close();
    	System.out.println(newOne);
    	
    	
    	
    	
		/*
		 * Scanner scan=new Scanner(System.in); boolean proceed=false;
		 * System.out.println(":Welcome to Zealous Note:"); Controller control=new
		 * Controller(scan.next(), scan.next()); do {
		 * System.out.println("Select an option: "); String option=scan.next();
		 * switch(option) { case "newnote":control.save(new Notes(scan.next(),
		 * scan.next(), new Date(scan.next())));break; case
		 * "show":System.out.println(control.findAll());break; }
		 * System.out.println("Do you wish to proceed?"); proceed=scan.nextBoolean();
		 * }while(proceed);
		 */
    }
}
