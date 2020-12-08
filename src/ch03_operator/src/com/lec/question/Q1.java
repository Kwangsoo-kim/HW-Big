package com.lec.question;

import java.util.Scanner;

public class Q1 {
	public static void main(String[] args) {
		//String name = "hong"; // new String("hong") 이 원래 값인데 String만 예외다.
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하시오 : ");
		int i = sc.nextInt();
		System.out.println(i%3==0 ? "3의 배수입니다" :"3의 배수가 아닙니다." );
		sc.close();
	}
}
