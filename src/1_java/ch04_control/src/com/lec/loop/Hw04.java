package com.lec.loop;

import java.util.Scanner;

public class Hw04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int com = (int) (Math.random() * 3);
		int you;

		do {
			System.out.println("����, ����, �� �� �ϳ��� ���� : ");
			you = sc.nextInt();
			if (you == 0) {
				System.out.println("������ ���̳�");
			} else if (you == 1) {
				System.out.println("������ ���̳�");
			} else if (you == 2) {
				System.out.println("���� ���̳�");
			} else {
				System.out.println("����");
				continue;
			}
			com = (int) (Math.random() * 3);
			if (com == 0) {
				System.out.println("��ǻ�ʹ� ����");
			} else if (com == 1) {
				System.out.println("��ǻ�ʹ� ����");
			} else {
				System.out.println("��ǻ�ʹ� ��");
			}
			if ((you + 2) % 3 == com) {
				System.out.println("����� �̰��");
				break;

			} else if (you == com) {
				System.out.println("����");

			} else {
				System.out.println("��ǻ�Ͱ� �̰��");

			}
		} while ((you + 2) % 3 != com);
		sc.close();
	}

}
