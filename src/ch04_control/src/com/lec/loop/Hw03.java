package com.lec.loop;

import java.util.Scanner;

public class Hw03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

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
			} else if (you == -1) {
				System.out.println("�����մϴ�.");
				break;
			} else {
				System.out.println("����");
				continue;
			}
			int com = (int) (Math.random() * 3);
			if (com == 0) {
				System.out.println("��ǻ�ʹ� ����");
			} else if (com == 1) {
				System.out.println("��ǻ�ʹ� ����");
			} else {
				System.out.println("��ǻ�ʹ� ��");
			}
			if ((you + 2) % 3 == com) {
				System.out.println("����� �̰��");

			} else if (you == com) {
				System.out.println("����");

			} else {
				System.out.println("��ǻ�Ͱ� �̰��");

			}
		} while (you != -1);
		sc.close();
	}

}
