package org.wotsoc.tamilthoundu.jdbc;

public class DynamicProgramming {
	
	public int fibno(int n) {
		System.out.println("n="+n);
		if(n<=1)  
			return n;
		else
			return fibno(n-1) + fibno(n-2);
	}
	
	public int fibnoDP(int size) {
		int fib[] = new int[size + 1]; //Handle 0, 1
		int index;
		fib[0] = 0;
		fib[1] = 1;		
		for(index =2; index<=size;index++)
			fib[index] = fib[index-1] + fib[index-2];
		return fib[size];
	}
	
	public static void main(String args[]) {
		DynamicProgramming dp = new DynamicProgramming();
		System.out.println(dp.fibno(5));
		System.out.println("**********");
		System.out.println(dp.fibnoDP(5));
	}
}
