package com.lec.question;

import java.util.Scanner;

public class Q5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 System.out.print("���� ������ �Է��ϼ���");
		 int k = sc.nextInt();
		 System.out.print("���� ������ �Է��ϼ���");
		 int e = sc.nextInt();
		 System.out.print("���� ������ �Է��ϼ���");
		 int m = sc.nextInt();
		 System.out.printf("���� ���� : %3d\n���� ���� : %3d\n���� ���� : %3d\n ", k , e, m);
		 int result = k+e+m;
		 System.out.printf("���� : %d %c %d %c %d = %d\n", k, '+', e, '+', m, result);
		 double dr;
		 dr= result/(double)3;
		 System.out.printf("��� : %d %c %f = %.2f", result,'/',(double)3, dr );
		 sc.close();
		 
	}
}
