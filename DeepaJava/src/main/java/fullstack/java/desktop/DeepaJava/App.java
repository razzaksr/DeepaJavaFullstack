package fullstack.java.desktop.DeepaJava;

import java.util.Date;

import fullstack.java.desktop.DeepaJava.control.Controller;
import fullstack.java.desktop.DeepaJava.model.Notes;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		
		/*
		 * Notes note1=Notes.getNotes();//new Notes();
		 * note1.setTitle("Laptop");note1.setDescription("Hr/Dell gaming laptop");
		 * note1.setDoc(new Date(2020,10,3));
		 * 
		 * Notes note2=new Notes("Full stack", "Java", new Date(2015,6,2));
		 * 
		 * 
		 * Notes note3=new Notes("bike", "bmw, avenger", new Date(2016,2,26)); Notes
		 * note4=new Notes("scooter", "ola", new Date(2022,1,15)); Notes note5=new
		 * Notes("car", "thar", new Date(2025,9,11));
		 */
		 
        
        Controller control=new Controller();
        //control.save(note1);control.save(note2);control.save(note3);control.save(note4);control.save(note5);
        System.out.println(control.findAll());
        System.out.println(control.findAllByCreation(new Date(2017,1,15)));
    }
}
