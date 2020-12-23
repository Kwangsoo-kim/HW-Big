//201216 kks example
package com.lec.ex5_book;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class BookMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf =new SimpleDateFormat("YYYY년 MM월 dd일(E)");
		String bt;
		String cod;
		String br;
		int fn = -1;
		int i;
		BookLib b1 = new BookLib("890r-01", "java", "자바맨");
		BookLib b2 = new BookLib("190c-05", "hadoop", "하둡맨");
		BookLib b3 = new BookLib("230r-03", "r", "알맨");
		BookLib[] b = { new BookLib("890r-01", "java", "자바맨"), 
				new BookLib("190c-05", "hadoop", "하둡맨"),
				new BookLib("230r-03", "r", "알맨"), 
				new BookLib("340s-08", "pyton", "파이썬맨") };
		do {
			System.out.println("원하는 메뉴를 입력해라 1.대출  2.반납  0.대출현황");
			try {	
				fn = sc.nextInt();
			}catch(java.util.InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("종료");
				break;
			}
			if (fn == 1) {
				System.out.println("대출을 원하는 책 이름을 입력하시오");
				bt = sc.next();
				for (i = 0; i < b.length; i++) {
					if (bt.equals(b[i].getBtt())) {
						b[i].prints();
						break;
					}
				}
				if (i == b.length) {
					System.out.println("책이름이 검색되지 않습니다. 다시 입력해 주세요");
					continue;
				}
				if (b[i].getState() == 0) {
					System.out.println("대출 하시는 분 성함을 입력해주세요");
					br = sc.next();
					System.out.println("대출 하시는 날짜를 입력해주세요");
					cod = sc.next();
					try {
						b[i].cOt(br);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} else {
					System.out.println("대출중인 상태입니다. 대출불가능 입니다.");
				}
			} else if (fn == 2) {
				System.out.println("반납을 원하는 책의 이름을 쓰세요");
				bt = sc.next();
				for (i = 0; i < b.length; i++) {
					if (bt.equals(b[i].getBtt())) {
						break;
					}
				}
				if (i == b.length) {
					System.out.println("책 이름이 검색되지 않습니다. 다시 시작해주세요");
					continue;
				}
				if (b[i].getState() == 1) {
					try {
						System.out.println(
								b[i].getBrr() + "님 " + sdf.format(b[i].getCod()) + "날 대출해가신 " + b[i].getBtt() + " " + "반납되었습니다.");
						b[i].cIn();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} else if (b[i].getState() == 0) {
					System.out.println("대출된 책이 아닙니다. 다시 시작해주세요.");
				}
			} else if (fn == 0) {
				for (BookLib bs : b) {
					bs.prints();
				}
			}//if
		} while (fn == 0 || fn == 1 || fn == 2);  //do

	} //main
} //class
