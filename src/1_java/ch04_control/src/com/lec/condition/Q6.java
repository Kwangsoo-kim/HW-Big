package com.lec.condition;

import java.util.Scanner;

public class Q6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇월인지 쓰세요");
		int mon = sc.nextInt();
//switch절		
		switch(mon) {
		case 12:
			System.out.println("겨울입니다."); break;
		case 11:
			System.out.println("겨울입니다."); break;
		case 10:
			System.out.println("늦가을입니다."); break;
		case 9:
			System.out.println("가을입니다."); break;
		case 8:
			System.out.println("여름입니다."); break;
		case 7:
			System.out.println("여름입니다."); break;
		case 6:
			System.out.println("여름입니다."); break;
		case 5:
			System.out.println("봄입니다."); break;
		case 4:
			System.out.println("봄입니다."); break;
		case 3:
			System.out.println("봄입니다."); break;
		case 2:
			System.out.println("겨울입니다."); break;
		case 1:
			System.out.println("겨울입니다."); break;
		default:
			System.out.println("떼끼");
		}
//if절		
		if(mon==11 || mon==12 || mon==1 || mon==2) {
			System.out.println("겨울입니다.");
		}else if(mon==9 || mon==10) {
			System.out.println("가을입니다.");
		}else if(mon==6 || mon==7 || mon==8) {
			System.out.println("여름입니다.");
		}else if(mon==3 || mon==4 || mon==5) {
			System.out.println("봄입니다.");
		}else {
			System.out.println("떼끼"); 
		}
		sc.close();
	}
}
