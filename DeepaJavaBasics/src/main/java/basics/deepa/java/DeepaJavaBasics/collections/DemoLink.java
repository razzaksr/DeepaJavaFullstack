package basics.deepa.java.DeepaJavaBasics.collections;

import java.util.LinkedList;
import java.util.ListIterator;

/*
 * LinkedList:
 * add/addLast
 * addAll
 * addFirst
 * add(pos,object)
 * 
 * remove/removeFirst
 * removeLast
 * remove(pos)
 * remove(object)
 * 
 * set(pos,object)
 * 
 * get(pos)
 * getFirst
 * getLast
 * 
 * indexOf(object)
 * clear
 */

public class DemoLink 
{
	public static void main(String[] args) 
	{
		LinkedList<Integer> hai=new LinkedList<Integer>();
		hai.add(19);hai.addLast(34);hai.add(90);
		System.out.println(hai);
		hai.addFirst(56);
		hai.add(2,78);
		System.out.println(hai);
		hai.set(1, 100);
		//System.out.println(hai);
		
		ListIterator<Integer> list=hai.listIterator();
		while(list.hasNext())
		{
			System.out.println(list.next());
		}
		
		hai.remove();//hai.removeFirst();
		hai.removeLast();
		hai.remove(1);
		System.out.println(hai.getFirst());
		System.out.println(hai.getLast());
		System.out.println(hai.get(1));
		System.out.println(hai);
		hai.remove((Object)100);
		System.out.println(hai);
		System.out.println(hai.indexOf(100));
	}
}
