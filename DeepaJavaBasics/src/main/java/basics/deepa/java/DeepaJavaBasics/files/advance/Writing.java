package basics.deepa.java.DeepaJavaBasics.files.advance;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class Writing 
{
	public static void main(String[] args) throws IOException 
	{
		File file=new File("D:\\Course backups\\Java\\armstrong.doc");
		System.out.println("Tell us what you swish to write:");
		FileUtils.writeStringToFile(file, new Scanner(System.in).nextLine(),true);
		System.out.println(file.getName()+" affected");
	}
}
