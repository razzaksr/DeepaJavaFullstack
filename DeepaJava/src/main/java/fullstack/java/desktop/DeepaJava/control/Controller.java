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
import java.util.Scanner;

import fullstack.java.desktop.DeepaJava.model.Notes;
import fullstack.java.desktop.DeepaJava.remote.NotesOperations;
import fullstack.java.desktop.DeepaJava.users.User;

public class Controller implements NotesOperations
{
	static Boolean auth=false;
	File file;
	User user=null;
	FileOutputStream fos;
	ObjectOutputStream oos;
	FileInputStream fis;
	ObjectInputStream ois;
	Scanner scan=new Scanner(System.in);
	List<Notes> tmp=new ArrayList<Notes>();
	List<Notes> bin=new ArrayList<Notes>();
	public Controller(String user,String pass) 
	{
		List<User> list =null;
		
		/*
		 * try { file.createNewFile(); } catch (IOException e) { e.printStackTrace(); }
		 */
		try {
			System.out.println("received "+user+" "+pass);
			fis=new FileInputStream("C:\\Users\\ADMIN\\git\\DeepaJavaFullstack\\DeepaJava\\users.docx");
			ois=new ObjectInputStream(fis);
		list = (List<User>) ois.readObject();
		System.out.println("file extracted");
		for(User t:list)
		{
			if(t.getUserName().equals(user)&&t.getPassWord().equals(pass))
			{
				auth=true;
				this.user=t;
				file = new File("C:\\Users\\ADMIN\\git\\DeepaJavaFullstack\\DeepaJava\\"+user+".doc");
				System.out.println("Authorised");
			}
		}
		ois.close();fis.close();
		this.user=null;
		System.out.println("User note match");
		if(!auth) 
		{
			System.out.println("Do you wish to create");
			boolean b=scan.nextBoolean();
			if(b) 
			{
				User useNew=new User(scan.next(),scan.next());
				list.add(useNew);
				fos=new FileOutputStream("C:\\Users\\ADMIN\\git\\DeepaJavaFullstack\\DeepaJava\\users.docx");
				oos=new ObjectOutputStream(fos);
				oos.writeObject(list);
				oos.close();fos.close();
				System.out.println("New user created");
				file = new File("C:\\Users\\ADMIN\\git\\DeepaJavaFullstack\\DeepaJava\\"+user+".doc");
				file.createNewFile();
				new Controller(scan.next(),scan.next());
			}
		}
		}
		catch(IOException i) {}
		catch(ClassNotFoundException not) {}
	}
	
	public void restore()
	{
		if(auth) {
			List<Notes> hai=findAll();
			for(Notes note:bin)
			{
				System.out.println(note);
				System.out.println("Tell us do you wish to restore: ");
				boolean confirm=scan.nextBoolean();
				if(confirm)
				{
					hai.add(note);
				}
			}
			try {
				fos=new FileOutputStream(file);
				oos=new ObjectOutputStream(fos);
				oos.writeObject(hai);
				System.out.println("Object's restored");
				fos.close();
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Login First");
		}
	}
	
	@Override
	public Notes save(Notes notes) 
	{
		if(auth)
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
		else
		{
			System.out.println("Login first");
			return null;
		}
	}
	@Override
	public Notes findById(String title) {
		// TODO Auto-generated method stub
		if(auth)
		{
			List<Notes> obj=null;
			try {
				fis=new FileInputStream(file);
				ois=new ObjectInputStream(fis);
				
				obj = (List<Notes>)ois.readObject();
				fis.close();ois.close();
				
				for(Notes t:obj)
				{
					if(t.getTitle().equalsIgnoreCase(title))
					{
						return t;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new Notes();
		}
		else
		{
			System.out.println("Login first");
			return null;
		}
	}
	@Override
	public void delete(Notes notes) {
		// TODO Auto-generated method stub
		if(auth)
		{
			Notes note=null;
			List<Notes> obj=null;
			try {
				fis=new FileInputStream(file);
				ois=new ObjectInputStream(fis);
				
				obj = (List<Notes>)ois.readObject();
				fis.close();ois.close();
				
				for(Notes t:obj)
				{
					 if(t.getTitle().equals(notes.getTitle())&&t.getDescription().equals(notes.
					 getDescription())&& t.getDoc().getDate()==notes.getDoc().getDate()) 
					 {
						 note=t;
					 } 
				}
				
				if(note!=null) {
					bin.add(note);
					obj.remove(note);
					System.out.println("Moved to Bin");
				}
				
				
					fos=new FileOutputStream(file);
					oos=new ObjectOutputStream(fos);
					oos.writeObject(obj);
					System.out.println("Object written");
					fos.close();
					oos.close();
					System.out.println("Object deleted");
				
				
				
				 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Login first");
		}
	}
	@Override
	public void deleteById(String title) {
		// TODO Auto-generated method stub
		if(auth)
		{
			Notes note=null;
			List<Notes> obj=null;
			try {
				fis=new FileInputStream(file);
				ois=new ObjectInputStream(fis);
				
				obj = (List<Notes>)ois.readObject();
				fis.close();ois.close();
				
				for(Notes t:obj)
				{
					 if(t.getTitle().equals(title)) 
					 {
						 note=t;
					 } 
				}
				
				if(note!=null) {
					bin.add(note);
					obj.remove(note);
					System.out.println("Moved to bin");
				}
				
				
					fos=new FileOutputStream(file);
					oos=new ObjectOutputStream(fos);
					oos.writeObject(obj);
					System.out.println("Object written");
					fos.close();
					oos.close();
					System.out.println("Object deleted");
				 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Login first");
		}
	}
	@Override
	public void deleteMany(Date date) {
		// TODO Auto-generated method stub
		if(auth)
		{
			List<Notes> obj=null;
			List<Notes> objs=new ArrayList<Notes>();
			try {
				fis=new FileInputStream(file);
				ois=new ObjectInputStream(fis);
				
				obj = (List<Notes>)ois.readObject();
				fis.close();ois.close();
				
				for(Notes t:obj)
				{
					if(t.getDoc().compareTo(date)==0)
					{
						objs.add(t);
					}
				}
				
				bin.addAll(objs);
				obj.removeAll(objs);
				System.out.println("Objects are moved to bin");
				
				fos=new FileOutputStream(file);
				oos=new ObjectOutputStream(fos);
				oos.writeObject(obj);
				System.out.println("Object written");
				fos.close();
				oos.close();
				System.out.println("Object's are deleted");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Login first");
		}
	}
	@Override
	public List<Notes> findAll() {
		// TODO Auto-generated method stub
		if(auth)
		{
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
		else {
			System.out.println("Login first");
			return null;
		}
	}
	@Override
	public List<Notes> findAllByCreation(Date date) {
		// TODO Auto-generated method stub
		if(auth)
		{
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
		else
		{
			System.out.println("Login first");
			return null;
		}
	}
}
