package com.apitesting;

public class SampleClass {
   
	void add()
	{    
		int a,b;
	    a=10000;
	    b=3000;
		int c=a+b;
		System.out.println(c);
	}
	public static void main(String[] args) {
		
		SampleClass obj=new SampleClass();
		obj.add();
	}

}
