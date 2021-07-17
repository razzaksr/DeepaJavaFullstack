package fullstack.java.desktop.DeepaJava.remote;

import java.util.Date;
import java.util.List;

import fullstack.java.desktop.DeepaJava.model.Notes;

public interface NotesOperations 
{
	public Notes save(Notes notes);
	public Notes findById(String title);
	public void delete(Notes notes);
	public void deleteById(String title);
	public void deleteMany(Date date);
	public List<Notes> findAll();
	public List<Notes> findAllByCreation(Date date);
}
