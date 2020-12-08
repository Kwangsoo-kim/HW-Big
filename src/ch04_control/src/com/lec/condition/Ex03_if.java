package com.lec.condition;

import java.util.Scanner;

public class Ex03_if {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print(" 첫 번째 수는?");
		int n1 = sc.nextInt();
		System.out.print(" 두 번째 수는?");
		int n2 = sc.nextInt();
		if(n1>=n2) {
			System.out.println("입력하신 값들의 최대값은 : "+ n1);
		}else {
			System.out.println("입려가신 값들의 최대값은 : "+ n2);
		}
		
		
		sc.close();
	}
}
