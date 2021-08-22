package basics.deepa.java.DeepaJavaBasics.files.advance;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CutPaste 
{
	public static void main(String[] args) throws IOException 
	{
		//File src=new File("D:\\Course backups\\Java\\Deepa.doc");
		//File src=new File("D:\\Course backups\\Java\\palindrome.txt");
		//File dest=new File("D:\\Course backups\\Java\\Deepa");
		//File dest=new File("D:\\Course backups\\Java\\Deepa\\palin.txt");
		//FileUtils.moveFileToDirectory(src, dest, true);
		//FileUtils.moveFile(src, dest);
		//System.out.println("File moved");
		
		// rename
		File src=new File("D:\\Course backups\\Java\\properties.doc");
		File dest=new File("D:\\Course backups\\Java\\props.doc");
		FileUtils.moveFile(src, dest);
		System.out.println("Renamed");
	}
}
