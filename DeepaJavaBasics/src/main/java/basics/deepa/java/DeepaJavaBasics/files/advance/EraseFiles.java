package basics.deepa.java.DeepaJavaBasics.files.advance;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class EraseFiles 
{
	public static void main(String[] args) throws IOException 
	{
		/*
		 * File file=new File("D:\\Course backups\\Java\\Deepa\\hai.doc");
		 * FileUtils.forceDelete(file); System.out.println("file has deleted");
		 */
		
		/*
		 * File file=new File("D:\\Course backups\\Java\\Deepa");
		 * FileUtils.cleanDirectory(file);
		 * System.out.println("All files are removed @ "+file.getName());
		 */
		
		File file=new File("D:\\Course backups\\Java\\Deepa");
		FileUtils.deleteDirectory(file);
		System.out.println("Folder deleted");
	}
}
