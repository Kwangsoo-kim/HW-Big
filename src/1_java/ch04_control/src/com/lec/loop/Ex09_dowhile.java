package com.lec.loop;

import java.util.Scanner;

public class Ex09_dowhile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		do {
			System.out.println("�ݵ�� ¦���� �Է��Ͻÿ� :");
			num = sc.nextInt();
		}while(num%2==1|| num%2==-1);
		System.out.println("�Է��Ͻ� ¦���� "+ num);
		sc.close();
	}
}
