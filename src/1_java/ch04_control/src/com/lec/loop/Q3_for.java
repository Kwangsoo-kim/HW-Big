package com.lec.loop;

import java.util.Scanner;

public class Q3_for {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���ϴ� �ܼ��� �Է��ϼ���");
		int num = sc.nextInt();
		for(int i=1; i<10; i++) {
			System.out.printf("%d %c %d = %d\n",num,'*',i,num*i);
		}
		sc.close();
	}
}
