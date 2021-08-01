package basics.deepa.java.DeepaJavaBasics.oop;

import java.util.Arrays;

public class DemoModifiers 
{
	public static void main(String[] args) 
	{
		Scopes scope=new Scopes();
		System.out.println(scope);
		System.out.println(Arrays.toString(scope.subArray(4, 13)));
		scope.search(88);
		scope.update(50);
		System.out.println(scope);
		
	}
}
