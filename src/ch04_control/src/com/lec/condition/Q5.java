package com.lec.condition;

import java.util.Scanner;

public class Q5 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("������ �Է��ϼ���");
		int score = sc.nextInt();
		if(score>=90 && score <=100) {
			System.out.println("A���� �Դϴ�.");
		}else if(score>=80 && score<90) {
			System.out.println("B���� �Դϴ�.");
		}else if(score>=70 && score<80) {
			System.out.println("C���� �Դϴ�.");
		}else if(score>=60 && score<70) {
			System.out.println("D���� �Դϴ�.");
		}else if(score>=0 && score<60) {
			System.out.println("F���� �Դϴ�.");
		}else {
			System.out.println("����");
		}
		sc.close();
	}
}
