package basics.deepa.java.DeepaJavaBasics.files.advance;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Reading 
{
	public static void main(String[] args) throws IOException 
	{
		File file=new File("D:\\Course backups\\Javascript\\Manikandan\\Express\\ReactClientForRestCRUD\\client\\src\\API\\contact.js");
		String content=FileUtils.readFileToString(file);
		System.out.println(content);
	}
}
