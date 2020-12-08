package com.lec.question;
import java.util.Scanner;
public class Q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print(" 정수를 입력하세요: ");
		int n = sc.nextInt();
		System.out.println(n%2==0 ? "짝수 입니다.":"홀수 입니다.");
		sc.close();
	}

}
