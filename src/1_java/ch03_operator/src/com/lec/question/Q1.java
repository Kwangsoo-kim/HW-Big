package com.lec.question;

import java.util.Scanner;

public class Q1 {
	public static void main(String[] args) {
		//String name = "hong"; // new String("hong") �� ���� ���ε� String�� ���ܴ�.
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��Ͻÿ� : ");
		int i = sc.nextInt();
		System.out.println(i%3==0 ? "3�� ����Դϴ�" :"3�� ����� �ƴմϴ�." );
		sc.close();
	}
}
