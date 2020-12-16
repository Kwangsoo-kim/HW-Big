//201216 kks exception
package com.lec.ex1_tryCatch;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i;
		int j;
		System.out.println("첫 번째 수는 ?");
		i = sc.nextInt();
		System.out.println("두 번째 수는 ?");
		j = sc.nextInt();
		System.out.println("i = "+i+", j= "+j);
		System.out.println("i * j = "+(i*j));
		try {
			System.out.println("i / j = "+(i/j));
		}catch(java.lang.ArithmeticException e) {
			e.printStackTrace(); // 예외사항을 자세히 출력 
			//System.out.println(e.getMessage()); // 예외메시지만 출력
		}
		System.out.println("i + j = "+(i+j));
		System.out.println("i - j = "+(i-j));
		System.out.println("DONE");
		sc.close();
	}
}
