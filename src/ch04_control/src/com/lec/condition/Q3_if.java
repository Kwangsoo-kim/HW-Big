package com.lec.condition;

import java.util.Scanner;

public class Q3_if {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���� ������ �Է��ϼ���");
		int k = sc.nextInt();
		System.out.println("���� ������ �Է��ϼ���");
		int e = sc.nextInt();
		System.out.println("���� ������ �Է��ϼ���");
		int m = sc.nextInt();
		int all = k+e+m;
		double avg = all/3.0;
		if(k>=avg) {
			System.out.printf("���������� �������  %3.2f�� �̻��̴�\n", avg);
		}else {
			System.out.printf("���������� �������  %3.2f�� ���ϴ�\n", avg);
		}
		if(e>=avg) {
			System.out.printf("���������� �������  %3.2f�� �̻��̴�\n", avg);
		}else {
			System.out.printf("���������� �������  %3.2f�� ���ϴ�\n", avg);
		}if(m>=avg) {
			System.out.printf("���������� �������  %3.2f�� �̻��̴�\n", avg);
		}else {
			System.out.printf("���������� �������  %3.2f�� ���ϴ�\n", avg);
		}
		sc.close();
	}
}