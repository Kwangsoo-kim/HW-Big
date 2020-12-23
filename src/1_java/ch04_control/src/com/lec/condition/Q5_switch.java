package com.lec.condition;

import java.util.Scanner;

public class Q5_switch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요");
		int score = sc.nextInt();
		int temp = score==100 ? score-1 : score; //100점을 확실하게 연산하는 방법
		switch(temp/10) {
		case 9:
			System.out.println("A학점 입니다."); break;
		case 8:
			System.out.println("B학점 입니다."); break;
		case 7:
			System.out.println("C학점 입니다."); break;
		case 6:
			System.out.println("D학점 입니다."); break;
		case 5:
			System.out.println("F학점 입니다."); break;
		default:
			System.out.println("유효하지 않은 점수입니다."); break;
		}
		sc.close();
	}
}