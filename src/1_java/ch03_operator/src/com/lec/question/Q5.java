package com.lec.question;

import java.util.Scanner;

public class Q5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 System.out.print("국어 점수를 입력하세요");
		 int k = sc.nextInt();
		 System.out.print("영어 점수를 입력하세요");
		 int e = sc.nextInt();
		 System.out.print("수학 점수를 입력하세요");
		 int m = sc.nextInt();
		 System.out.printf("국어 점수 : %3d\n영어 점수 : %3d\n수학 점수 : %3d\n ", k , e, m);
		 int result = k+e+m;
		 System.out.printf("총점 : %d %c %d %c %d = %d\n", k, '+', e, '+', m, result);
		 double dr;
		 dr= result/(double)3;
		 System.out.printf("평균 : %d %c %f = %.2f", result,'/',(double)3, dr );
		 sc.close();
		 
	}
}
