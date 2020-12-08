package com.lec.loop;

import java.util.Scanner;

public class Ex09_dowhile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		do {
			System.out.println("반드시 짝수를 입력하시오 :");
			num = sc.nextInt();
		}while(num%2==1|| num%2==-1);
		System.out.println("입력하신 짝수는 "+ num);
		sc.close();
	}
}
