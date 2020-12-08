package com.lec.loop;

import java.util.Scanner;

public class Hw04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int com = (int) (Math.random() * 3);
		int you;

		do {
			System.out.println("가위, 바위, 보 중 하나를 선택 : ");
			you = sc.nextInt();
			if (you == 0) {
				System.out.println("가위를 내셨네");
			} else if (you == 1) {
				System.out.println("바위를 내셨네");
			} else if (you == 2) {
				System.out.println("보를 내셨네");
			} else {
				System.out.println("떼끼");
				continue;
			}
			com = (int) (Math.random() * 3);
			if (com == 0) {
				System.out.println("컴퓨터는 가위");
			} else if (com == 1) {
				System.out.println("컴퓨터는 바위");
			} else {
				System.out.println("컴퓨터는 보");
			}
			if ((you + 2) % 3 == com) {
				System.out.println("당신이 이겻다");
				break;

			} else if (you == com) {
				System.out.println("비겼다");

			} else {
				System.out.println("컴퓨터가 이겼다");

			}
		} while ((you + 2) % 3 != com);
		sc.close();
	}

}
