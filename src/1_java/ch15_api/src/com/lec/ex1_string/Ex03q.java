package com.lec.ex1_string;

import java.util.Scanner;

public class Ex03q {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String i= null;
		
		int j;
		while(true) {
			System.out.println("��ȣ�� �Է��ض�");
			i =sc.next();
			if(i.equalsIgnoreCase("x")) break;
			System.out.println("�Է��� ��ȭ��ȣ : "+i);
			System.out.println("¦����° ���ڿ� : "+i.charAt(0)+i.charAt(2)+i.charAt(4)+i.charAt(6)+i.charAt(8)+i.charAt(10));
			System.out.println("���ڸ� �Ųٷ� : "+i.charAt(11)
											+i.charAt(10)
											+i.charAt(9)
											+i.charAt(8)
											+i.charAt(7)
											+i.charAt(6)
											+i.charAt(5)
											+i.charAt(4)
											+i.charAt(3)
											+i.charAt(2)
											+i.charAt(1)
											+i.charAt(0)
											);
			System.out.println("��ȭ��ȣ �� ���ڸ��� : "+i.substring(0,i.indexOf("-")));
			System.out.println("��ȭ��ȣ ���ڸ��� : "+i.substring(i.lastIndexOf("-")+1));
		
		}
	}
}
