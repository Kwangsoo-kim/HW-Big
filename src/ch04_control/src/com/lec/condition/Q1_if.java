package com.lec.condition;

import java.util.Scanner;

public class Q1_if {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("절대값으로 변환시킬 수를 입력하시오");
		int j1 = sc.nextInt();
		if(j1>=0) {
			System.out.printf("절대값은 : %d\n", j1);
		}else {
			System.out.println("절대값은 : "+ -1*j1);
		}
		sc.close();
	
	}
}
