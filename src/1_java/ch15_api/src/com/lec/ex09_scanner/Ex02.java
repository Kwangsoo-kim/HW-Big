//20.12.15 kks scanner
package com.lec.ex09_scanner;

import java.util.Scanner;

//nextLine()이용->next()이용
public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("주소를 입력하세요: ");
		String add = sc.nextLine();
		System.out.println("입력하신 주소는 "+add);
		System.out.print("이름을 입력하세요");
		String na = sc.next();
		System.out.println("입력하신 이름은 "+na);
		System.out.println("나이를 입력하세요");
		int age = sc.nextInt();
		System.out.println("입력하신 나이는"+age);
	}

}
