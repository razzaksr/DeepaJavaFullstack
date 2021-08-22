package basics.deepa.java.DeepaJavaBasics.files;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadByReader 
{
	public static void main(String[] args) throws IOException 
	{
		File file=new File("D:\\Course backups\\Python\\Kasthuri\\Python\\multithread\\Behaviour.py");
		FileReader reader=new FileReader(file);
		int tmp;
		while((tmp=reader.read())!=-1)
		{
			System.out.print((char)tmp);
		}
		reader.close();
	}
}
