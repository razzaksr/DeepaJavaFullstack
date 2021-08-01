package basics.deepa.java.DeepaJavaBasics;

import java.util.Arrays;

import basics.deepa.java.DeepaJavaBasics.oop.Scopes;

public class DemoAccessModifiers extends Scopes
{
	public String toString()
	{
		return "Derived object "+super.toString();
	}

	/*
	 * public int[] subArray(int start,int end) { return new int[] {1,2,3,4}; }
	 */
	public static void main(String[] args) 
	{
		DemoAccessModifiers scope=new DemoAccessModifiers();
		System.out.println(scope);
		System.out.println(Arrays.toString(scope.subArray(4, 13)));
		//scope.search(88);
		scope.update(50);
		System.out.println(scope);
		
	}
}
