package com.lec.ex01_string;

import java.util.Scanner;

//I=checkIn(�ݳ��Ǿ����ϴ� ���), O=checkOu(����Ǿ����ϴ� ���), X= ����
public class Ex04Quiz {
	public static void main(String[] args) {
		
		String a;
		Scanner sc = new Scanner(System.in);
//		do {
//			System.out.println("I:CheckIm,O:CheckOut,x=exit ?");
//			a = sc.next();
//			if(a.equalsIgnoreCase("i")) {
//				System.out.println("�ݳ��Ǿ����ϴ�");
//			}else if(a.equalsIgnoreCase("o")) {
//				System.out.println("����Ǿ����ϴ�.");
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
				System.out.println("�ݳ��Ǿ����ϴ�.");
			}else if(a.equalsIgnoreCase("o")) {
				System.out.println("����Ǿ����ϴ�.");
			}
		}
		System.out.println("����");
	}
	
}
