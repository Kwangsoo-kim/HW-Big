package com.lec.condition;

import java.util.Scanner;

public class Q5_switch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Է��ϼ���");
		int score = sc.nextInt();
		int temp = score==100 ? score-1 : score; //100���� Ȯ���ϰ� �����ϴ� ���
		switch(temp/10) {
		case 9:
			System.out.println("A���� �Դϴ�."); break;
		case 8:
			System.out.println("B���� �Դϴ�."); break;
		case 7:
			System.out.println("C���� �Դϴ�."); break;
		case 6:
			System.out.println("D���� �Դϴ�."); break;
		case 5:
			System.out.println("F���� �Դϴ�."); break;
		default:
			System.out.println("��ȿ���� ���� �����Դϴ�."); break;
		}
		sc.close();
	}
}