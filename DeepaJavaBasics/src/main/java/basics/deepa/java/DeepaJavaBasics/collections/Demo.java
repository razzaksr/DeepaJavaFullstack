package basics.deepa.java.DeepaJavaBasics.collections;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* LIFO:
 * push
 * pop
 * peek
 * search
 * clear
 */

public class Demo 
{
	public static void main(String[] args) 
	{
		Stack exe=new Stack();
		exe.push("Razak Mohamed");
		exe.push(12);exe.push(9.1);exe.push(false);exe.push('R');exe.push(6543456789L);
		exe.push(45.9);
		
		System.out.println(exe.peek());
		
		System.out.println("Deleted object is "+exe.pop());
		
		System.out.println(exe);
		
		System.out.println(exe.search(45.9));
		System.out.println(exe.isEmpty());
		
		System.out.println(exe.search(9.1));
		
		List obj=new Stack();
		obj.addAll(exe);
		obj.add("Razak");
		System.out.println(obj);
		
		Iterator<Object> it=obj.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}
