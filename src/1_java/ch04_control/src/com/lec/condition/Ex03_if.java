package com.lec.condition;

import java.util.Scanner;

public class Ex03_if {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print(" ù ��° ����?");
		int n1 = sc.nextInt();
		System.out.print(" �� ��° ����?");
		int n2 = sc.nextInt();
		if(n1>=n2) {
			System.out.println("�Է��Ͻ� ������ �ִ밪�� : "+ n1);
		}else {
			System.out.println("�Է����� ������ �ִ밪�� : "+ n2);
		}
		
		
		sc.close();
	}
}
