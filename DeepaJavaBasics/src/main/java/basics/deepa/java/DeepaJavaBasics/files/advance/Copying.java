package basics.deepa.java.DeepaJavaBasics.files.advance;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Copying 
{
	public static void main(String[] args) throws IOException 
	{
		File src=new File("D:\\Course backups\\Java\\armstrong.doc");
		File dest=new File("D:\\Course backups\\Java\\Deepa\\hai.doc");
		//FileUtils.copyFileToDirectory(src, dest);
		FileUtils.copyFile(src, dest);
		System.out.println("File copied");
	}
}
