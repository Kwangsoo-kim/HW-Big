//201217 kks exemple
package com.lec.ex2_map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class CustomerMain {
	public static void main(String[] args) {
		String pn;
		String n;
		String add;
		String t;
		Scanner sc = new Scanner(System.in);
		HashMap<String,Customer> hm = new HashMap<String, Customer>();
		while(true) {
			System.out.println("회원가입을 원하시나요?(Y/n)");
			t = sc.next();
			if(t.equalsIgnoreCase("y")) {
				System.out.println("이름을 입력해 주세요");
				n = sc.next();
				System.out.println("전화번호를 입력해 주세요");
				pn = sc.next();
				System.out.println("주소를 입력해 주세요");
				sc.nextLine();
				add = sc.nextLine();
				hm.put(pn, new Customer(n, pn, add));
			}else if(t.equalsIgnoreCase("n")) {
				break;
			}
		}
		Iterator<String> it = hm.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(hm.get(key));
		}
		sc.close();
	}
}
