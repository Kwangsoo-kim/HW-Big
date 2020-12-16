//201216 kks exceptions 
package com.lec.ex3_exceptionExs;

public class Ex01_nullpoint {
	public static void main(String[] args) {
		String greeting = "Hello";
		System.out.println(greeting.toUpperCase());
		greeting = null;
		System.out.println(greeting.toUpperCase());
	}
}
