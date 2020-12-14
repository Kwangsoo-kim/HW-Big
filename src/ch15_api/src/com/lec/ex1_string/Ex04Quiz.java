package com.lec.ex1_string;

import java.util.Scanner;

//I=checkIn(반납되었습니다 출력), O=checkOu(대출되었습니다 출력), X= 종료
public class Ex04Quiz {
	public static void main(String[] args) {
		
		String a;
		Scanner sc = new Scanner(System.in);
//		do {
//			System.out.println("I:CheckIm,O:CheckOut,x=exit ?");
//			a = sc.next();
//			if(a.equalsIgnoreCase("i")) {
//				System.out.println("반납되었습니다");
//			}else if(a.equalsIgnoreCase("o")) {
//				System.out.println("대출되었습니다.");
//			}
//			
//			
//		}while(!a.equalsIgnoreCase("x"));
		while(true) {
			System.out.println("I:CheckIm,O:CheckOut,x=exit ?");
			a=sc.next();
			if(a.equalsIgnoreCase("x")) {
				break;
			}else if(a.equalsIgnoreCase("i")) {
				System.out.println("반납되었습니다.");
			}else if(a.equalsIgnoreCase("o")) {
				System.out.println("대출되었습니다.");
			}
		}
		System.out.println("종료");
	}
	
}
