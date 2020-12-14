package com.lec.ex1_string;

import java.util.Scanner;

public class Ex03q {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String i= null;
		
		int j;
		while(true) {
			System.out.println("번호를 입력해라");
			i =sc.next();
			if(i.equalsIgnoreCase("x")) break;
			System.out.println("입력한 전화번호 : "+i);
			System.out.println("짝수번째 문자열 : "+i.charAt(0)+i.charAt(2)+i.charAt(4)+i.charAt(6)+i.charAt(8)+i.charAt(10));
			System.out.println("문자를 거꾸로 : "+i.charAt(11)
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
			System.out.println("전화번호 맨 앞자리는 : "+i.substring(0,i.indexOf("-")));
			System.out.println("전화번호 뒷자리는 : "+i.substring(i.lastIndexOf("-")+1));
		
		}
	}
}
