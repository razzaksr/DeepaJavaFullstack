package basics.deepa.java.DeepaJavaBasics.collections;

import java.util.HashSet;
import java.util.TreeSet;

public class DemoSet 
{
	public static void main(String[] args) 
	{
		HashSet<Character> set1=new HashSet<Character>();
		TreeSet<Character> set2=new TreeSet<Character>();
		set1.add('R');set1.add('$');set1.add('9');set1.add('&');
		set1.add(',');set1.add('|');set1.add('{');set1.add('[');
		set1.add('=');set1.add(')');set1.add('#');set1.add('*');
		
		set2.addAll(set1);
		
		System.out.println("Set 1\n"+set1);
		System.out.println("Set 2\n"+set2);
		
		set2.remove('{');
		set1.remove('$');
		set1.add('|');
		System.out.println("Set 1\n"+set1);
		System.out.println("Set 2\n"+set2);
		
		System.out.println(set1.contains('$'));
		
	}
}
