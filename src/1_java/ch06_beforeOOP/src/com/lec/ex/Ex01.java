package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
		int sum = 0; // 누적변수
		for (int i = 1; i < 11; i++) {
			sum += i;
		}
		System.out.println("합은 : " + sum);
		System.out.println((sum % 2 == 0) ? "짝수입니다" : "홀수입니다.");

		sum = 0; // 누적변수
		for (int i = 1; i < 11; i++) {
			sum += i;
		}
		System.out.println("합은 : " + sum);
		System.out.println((sum % 2 == 0) ? "짝수입니다" : "홀수입니다.");

		sum = 0; // 누적변수
		for (int i = 1; i < 11; i++) {
			sum += i;
		}
		System.out.println("합은 : " + sum);

		sum = 0; // 누적변수
		System.out.println((sum % 2 == 0) ? "짝수입니다" : "홀수입니다.");
		for (int i = 1; i < 11; i++) {
			sum += i;
		}
		System.out.println("합은 : " + sum);
		System.out.println((sum % 2 == 0) ? "짝수입니다" : "홀수입니다.");
	}

	int sum = 0; //누적변수
}
