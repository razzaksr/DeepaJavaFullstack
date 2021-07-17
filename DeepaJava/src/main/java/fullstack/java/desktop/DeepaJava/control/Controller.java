package fullstack.java.desktop.DeepaJava.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fullstack.java.desktop.DeepaJava.model.Notes;
import fullstack.java.desktop.DeepaJava.remote.NotesOperations;

public class Controller implements NotesOperations
{
	File file;
	FileOutputStream fos;
	ObjectOutputStream oos;
	FileInputStream fis;
	ObjectInputStream ois;
	
	List<Notes> tmp=new ArrayList<Notes>();
	public Controller() 
	{
		file = new File("Zealous.doc");/*
										 * try { file.createNewFile(); } catch (IOException e) { // TODO Auto-generated
										 * catch block e.printStackTrace(); }
										 */
	}
	@Override
	public Notes save(Notes notes) 
	{
		// TODO Auto-generated method stub
		tmp=findAll();
		tmp.add(notes);
		try {
			fos=new FileOutputStream(file);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(tmp);
			System.out.println("Object written");
			fos.close();
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notes;
	}
	@Override
	public Notes findById(String title) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(Notes notes) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteById(String title) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteMany(Date date) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Notes> findAll() {
		// TODO Auto-generated method stub
		List<Notes> obj=new ArrayList<Notes>();
		try {
			fis=new FileInputStream(file);
			ois=new ObjectInputStream(fis);
			
			obj = (List<Notes>)ois.readObject();
			
			fis.close();ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	@Override
	public List<Notes> findAllByCreation(Date date) {
		// TODO Auto-generated method stub
		List<Notes> obj=null;
		List<Notes> objs=new ArrayList<Notes>();
		try {
			fis=new FileInputStream(file);
			ois=new ObjectInputStream(fis);
			
			obj = (List<Notes>)ois.readObject();
			fis.close();ois.close();
			
			for(Notes t:obj)
			{
				if(t.getDoc().before(date))
				{
					objs.add(t);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objs;
	}
}
