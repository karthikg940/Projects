package com.virtusa.lilly;

public class Demo {
	
	public static void main(String args[])
	{
		new1();
	}
		
		public static void new1()
		{
		int i=5;
		try
		{
			i=i/0;
		}
		catch(ArithmeticException e)
		{
			System.out.println("/ by zero not allowed");
		}
		}
	
		}
