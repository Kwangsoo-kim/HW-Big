//20.12.15 kks scanner
package com.lec.ex09_scanner;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt(); // 실행하면 \n이 남는다
		System.out.println("입력하신 나이는 "+age);
		System.out.print("이름을 입력하세요 : ");
		String name = sc.next();// 버퍼에 처음 나오는 \n은 무시 whitespace가 나오는 전까지 취함
		System.out.println("입력하신 이름은 "+name);
		System.out.print("주소를 입력하세요");
		sc.nextLine(); //버퍼를 초기화(\n 때문)
		String address = sc.nextLine(); //버퍼에 \n이 나오는 앞까지 취함. 따라서 띄어쓰기 가능.
		System.out.println("입력하신 주소는 "+address);
		System.out.println("==========프로그램 끝============");
	}
}
