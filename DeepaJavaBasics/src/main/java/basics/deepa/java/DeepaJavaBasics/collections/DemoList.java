package basics.deepa.java.DeepaJavaBasics.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

/*
 * Vector/ArrayList:
 * 
 * add
 * add(pos,object)
 * 
 * set
 * 
 * get(pos)
 * 
 * remove(pos)
 * remove(object)
 * 
 * retainsAll
 * removeAll
 * 
 * Collections:
 * sort
 * reverse
 * max
 * min
 * replaceAll
 */

public class DemoList 
{
	public static void main(String[] args) 
	{
		Vector<String> list1=new Vector<String>();
		list1.add("Pratt");list1.add("Hiddleson");
		list1.add(0,"Holland");list1.add("Evans");list1.add("Rufallo");
		list1.add("Jhonson");list1.add(1,"Downey");
		System.out.println(list1);
		//list1.set(3,"Hemsworth");
		
		ArrayList<String> list2=new ArrayList<String>();
		list2.addAll(list1);
		list2.set(3,"Hemsworth");
		list1.remove(4);
		
		list1.remove("Jhonson");
		
		System.out.println("List One\n"+list1);
		System.out.println("List Two\n"+list2);
		
		list1.retainAll(list2);
		System.out.println("List One\n"+list1);
		
		list2.removeAll(list1);
		System.out.println("List Two\n"+list2);
		
		Collections.sort(list1);
		System.out.println("List One\n"+list1);
		Collections.reverse(list2);
		System.out.println("List Two\n"+list2);
		System.out.println(Collections.min(list1));
		
		list1.set(1, "Downey");
		
		Collections.replaceAll(list1, "Downey", "Robert");
		System.out.println("List One\n"+list1);
	}
}
