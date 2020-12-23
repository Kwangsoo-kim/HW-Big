package com.lec.question;

import java.util.Scanner;

public class Q3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	  System.out.print("첫번째 정수를 입력하세요");
      int a = sc.nextInt();
      System.out.print("두번째 정수를 입력하세요");
      int b = sc.nextInt();
	 System.out.println("두 수가 같은가?"+(a==b ? "o" : "x"));
	 System.out.println("첫번째 수가 두번재 수보다 큰가?"+(a>b ? "o" : "x"));	 
	 
	 
	 
	 
	 
	 sc.close();
		
	}

}
