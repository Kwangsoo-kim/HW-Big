package com.lec.ex;

public class Ex03 {
	public static void main(String[] args) {
		
		int num =5;
		System.out.println(num+"�� ���밪��"+Arithmetic.abs(num)); // static�� �� ��ü
		Arithmetic ar = new Arithmetic(); // Arithmetic�� ��ü
		int sum = ar.sumhod(10,51);
		System.out.println("����"+sum);
		System.out.println(ar.evenOdd(sum));
		System.out.println("***************************");
		
		sum = ar.sumhod(50);
		System.out.println("���� : "+sum);
		System.out.println(ar.evenOdd(sum));
	}
}
