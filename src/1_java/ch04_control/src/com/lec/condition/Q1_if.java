package com.lec.condition;

import java.util.Scanner;

public class Q1_if {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���밪���� ��ȯ��ų ���� �Է��Ͻÿ�");
		int j1 = sc.nextInt();
		if(j1>=0) {
			System.out.printf("���밪�� : %d\n", j1);
		}else {
			System.out.println("���밪�� : "+ -1*j1);
		}
		sc.close();
	
	}
}
