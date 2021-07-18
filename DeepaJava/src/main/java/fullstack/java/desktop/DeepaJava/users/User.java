package fullstack.java.desktop.DeepaJava.users;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable
{
	private String userName;
	private String passWord;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		/*
		 * try { FileOutputStream fos=new FileOutputStream(
		 * "C:\\Users\\ADMIN\\git\\DeepaJavaFullstack\\DeepaJava\\users.docx");
		 * ObjectOutputStream oos=new ObjectOutputStream(fos); List<User> hai=new
		 * ArrayList<User>(); hai.add(this); oos.writeObject(hai); } catch (IOException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", passWord=" + passWord + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
