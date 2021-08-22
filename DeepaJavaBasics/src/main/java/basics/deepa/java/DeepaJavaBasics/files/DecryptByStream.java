package basics.deepa.java.DeepaJavaBasics.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.InflaterInputStream;

public class DecryptByStream 
{
	public static void main(String[] args) throws IOException 
	{
		File file=new File("D:\\Course backups\\Java\\properties.zip");
		FileInputStream fis=new FileInputStream(file);
		InflaterInputStream iis=new InflaterInputStream(fis);
		
		byte[] tmp=new byte[fis.available()];
		iis.read(tmp);
		
		System.out.println(new String(tmp));
		
		iis.close();
		fis.close();
	}
}
