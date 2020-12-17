//201217 kks exemple
package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerMain {
	public static void main(String[] args) {
		String a;
		String b;
		String c;
		String fs;
		Scanner sc = new Scanner(System.in);
		ArrayList<Customer> al = new ArrayList<Customer>();
		do {
			
			System.out.println("회원가입 하시겠습니까?(Y/N)");
			fs = sc.next();
			if(fs.equalsIgnoreCase("y")) {
				System.out.println("이름을 입력해 주세요");
				a = sc.next();
				System.out.println("전화번호를 입력해 주세요");
				b = sc.next();
				System.out.println("주소를 입력하세요");
				sc.nextLine();
				c = sc.nextLine();
				al.add(new Customer(a,b,c));
			}else if(fs.equalsIgnoreCase("n")) {
				break;
			}
			
		}while(true);
		System.out.println("가입된 회원 목록");
		for(Customer t : al) {
			System.out.println(t);
		}
		sc.close();
	}
}
