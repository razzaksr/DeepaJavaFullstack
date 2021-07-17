package fullstack.java.desktop.DeepaJava.model;

import java.io.Serializable;
import java.util.Date;

public class Notes implements Serializable
{
	private static Notes notes=new Notes();
	private String title;
	private String description;
	private Date doc;
	
	public static Notes getNotes()
	{
		return notes;
	}
	
	public Notes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notes(String title, String description, Date doc) {
		super();
		this.title = title;
		this.description = description;
		this.doc = doc;
	}
	@Override
	public String toString() {
		return "Notes [title=" + title + ", description=" + description + ", doc=" + doc + "]";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDoc() {
		return doc;
	}
	public void setDoc(Date doc) {
		this.doc = doc;
	}
}
