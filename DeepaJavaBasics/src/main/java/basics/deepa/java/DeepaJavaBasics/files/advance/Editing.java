package basics.deepa.java.DeepaJavaBasics.files.advance;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class Editing 
{
	public static void main(String[] args) throws IOException 
	{
		Scanner scan=new Scanner(System.in);
		File file=new File("D:\\Course backups\\Java\\Term.java");
		List<String> lines = FileUtils.readLines(file);
		System.out.println("Tell us which line to edit: ");
		int line=scan.nextInt();
		System.out.println("Tell us which word u wish to edit");
		String word=scan.next();
		
		if(lines.get(line).contains(word))
		{
			System.out.println("Tell us what u wish to replace: ");
			String replace=scan.next();
			lines.set(line, lines.get(line).replace(word, replace));
		}
		System.out.println(lines);
		FileUtils.writeLines(file, lines);
		System.out.println("Editing done");
	}
}
