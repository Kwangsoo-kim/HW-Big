package com.lec.ex;

public class Ex03 {
	public static void main(String[] args) {
		
		int num =5;
		System.out.println(num+"의 절대값은"+Arithmetic.abs(num)); // static을 쓴 객체
		Arithmetic ar = new Arithmetic(); // Arithmetic형 객체
		int sum = ar.sumhod(10,51);
		System.out.println("합은"+sum);
		System.out.println(ar.evenOdd(sum));
		System.out.println("***************************");
		
		sum = ar.sumhod(50);
		System.out.println("합은 : "+sum);
		System.out.println(ar.evenOdd(sum));
	}
}
