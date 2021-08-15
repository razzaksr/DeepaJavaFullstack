package basics.deepa.java.DeepaJavaBasics.collections;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Set;
import java.util.TreeMap;

/*
 * Map:
 * put(k,v)
 * putAll
 * 
 * get(k)
 * 
 * remove(k)
 * 
 * keySet
 * values
 * 
 * containsKey
 * containsValue
 * 
 */

public class DemoMap 
{
	public static void main(String[] args) 
	{
		Hashtable<String, Integer> series=new Hashtable<String, Integer>();
		series.put("IronMan1", 2008);series.put("CaptainAmerica", 2010);
		series.put("Thor", 2012);series.put("Avengers", 2012);
		series.put("Hulk", 2013);series.put("Far from home", 2018);
		series.put("Last Stand", 2007);
		
		System.out.println(series);
		
		TreeMap<String, Integer> list=new TreeMap<String, Integer>();
		list.putAll(series);
		
		System.out.println(list);
		
		list.remove("Thor");
		
		System.out.println(series.containsValue(2012));
		
		System.out.println(series.containsKey("Thor"));
		
		System.out.println(series.contains(2010));
		
		Set<String> keys=list.keySet();
		Collection<Integer> value=list.values();
		
		System.out.println(keys);
		System.out.println(value);
	}
}
