package com.lec.condition;

import java.util.Scanner;

public class Q3_if {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("국어 점수를 입력하세요");
		int k = sc.nextInt();
		System.out.println("영어 점수를 입력하세요");
		int e = sc.nextInt();
		System.out.println("수학 점수를 입력하세요");
		int m = sc.nextInt();
		int all = k+e+m;
		double avg = all/3.0;
		if(k>=avg) {
			System.out.printf("국어점수는 평균점수  %3.2f점 이상이다\n", avg);
		}else {
			System.out.printf("국어점수는 평균점수  %3.2f점 이하다\n", avg);
		}
		if(e>=avg) {
			System.out.printf("영어점수는 평균점수  %3.2f점 이상이다\n", avg);
		}else {
			System.out.printf("영어점수는 평균점수  %3.2f점 이하다\n", avg);
		}if(m>=avg) {
			System.out.printf("수학점수는 평균점수  %3.2f점 이상이다\n", avg);
		}else {
			System.out.printf("수학점수는 평균점수  %3.2f점 이하다\n", avg);
		}
		sc.close();
	}
}