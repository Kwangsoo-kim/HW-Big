//20.12.15 kks scanner
package com.lec.ex09_scanner;

import java.util.Scanner;

//nextLine()�̿�->next()�̿�
public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�ּҸ� �Է��ϼ���: ");
		String add = sc.nextLine();
		System.out.println("�Է��Ͻ� �ּҴ� "+add);
		System.out.print("�̸��� �Է��ϼ���");
		String na = sc.next();
		System.out.println("�Է��Ͻ� �̸��� "+na);
		System.out.println("���̸� �Է��ϼ���");
		int age = sc.nextInt();
		System.out.println("�Է��Ͻ� ���̴�"+age);
	}

}
